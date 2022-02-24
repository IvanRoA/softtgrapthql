package com.ivra.graphql.graphql.resolvers;

import com.ivra.graphql.graphql.model.Colonia;

public interface ColoniaMutationResolver {

	Colonia saveColonia(String descripcion, String clave0, String clave1, String clave2, String clave3, String clave4,
			String clave5, Integer fecha);

	Colonia deleteColonia(Long id);

	Colonia updateColonia(Long id, String descripcion, String clave0, String clave1, String clave2, String clave3,
			String clave4, String clave5, Integer fecha);

}
