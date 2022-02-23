package com.ivra.graphql.graphql.resolvers;

import com.ivra.graphql.graphql.model.Cliente;

public interface ClienteMutationResolver {

	public Cliente registrarCliente(final String nombre, String correo, 
			final String apellidoPaterno, final String apellidoMaterno);
	
}
