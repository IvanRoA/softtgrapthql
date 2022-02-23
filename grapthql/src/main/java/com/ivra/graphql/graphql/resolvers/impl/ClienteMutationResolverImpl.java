package com.ivra.graphql.graphql.resolvers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ivra.graphql.graphql.model.Cliente;
import com.ivra.graphql.graphql.resolvers.ClienteMutationResolver;
import com.ivra.graphql.graphql.service.ClienteService;

@Component
public class ClienteMutationResolverImpl implements ClienteMutationResolver, GraphQLMutationResolver {

	@Autowired
	private ClienteService clienteService;
	
	public Cliente registrarCliente(final String nombre, String correo, 
			final String apellidoPaterno, final String apellidoMaterno) {
		return clienteService.registrarCliente(nombre, correo, apellidoPaterno, apellidoMaterno);
	}

}
