package com.ivra.graphql.graphql.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ivra.graphql.graphql.model.Cliente;
import com.ivra.graphql.graphql.repository.ClienteRepository;

@Service
public class ClienteService {

	private ClienteRepository repo;
	
	public ClienteService(ClienteRepository repo) {
		this.repo = repo;
	}
	
	public Cliente registrarCliente(final String nombre, final String correo
			, final String apellidoPaterno, final String apellidoMaterno) {
		Cliente p = new Cliente(nombre, correo, apellidoPaterno, apellidoMaterno);
		return repo.save(p);
	}
	
	public Optional<Cliente> cliente(final int id) {
		return repo.findById(id);
	}
	
	public List<Cliente> clientes(final int registros) {
		return repo.findAll().stream().limit(registros).collect(Collectors.toList());
	}
}
