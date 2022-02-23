package com.ivra.graphql.graphql.resolvers.impl;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Banco> banco(final int id){
		return bancoService.banco(id);
	}
	
	public List<Banco> bancos(final int registros){
		return bancoService.bancos(registros);
	}
	
}
