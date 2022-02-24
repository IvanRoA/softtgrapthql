package com.ivra.graphql.graphql.resolvers.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ivra.graphql.graphql.model.Banco;
import com.ivra.graphql.graphql.resolvers.BancoMutationResolver;
import com.ivra.graphql.graphql.service.BancoService;

@Component
public class BancoMutationResolverImpl implements BancoMutationResolver, GraphQLMutationResolver {

	@Autowired
	private BancoService bancoService;
	
	@Override
	public Banco saveBanco(String nombre, String clave, String fechaRegistro) {
		Optional<String> fecReg = Optional.ofNullable(fechaRegistro);
		return bancoService.save(new Banco(nombre, clave, fecReg.isPresent() ? LocalDate.parse(fecReg.get()) : LocalDate.now()));
	}

	@Override
	public Banco deleteBanco(Long id) {
		return bancoService.deleteById(id);
	}

	@Override
	public Banco updateBanco(Long id, String nombre, String clave, String fechaRegistro) {
		Optional<String> fecReg = Optional.ofNullable(fechaRegistro);
		return bancoService.update(new Banco(id, nombre, clave, fecReg.isPresent() ? LocalDate.parse(fecReg.get()) : LocalDate.now()));
	}
}
