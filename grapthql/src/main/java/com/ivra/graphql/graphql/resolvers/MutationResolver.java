package com.ivra.graphql.graphql.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ivra.graphql.graphql.model.Banco;
import com.ivra.graphql.graphql.model.Cliente;
import com.ivra.graphql.graphql.service.BancoService;
import com.ivra.graphql.graphql.service.ClienteService;

@Component
public class MutationResolver implements GraphQLMutationResolver {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private BancoService bancoService;
	
	public Cliente registrarCliente(final String nombre, String correo, 
			final String apellidoPaterno, final String apellidoMaterno) {
		return clienteService.registrarCliente(nombre, correo, apellidoPaterno, apellidoMaterno);
	}
	
	public Banco registrarBanco(final String nombre, final String clave, final String fechaRegistro) {
		return bancoService.registrarBanco(nombre, clave, fechaRegistro);
	}
}
