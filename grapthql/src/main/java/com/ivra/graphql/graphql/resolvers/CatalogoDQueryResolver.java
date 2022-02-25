package com.ivra.graphql.graphql.resolvers;

import java.util.List;

import com.ivra.graphql.graphql.model.CatalogoD;

public interface CatalogoDQueryResolver {
	
	CatalogoD findCatalogoDById(Long idCuenta);
	
	List<CatalogoD> findAllCatalogoD(int limit);

}
