package com.ivra.graphql.graphql.resolvers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import com.ivra.graphql.graphql.model.Cliente;
import com.ivra.graphql.graphql.service.ClienteService;

@Component
public class ClienteQueryResolver implements GraphQLQueryResolver {

	@Autowired
	private ClienteService ClienteService;
	
	public List<Cliente> clientes(final int registros) {
		return ClienteService.clientes(registros);
	}
	
	public Optional<Cliente> cliente(final int id) {
		return ClienteService.cliente(id);
	}
}
