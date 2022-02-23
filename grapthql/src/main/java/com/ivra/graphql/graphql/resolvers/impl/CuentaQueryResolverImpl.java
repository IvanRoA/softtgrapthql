package com.ivra.graphql.graphql.resolvers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ivra.graphql.graphql.model.Cuenta;
import com.ivra.graphql.graphql.resolvers.CuentaQueryResolver;
import com.ivra.graphql.graphql.service.CuentaService;

@Component
public class CuentaQueryResolverImpl implements CuentaQueryResolver, GraphQLQueryResolver {
	
	@Autowired
	private CuentaService cuentaService;

	@Override
	public Cuenta findCuentaById(Long idCuenta) {
		return cuentaService.findById(idCuenta);
	}

	@Override
	public List<Cuenta> findAllCuenta(int limit) {
		return cuentaService.findAll(limit);
	}

}
