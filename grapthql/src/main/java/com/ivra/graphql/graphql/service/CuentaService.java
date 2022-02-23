package com.ivra.graphql.graphql.service;

import java.util.List;

import com.ivra.graphql.graphql.model.Cuenta;

public interface CuentaService {
	
	public Cuenta findById(Long id);
	
	public Cuenta save(Cuenta cuenta);
	
	public Cuenta deleteById(Long id);
	
	public Cuenta update(Cuenta cuenta);
	
	public List<Cuenta> findAll(int limit);

}
