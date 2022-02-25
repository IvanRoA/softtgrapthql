package com.ivra.graphql.graphql.service;

import java.util.List;

import com.ivra.graphql.graphql.model.CatalogoT;

public interface CatalogoTService {

	CatalogoT findById(Long processDate);

	List<CatalogoT> findAll(int registros);

	CatalogoT save(CatalogoT catalogoT);

	CatalogoT update(CatalogoT catalogoT);

	CatalogoT deleteById(Long processDate);
	
	List<CatalogoT> findBy(String filter,String separator);

}
