package com.ivra.graphql.graphql.resolvers;

import java.util.List;

import com.ivra.graphql.graphql.model.Archivo;

public interface ArchivoQueryResolver {

	List<Archivo> cargarArchivos();

	Archivo findArchivoById(Long idArchivo);

	List<Archivo> findAllArchivo(int limit);
}
