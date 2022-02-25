package com.ivra.graphql.graphql.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.ivra.graphql.graphql.model.Cuenta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ivra.graphql.graphql.exception.NotFoundException;
import com.ivra.graphql.graphql.model.Banco;
import com.ivra.graphql.graphql.repository.BancoRepository;
import com.ivra.graphql.graphql.service.BancoService;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class BancoServiceImpl implements BancoService {

	@PersistenceContext
	EntityManager em;

	@Autowired
	private BancoRepository bancoRepository;
	@Value("${catalogs.separator}")
	private String CATALOGS_SEPARATOR;

	Logger logger = LoggerFactory.getLogger(BancoServiceImpl.class);
	@Override
	public Banco findById(final Long id){
		Optional<Banco> banco = bancoRepository.findById(id);
		if(banco.isPresent()) {
			return banco.get();
		}
		throw new NotFoundException("No existe el banco","Banco");
	}
	
	@Override
	public List<Banco> findAll(final int registros){
		return bancoRepository.findAll(Pageable.ofSize(registros)).getContent();
	}
	
	@Override
	public Banco save(Banco banco) {
		return bancoRepository.save(banco);
	}
	
	@Override
	public Banco update(Banco banco) {
		Banco ban = findById(banco.getId());
		ban.setNombre(banco.getNombre());
		ban.setClave(banco.getClave());
		ban.setFechaRegistro(banco.getFechaRegistro());
		return bancoRepository.save(ban);
	}
	
	@Override
	public Banco deleteById(Long id) {
		Banco banco = findById(id);
		bancoRepository.delete(banco);
		return banco;
	}

	@Override
	public List<Banco> findBy(String filter,String separator){
		if(separator == null){
			separator = CATALOGS_SEPARATOR;
		}
		logger.info("Separador: "+separator);
		String[] params = filter.split(separator);
		List<AbstractMap.SimpleEntry<String,Object>> mapeoParametros = new ArrayList<>();
		if(params.length > 0) {
			Arrays.stream(params).forEach(s -> {
				String[] keyValue = s.split("=");
				String[] values = keyValue[1].split(CATALOGS_SEPARATOR);
				mapeoParametros.add(new AbstractMap.SimpleEntry<>(keyValue[0], values));
			});
		}

		 Optional<AbstractMap.SimpleEntry<String,Object>> paramLimit = mapeoParametros.stream().filter(m->
			m.getKey().equals("limit")
		).findAny();
		Integer limite = null;
		if(paramLimit.isPresent()){
			limite = Integer.parseInt(((String[])paramLimit.get().getValue())[0]);
		}
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Banco> cq = cb.createQuery(Banco.class);
		Root<Banco> banco = cq.from(Banco.class);
		List<Predicate> predicates = new ArrayList<>();
		mapeoParametros.removeIf(mp->
			mp.getKey().equals(("limit"))
		);
		mapeoParametros.forEach(mp->{
			predicates.add(banco.get(mp.getKey()).in((String[])mp.getValue()));
		});
		cq.where(predicates.toArray(new Predicate[0]));
		Query q = em.createQuery(cq);
		if(limite != null){
			logger.info("Limite: {}",limite);
			q.setMaxResults(limite);
		}

		//logger.info("Parametros: {}", Arrays.toString(mapeoParametros.toArray()));
		return q.getResultList();
	}
}
