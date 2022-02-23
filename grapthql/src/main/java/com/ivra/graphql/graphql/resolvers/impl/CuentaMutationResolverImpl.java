package com.ivra.graphql.graphql.resolvers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ivra.graphql.graphql.model.Cuenta;
import com.ivra.graphql.graphql.resolvers.CuentaMutationResolver;
import com.ivra.graphql.graphql.service.CuentaService;

@Component
public class CuentaMutationResolverImpl implements CuentaMutationResolver, GraphQLMutationResolver {
	
	@Autowired
	private CuentaService cuentaService;

	@Override
	public Cuenta saveCuenta(String numeroCuenta, String clave) {
		return cuentaService.save(new Cuenta(null, numeroCuenta, clave));
	}

	@Override
	public Cuenta deleteCuenta(Long id) {
		return cuentaService.deleteById(id);
	}

	@Override
	public Cuenta updateCuenta(Long id, String numeroCuenta, String clave) {
		return cuentaService.update(new Cuenta(id, numeroCuenta, clave));
	}

}
