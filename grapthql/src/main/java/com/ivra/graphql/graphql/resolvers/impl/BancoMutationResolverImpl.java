package com.ivra.graphql.graphql.resolvers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ivra.graphql.graphql.model.Banco;
import com.ivra.graphql.graphql.resolvers.BancoMutationResolver;
import com.ivra.graphql.graphql.service.BancoService;

@Component
public class BancoMutationResolverImpl implements BancoMutationResolver, GraphQLMutationResolver {

	@Autowired
	private BancoService bancoService;
	
	public Banco registrarBanco(final String nombre, final String clave, final String fechaRegistro) {
		return bancoService.registrarBanco(nombre, clave, fechaRegistro);
	}
}
