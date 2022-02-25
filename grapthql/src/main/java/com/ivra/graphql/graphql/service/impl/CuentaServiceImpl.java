package com.ivra.graphql.graphql.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ivra.graphql.graphql.exception.NotFoundException;
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
		throw new NotFoundException("No existe la cuenta", "Cuenta");
	}

	@Override
	public Cuenta save(Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}

	@Override
	public Cuenta deleteById(Long id) {
		Cuenta cuenta =  findById(id);
		cuentaRepository.delete(cuenta);
		return cuenta;
	}

	@Override
	public Cuenta update(Cuenta cuenta) {
		Cuenta cuentaPersist = findById(cuenta.getId());
		cuentaPersist.setClave(cuenta.getClave());
		cuentaPersist.setNumeroCuenta(cuenta.getNumeroCuenta());
		return cuentaRepository.save(cuentaPersist);
	}

	@Override
	public List<Cuenta> findAll(int limit) {
		return cuentaRepository.findAll(Pageable.ofSize(limit)).getContent();
	}

}
