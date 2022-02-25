package com.ivra.graphql.graphql.service;

import java.util.List;

import com.ivra.graphql.graphql.model.CatalogoD;

public interface CatalogoDService {
	
public CatalogoD findById(Long id);
	
	public CatalogoD save(CatalogoD catalogoD);
	
	public CatalogoD deleteById(Long id);
	
	public CatalogoD update(CatalogoD catalogoD);
	
	public List<CatalogoD> findAll(int limit);

}
