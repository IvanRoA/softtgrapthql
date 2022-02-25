package com.ivra.graphql.graphql.resolvers;

import java.util.List;

import com.ivra.graphql.graphql.model.CatalogoT;

public interface CatalogoTQueryResolver {

	CatalogoT findCatalogoTById(Long processDate);

	List<CatalogoT> findAllCatalogoT(int limit);
	
	List<CatalogoT> findCatalogoTByFilter(String filter,String separator);

}
