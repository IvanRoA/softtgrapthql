package com.ivra.graphql.graphql.service;

import java.util.List;

import com.ivra.graphql.graphql.model.Cliente;

public interface ClienteService {

	Cliente findById(Long id);

	List<Cliente> findAll(int registros);

	Cliente save(Cliente cliente);

	Cliente update(Cliente cliente);

	Cliente deleteById(Long id);
	
}
