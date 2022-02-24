package com.ivra.graphql.graphql.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ivra.graphql.graphql.exception.NotFoundException;
import com.ivra.graphql.graphql.model.Cliente;
import com.ivra.graphql.graphql.repository.ClienteRepository;
import com.ivra.graphql.graphql.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente findById(final Long id){
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if(cliente.isPresent()) {
			return cliente.get();
		}
		throw new NotFoundException("No existe el cliente", "Cliente");
	}
	
	@Override
	public List<Cliente> findAll(final int registros){
		return clienteRepository.findAll(Pageable.ofSize(registros)).getContent();
	}
	
	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@Override
	public Cliente update(Cliente cliente) {
		Cliente cli = findById(cliente.getId());
		cli.setNombre(cliente.getNombre());
		cli.setCorreo(cliente.getCorreo());
		cli.setApellidoPaterno(cliente.getApellidoPaterno());
		cli.setApellidoMaterno(cliente.getApellidoMaterno());
		return clienteRepository.save(cli);
	}
	
	@Override
	public Cliente deleteById(Long id) {
		Cliente cliente = findById(id);
		clienteRepository.delete(cliente);
		return cliente;
	}
}
