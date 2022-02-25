package com.ivra.graphql.graphql.resolvers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ivra.graphql.graphql.model.Banco;
import com.ivra.graphql.graphql.model.CatalogoT;
import com.ivra.graphql.graphql.resolvers.CatalogoTQueryResolver;
import com.ivra.graphql.graphql.service.CatalogoTService;

@Component
public class CatalogoTQueryResolverImpl implements CatalogoTQueryResolver, GraphQLQueryResolver {

	@Autowired
	private CatalogoTService catalogoTService;

	@Override
	public CatalogoT findCatalogoTById(Long processDate) {
		return catalogoTService.findById(processDate);
	}

	@Override
	public List<CatalogoT> findAllCatalogoT(int limit) {
		return catalogoTService.findAll(limit);
	}

	@Override
	public List<CatalogoT> findCatalogoTByFilter(String filter,String separator) {
		return catalogoTService.findBy(filter,separator);
	}
}
