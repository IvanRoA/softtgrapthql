package com.ivra.graphql.graphql.resolvers;

import java.util.List;

import com.ivra.graphql.graphql.model.Cliente;

public interface ClienteQueryResolver {

	Cliente findClienteById(Long idCliente);

	List<Cliente> findAllCliente(int limit);
	
}
