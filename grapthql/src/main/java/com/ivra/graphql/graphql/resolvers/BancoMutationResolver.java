package com.ivra.graphql.graphql.resolvers;

import com.ivra.graphql.graphql.model.Banco;

public interface BancoMutationResolver {

	Banco saveBanco(String nombre, String clave, String fechaRegistro);

	Banco deleteBanco(Long id);

	Banco updateBanco(Long id, String nombre, String clave, String fechaRegistro);
	
}
