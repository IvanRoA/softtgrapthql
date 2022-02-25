package com.ivra.graphql.graphql.service;

import java.util.List;

import com.ivra.graphql.graphql.model.CatalogoD;

public interface CatalogoDService {
	
	CatalogoD findById(Long id);
	
	CatalogoD save(CatalogoD catalogoD);
	
	CatalogoD deleteById(Long id);
	
	CatalogoD update(CatalogoD catalogoD);
	
	List<CatalogoD> findAll(int limit);
	
	List<CatalogoD> findBy(String filter,String separator);

}
