package com.ivra.graphql.graphql.resolvers;

import java.util.List;

import com.ivra.graphql.graphql.model.CatalogoD;

public interface CatalogoDQueryResolver {
	
	public CatalogoD findCatalogoDById(Long idCuenta);
	
	public List<CatalogoD> findAllCatalogoD(int limit);

}
