package com.ivra.graphql.graphql.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ivra.graphql.graphql.model.Banco;
import com.ivra.graphql.graphql.model.Cliente;
import com.ivra.graphql.graphql.model.Cuenta;
import com.ivra.graphql.graphql.service.BancoService;
import com.ivra.graphql.graphql.service.ClienteService;
import com.ivra.graphql.graphql.service.CuentaService;

@Component
public class MutationResolver implements GraphQLMutationResolver {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private BancoService bancoService;
	
	@Autowired 
	private CuentaService cuentaService;
	
	public Cliente registrarCliente(final String nombre, String correo, 
			final String apellidoPaterno, final String apellidoMaterno) {
		return clienteService.registrarCliente(nombre, correo, apellidoPaterno, apellidoMaterno);
	}
	
	public Banco registrarBanco(final String nombre, final String clave, final String fechaRegistro) {
		return bancoService.registrarBanco(nombre, clave, fechaRegistro);
	}
	
	public Cuenta registrarCuenta(String numeroCuenta, String clave) {
		return cuentaService.save(new Cuenta(null, numeroCuenta, clave));
	}
}
