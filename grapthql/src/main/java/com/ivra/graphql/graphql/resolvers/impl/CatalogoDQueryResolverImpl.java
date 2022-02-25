package com.ivra.graphql.graphql.resolvers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ivra.graphql.graphql.model.CatalogoD;
import com.ivra.graphql.graphql.resolvers.CatalogoDQueryResolver;
import com.ivra.graphql.graphql.service.CatalogoDService;

@Component
public class CatalogoDQueryResolverImpl implements CatalogoDQueryResolver, GraphQLQueryResolver {
	
	@Autowired
	private CatalogoDService cuentaService;

	@Override
	public CatalogoD findCatalogoDById(Long idCatalogoD) {
		return cuentaService.findById(idCatalogoD);
	}

	@Override
	public List<CatalogoD> findAllCatalogoD(int limit) {
		return cuentaService.findAll(limit);
	}

}
