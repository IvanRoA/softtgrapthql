package com.ivra.graphql.graphql.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ivra.graphql.graphql.model.Cliente;
import com.ivra.graphql.graphql.service.ClienteService;

@Component
public class ClienteMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private ClienteService clienteService;
	
	public Cliente registrarCliente(final String nombre, String correo, 
			final String apellidoPaterno, final String apellidoMaterno) {
		return clienteService.registrarCliente(nombre, correo, apellidoPaterno, apellidoMaterno);
	}
}
