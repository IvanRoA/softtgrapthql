package com.ivra.graphql.graphql.resolvers;

import com.ivra.graphql.graphql.model.Cliente;

public interface ClienteMutationResolver {

	Cliente saveCliente(String nombre, String correo, String apellidoPaterno, String apellidoMaterno);

	Cliente deleteCliente(Long id);

	Cliente updateCliente(Long id, String nombre, String correo, String apellidoPaterno, String apellidoMaterno);
	
}
