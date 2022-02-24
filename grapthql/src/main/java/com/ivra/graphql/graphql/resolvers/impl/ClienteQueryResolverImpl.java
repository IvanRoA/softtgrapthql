package com.ivra.graphql.graphql.resolvers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ivra.graphql.graphql.model.Cliente;
import com.ivra.graphql.graphql.resolvers.ClienteQueryResolver;
import com.ivra.graphql.graphql.service.ClienteService;

@Component
public class ClienteQueryResolverImpl implements ClienteQueryResolver, GraphQLQueryResolver {

	@Autowired
	private ClienteService clienteService;
	
	@Override
	public Cliente findClienteById(Long idCliente) {
		return clienteService.findById(idCliente);
	}

	@Override
	public List<Cliente> findAllCliente(int limit) {
		return clienteService.findAll(limit);
	}
}
