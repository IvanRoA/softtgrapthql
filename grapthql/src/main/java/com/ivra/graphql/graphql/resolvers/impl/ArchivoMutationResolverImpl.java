package com.ivra.graphql.graphql.resolvers.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ivra.graphql.graphql.model.Archivo;
import com.ivra.graphql.graphql.resolvers.ArchivoMutationResolver;
import com.ivra.graphql.graphql.service.ArchivoService;

@Component
public class ArchivoMutationResolverImpl implements ArchivoMutationResolver, GraphQLMutationResolver {
	
	@Autowired
	private ArchivoService archivoService;

	@Override
	public Archivo saveArchivo(String nombre, String fechaCarga) {
		Optional<String> fecReg = Optional.ofNullable(fechaCarga);
		return archivoService.save(new Archivo(nombre, fecReg.isPresent() ? LocalDate.parse(fecReg.get()) : LocalDate.now()));
	}

	@Override
	public Archivo deleteArchivo(Long id) {
		return archivoService.deleteById(id);
	}

	@Override
	public Archivo updateArchivo(Long id, String nombre, String fechaCarga) {
		Optional<String> fecReg = Optional.ofNullable(fechaCarga);
		return archivoService.update(new Archivo(id, nombre, fecReg.isPresent() ? LocalDate.parse(fecReg.get()) : LocalDate.now()));
	}
}
