package com.ivra.graphql.graphql.resolvers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ivra.graphql.graphql.model.CatalogoD;
import com.ivra.graphql.graphql.resolvers.CatalogoDMutationResolver;
import com.ivra.graphql.graphql.service.CatalogoDService;

@Component
public class CatalogoDMutationResolverImpl implements CatalogoDMutationResolver, GraphQLMutationResolver {
	
	@Autowired
	private CatalogoDService cuentaService;

	@Override
	public CatalogoD saveCatalogoD(String processDate, String relCatId, String fullDesc,
			String shortDesc, String screenDesc, String abbreviation) {
		return cuentaService.save(new CatalogoD(null, processDate, relCatId, fullDesc, shortDesc, screenDesc, 
				abbreviation));
	}

	@Override
	public CatalogoD deleteCatalogoD(Long id) {
		return cuentaService.deleteById(id);
	}

	@Override
	public CatalogoD updateCatalogoD(Long id, String processDate, String relCatId, String fullDesc,
			String shortDesc, String screenDesc, String abbreviation) {
		return cuentaService.update(new CatalogoD(id, processDate, relCatId, fullDesc, shortDesc, screenDesc, abbreviation));
	}

}
