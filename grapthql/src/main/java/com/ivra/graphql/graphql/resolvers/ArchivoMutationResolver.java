package com.ivra.graphql.graphql.resolvers;

import com.ivra.graphql.graphql.model.Archivo;

public interface ArchivoMutationResolver {

	Archivo saveArchivo(String nombre, String fechaCarga);

	Archivo deleteArchivo(Long id);

	Archivo updateArchivo(Long id, String nombre, String fechaCarga);

}
