package com.ivra.graphql.graphql.service;

import java.util.List;

import com.ivra.graphql.graphql.model.Banco;

public interface BancoService {

	Banco save(Banco banco);

	Banco findById(Long id);

	List<Banco> findAll(int registros);

	Banco update(Banco banco);

	Banco deleteById(Long id);

}
