package com.ivra.graphql.graphql.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivra.graphql.graphql.model.Cuenta;
import com.ivra.graphql.graphql.repository.CuentaRepository;
import com.ivra.graphql.graphql.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService{
	
	@Autowired CuentaRepository cuentaRepository;

	@Override
	public Cuenta findById(Long id) {
		Optional<Cuenta> cuentaOptional = cuentaRepository.findById(id);
		if(cuentaOptional.isPresent()) {
			return cuentaOptional.get();
		}
		throw new RuntimeException("No existe la cuenta");
	}

	@Override
	public Cuenta save(Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}

}
