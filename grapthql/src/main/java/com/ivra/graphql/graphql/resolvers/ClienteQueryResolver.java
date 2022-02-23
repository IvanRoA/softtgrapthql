package com.ivra.graphql.graphql.resolvers;

import java.util.List;
import java.util.Optional;

import com.ivra.graphql.graphql.model.Cliente;

public interface ClienteQueryResolver {

	public List<Cliente> clientes(final int registros);
	
	public Optional<Cliente> cliente(final int id);
	
}
