package com.ivra.graphql.graphql.service;

import com.ivra.graphql.graphql.model.Cuenta;

public interface CuentaService {
	
	public Cuenta findById(Long id);
	
	public Cuenta save(Cuenta cuenta);

}
