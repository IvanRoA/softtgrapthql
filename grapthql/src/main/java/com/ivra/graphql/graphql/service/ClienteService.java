package com.ivra.graphql.graphql.service;

import java.util.List;
import java.util.Optional;

import com.ivra.graphql.graphql.model.Cliente;

public interface ClienteService {

	public Cliente registrarCliente(final String nombre, final String correo
			, final String apellidoPaterno, final String apellidoMaterno);
	
	public Optional<Cliente> cliente(final int id);
	
	public List<Cliente> clientes(final int registros);
	
}
