package com.ivra.graphql.graphql.resolvers;

import java.util.List;
import java.util.Optional;

import com.ivra.graphql.graphql.model.Banco;

public interface BancoQueryResolver {

	public Optional<Banco> banco(final int id);
	
	public List<Banco> bancos(final int registros);
	
}
