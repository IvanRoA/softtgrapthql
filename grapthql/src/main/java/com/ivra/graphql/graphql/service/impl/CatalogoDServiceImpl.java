package com.ivra.graphql.graphql.service.impl;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ivra.graphql.graphql.exception.NotFoundException;
import com.ivra.graphql.graphql.model.CatalogoD;
import com.ivra.graphql.graphql.repository.CatalogoDRepository;
import com.ivra.graphql.graphql.service.CatalogoDService;

@Service
public class CatalogoDServiceImpl implements CatalogoDService{
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired 
	CatalogoDRepository catalogoDRepository;
	
	@Value("${catalogs.separator}")
	private String CATALOGS_SEPARATOR;
	
	Logger logger = LoggerFactory.getLogger(CatalogoDServiceImpl.class);

	@Override
	public CatalogoD findById(Long id) {
		Optional<CatalogoD> cuentaOptional = catalogoDRepository.findById(id);

		if(cuentaOptional.isPresent()) {
			return cuentaOptional.get();
		}
		throw new NotFoundException("No existe la cuenta", "Cuenta");
	}

	@Override
	public CatalogoD save(CatalogoD catalogoD) {
		return catalogoDRepository.save(catalogoD);
	}

	@Override
	public CatalogoD deleteById(Long id) {
		CatalogoD cuenta =  findById(id);
		catalogoDRepository.delete(cuenta);
		return cuenta;
	}

	@Override
	public CatalogoD update(CatalogoD catalogoD) {
		CatalogoD catalogoDPersist = findById(catalogoD.getProcessDate());
		catalogoDPersist.setRelCatId(catalogoD.getRelCatId());
		catalogoDPersist.setFullDesc(catalogoD.getFullDesc());
		catalogoDPersist.setShortDesc(catalogoD.getShortDesc());
		catalogoDPersist.setScreenDesc(catalogoD.getScreenDesc());
		catalogoDPersist.setAbbreviation(catalogoD.getAbbreviation());
		return catalogoDRepository.save(catalogoDPersist);
	}

	@Override
	public List<CatalogoD> findAll(int limit) {
		return catalogoDRepository.findAll();
	}
	
	@Override
	public List<CatalogoD> findBy(String filter,String separator){
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
		CriteriaQuery<CatalogoD> cq = cb.createQuery(CatalogoD.class);
		Root<CatalogoD> catalogoD = cq.from(CatalogoD.class);
		List<Predicate> predicates = new ArrayList<>();
		mapeoParametros.removeIf(mp->
			mp.getKey().equals(("limit"))
		);
		mapeoParametros.forEach(mp->{
			predicates.add(catalogoD.get(mp.getKey()).in((String[])mp.getValue()));
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
