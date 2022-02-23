package com.ivra.graphql.graphql.resolvers;

import com.ivra.graphql.graphql.model.Cuenta;

public interface CuentaMutationResolver {
	
	public Cuenta saveCuenta(String numeroCuenta, String clave);
	
	public Cuenta deleteCuenta(Long id);
	
	public Cuenta updateCuenta(Long id, String numeroCuenta, String clave);
	
}
