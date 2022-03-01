package com.ivra.graphql.graphql.resolvers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ivra.graphql.graphql.model.Archivo;
import com.ivra.graphql.graphql.resolvers.ArchivoQueryResolver;
import com.ivra.graphql.graphql.service.ArchivoService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class ArchivoQueryResolverImpl implements ArchivoQueryResolver, GraphQLQueryResolver {
	
	@Autowired
	private ArchivoService archivoService;

	@Override
	public List<Archivo> cargarArchivos(){
		return archivoService.cargarArchivos();
	}
	
	@Override
	public Archivo findArchivoById(Long idArchivo) {
		return archivoService.findById(idArchivo);
	}

	@Override
	public List<Archivo> findAllArchivo(int limit) {
		return archivoService.findAll(limit);
	}
}
