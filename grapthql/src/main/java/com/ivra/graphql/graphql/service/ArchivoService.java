package com.ivra.graphql.graphql.service;

import java.util.List;

import com.ivra.graphql.graphql.model.Archivo;

public interface ArchivoService {

	public List<Archivo> cargarArchivos();

	Archivo findById(Long id);

	List<Archivo> findAll(int registros);

	Archivo save(Archivo archivo);

	Archivo update(Archivo archivo);

	Archivo deleteById(Long id);
	
}
