package com.ivra.graphql.graphql.resolvers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ivra.graphql.graphql.model.Banco;
import com.ivra.graphql.graphql.resolvers.BancoQueryResolver;
import com.ivra.graphql.graphql.service.BancoService;

@Component
public class BancoQueryResolverImpl implements BancoQueryResolver, GraphQLQueryResolver {

	@Autowired
	private BancoService bancoService;
	
	@Override
	public Banco findBancoById(Long idBanco) {
		return bancoService.findById(idBanco);
	}

	@Override
	public List<Banco> findAllBanco(int limit) {
		return bancoService.findAll(limit);
	}

	@Override
	public List<Banco> findBancosByFilter(String filter,String separator) {
		return bancoService.findBy(filter,separator);
	}
	
}
