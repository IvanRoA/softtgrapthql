package com.ivra.graphql.graphql.resolvers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ivra.graphql.graphql.model.Colonia;
import com.ivra.graphql.graphql.resolvers.ColoniaMutationResolver;
import com.ivra.graphql.graphql.service.ColoniaService;

@Component
public class ColoniaMutationResolverImpl implements ColoniaMutationResolver, GraphQLMutationResolver {

	@Autowired
	private ColoniaService coloniaService;
	
	@Override
	public Colonia saveColonia(String descripcion, String clave0, String clave1, String clave2, String clave3, String clave4, String clave5, Integer fecha) {
		return coloniaService.save(new Colonia(descripcion, clave0, clave1, clave2, clave3, clave4, clave5, fecha));
	}

	@Override
	public Colonia deleteColonia(Long id) {
		return coloniaService.deleteById(id);
	}

	@Override
	public Colonia updateColonia(Long id, String descripcion, String clave0, String clave1, String clave2, String clave3, String clave4, String clave5, Integer fecha) {
		return coloniaService.update(new Colonia(id, descripcion, clave0, clave1, clave2, clave3, clave4, clave5, fecha));
	}
}
