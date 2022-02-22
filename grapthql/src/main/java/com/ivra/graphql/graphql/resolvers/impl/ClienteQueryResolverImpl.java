package com.ivra.graphql.graphql.resolvers.impl;

import java.util.List;
import java.util.Optional;

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
	
	public List<Cliente> clientes(final int registros) {
		return clienteService.clientes(registros);
	}
	
	public Optional<Cliente> cliente(final int id) {
		return clienteService.cliente(id);
	}
}
