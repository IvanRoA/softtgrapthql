package com.ivra.graphql.graphql.resolvers;

import com.ivra.graphql.graphql.model.Banco;

public interface BancoMutationResolver {

	public Banco registrarBanco(final String nombre, final String clave, final String fechaRegistro);
	
}
