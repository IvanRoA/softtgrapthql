package com.ivra.graphql.graphql.resolvers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ivra.graphql.graphql.model.Colonia;
import com.ivra.graphql.graphql.resolvers.ColoniaQueryResolver;
import com.ivra.graphql.graphql.service.ColoniaService;

@Component
public class ColoniaQueryResolverImpl implements ColoniaQueryResolver, GraphQLQueryResolver {

	@Autowired
	private ColoniaService coloniaService;

	@Override
	public Colonia findColoniaById(Long idColonia) {
		return coloniaService.findById(idColonia);
	}

	@Override
	public List<Colonia> findAllColonia(int limit) {
		return coloniaService.findAll(limit);
	}
}
