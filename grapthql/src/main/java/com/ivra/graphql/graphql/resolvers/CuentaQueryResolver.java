package com.ivra.graphql.graphql.resolvers;

import java.util.List;

import com.ivra.graphql.graphql.model.Cuenta;

public interface CuentaQueryResolver {
	
	public Cuenta findCuentaById(Long idCuenta);
	
	public List<Cuenta> findAllCuenta(int limit);

}
