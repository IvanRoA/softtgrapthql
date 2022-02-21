package com.ivra.graphql.graphql.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ivra.graphql.graphql.model.Banco;
import com.ivra.graphql.graphql.service.BancoService;

@Component
public class BancoMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private BancoService bancoService;
	
	public Banco registrarBanco(final String nombre, final String clave, final String fecRegistro) {
		return bancoService.registrarBanco(nombre, clave, fecRegistro);
	}
}
