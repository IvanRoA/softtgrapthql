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

	@Override
	public Cliente saveCliente(String nombre, String correo, String apellidoPaterno, String apellidoMaterno) {
		return clienteService.save(new Cliente(nombre, correo, apellidoPaterno, apellidoMaterno));
	}

	@Override
	public Cliente deleteCliente(Long id) {
		return clienteService.deleteById(id);
	}

	@Override
	public Cliente updateCliente(Long id, String nombre, String correo, String apellidoPaterno, String apellidoMaterno) {
		return clienteService.update(new Cliente(id, nombre, correo, apellidoPaterno, apellidoMaterno));
	}
}
