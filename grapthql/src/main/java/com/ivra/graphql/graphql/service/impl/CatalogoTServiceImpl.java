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
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ivra.graphql.graphql.exception.NotFoundException;
import com.ivra.graphql.graphql.model.Banco;
import com.ivra.graphql.graphql.model.CatalogoT;
import com.ivra.graphql.graphql.repository.CatalogoTRepository;
import com.ivra.graphql.graphql.service.CatalogoTService;

@Service
public class CatalogoTServiceImpl implements CatalogoTService {
	
	@PersistenceContext
	EntityManager em;

	@Autowired
	private CatalogoTRepository catalogoTRepository;
	
	@Value("${catalogs.separator}")
	private String CATALOGS_SEPARATOR;
	
	Logger logger = LoggerFactory.getLogger(CatalogoTServiceImpl.class);
	
	@Override
	public CatalogoT findById(final Long processDate){
		Optional<CatalogoT> catalogoT = catalogoTRepository.findById(processDate);
		if(catalogoT.isPresent()) {
			return catalogoT.get();
		}
		throw new NotFoundException("No existe el catalogoT", "CatalogoT");
	}
	
	@Override
	public List<CatalogoT> findAll(final int registros){
		return catalogoTRepository.findAll(Pageable.ofSize(registros)).getContent();
	}
	
	@Override
	public CatalogoT save(CatalogoT catalogoT) {
		return catalogoTRepository.save(catalogoT);
	}
	
	@Override
	public CatalogoT update(CatalogoT catalogoT) {
		CatalogoT cat = findById(catalogoT.getProcessDate());
		cat.setHora(catalogoT.getHora());
		cat.setMoneda(catalogoT.getMoneda());
		cat.setPrecio(catalogoT.getPrecio());
		cat.setSiefore(catalogoT.getSiefore());
		cat.setValor(catalogoT.getValor());
		cat.setCol2(catalogoT.getCol2());
		cat.setCol3(catalogoT.getCol3());
		cat.setCol4(catalogoT.getCol4());
		cat.setCol5(catalogoT.getCol5());
		cat.setCol6(catalogoT.getCol6());
		cat.setCol7(catalogoT.getCol7());
		cat.setCol8(catalogoT.getCol8());
		cat.setCol9(catalogoT.getCol9());
		cat.setCveIva(catalogoT.getCveIva());
		cat.setTasaIva(catalogoT.getTasaIva());
		cat.setISR(catalogoT.getISR());
		cat.setIndice(catalogoT.getIndice());
		cat.setRegion(catalogoT.getRegion());
		cat.setPlazo(catalogoT.getPlazo());
		cat.setT_bruta(catalogoT.getT_bruta());
		cat.setLim_inf(catalogoT.getLim_inf());
		cat.setLim_sup(catalogoT.getLim_sup());
		cat.setDivMet(catalogoT.getDivMet());
		cat.setDenomin(catalogoT.getDenomin());
		cat.setVenta(catalogoT.getVenta());
		cat.setCveTc(catalogoT.getCveTc());
		cat.setCompra(catalogoT.getCompra());
		cat.setDiario(catalogoT.getDiario());
		cat.setMensual(catalogoT.getMensual());
		cat.setAnual(catalogoT.getAnual());
		return catalogoTRepository.save(cat);
	}
	
	@Override
	public CatalogoT deleteById(Long processDate) {
		CatalogoT catalogoT = findById(processDate);
		catalogoTRepository.delete(catalogoT);
		return catalogoT;
	}

	@Override
	public List<CatalogoT> findBy(String filter,String separator){
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
		CriteriaQuery<CatalogoT> cq = cb.createQuery(CatalogoT.class);
		Root<CatalogoT> catalogoT = cq.from(CatalogoT.class);
		List<Predicate> predicates = new ArrayList<>();
		mapeoParametros.removeIf(mp->
			mp.getKey().equals(("limit"))
		);
		mapeoParametros.forEach(mp->{
			predicates.add(catalogoT.get(mp.getKey()).in((String[])mp.getValue()));
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
