package com.ivra.graphql.graphql.service;

import java.util.List;
import java.util.Optional;

import com.ivra.graphql.graphql.model.Banco;

public interface BancoService {

	public Banco registrarBanco(final String nombre, final String clave, String fechaRegistro);
	
	public Optional<Banco> banco(final int id);
	
	public List<Banco> bancos(final int registros);
}
