package com.ivra.graphql.graphql.resolvers;

import java.util.List;

import com.ivra.graphql.graphql.model.Colonia;

public interface ColoniaQueryResolver {

	Colonia findColoniaById(Long idColonia);

	List<Colonia> findAllColonia(int limit);

}
