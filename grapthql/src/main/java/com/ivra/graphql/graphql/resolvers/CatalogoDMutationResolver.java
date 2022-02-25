package com.ivra.graphql.graphql.resolvers;

import com.ivra.graphql.graphql.model.CatalogoD;

public interface CatalogoDMutationResolver {

	CatalogoD saveCatalogoD(String processDate, String relCatId, String fullDesc, String shortDesc, String screenDesc, String abbreviation);
	
	CatalogoD deleteCatalogoD(Long id);
	
	CatalogoD updateCatalogoD(Long id, String processDate, String relCatId, String fullDesc, String shortDesc, String screenDesc, String abbreviation);
}
