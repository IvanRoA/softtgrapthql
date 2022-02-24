package com.ivra.graphql.graphql.exception;

import java.util.List;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphQLException;
import graphql.language.SourceLocation;

public class GenericExceptionGraphQL extends GraphQLException implements GraphQLError {

	private static final long serialVersionUID = 1L;

	@Override
	public ErrorType getErrorType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SourceLocation> getLocations() {
		// TODO Auto-generated method stub
		return null;
	}

}
