package com.ivra.graphql.graphql.resolvers;

import com.ivra.graphql.graphql.model.CatalogoD;

public interface CatalogoDMutationResolver {
	
	public CatalogoD saveCatalogoD(String processDate, String relCatId, String fullDesc, String shortDesc, String screenDesc, String abbreviation);
	
	public CatalogoD deleteCatalogoD(Long id);
	
	public CatalogoD updateCatalogoD(Long id, String processDate, String relCatId, String fullDesc, String shortDesc, String screenDesc, String abbreviation);
	
}
