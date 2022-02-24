package com.ivra.graphql.graphql.service;

import java.util.List;

import com.ivra.graphql.graphql.model.Colonia;

public interface ColoniaService {

	Colonia findById(Long id);

	List<Colonia> findAll(int registros);

	Colonia save(Colonia colonia);

	Colonia update(Colonia colonia);

	Colonia deleteById(Long id);

}
