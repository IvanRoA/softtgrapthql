package com.ivra.graphql.graphql.resolvers;

import java.util.List;

import com.ivra.graphql.graphql.model.Banco;

public interface BancoQueryResolver {

	Banco findBancoById(Long idBanco);

	List<Banco> findAllBanco(int limit);
	
}
