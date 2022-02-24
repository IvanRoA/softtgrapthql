package com.ivra.graphql.graphql.exception;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class NotFoundException extends RuntimeException implements GraphQLError {

	private static final long serialVersionUID = 1L;
	
	private String data;

	public NotFoundException(String message, String data) {
	    super(message);
	    this.data = data;
	}

	@Override
	public ErrorType getErrorType() {
		return null;
	}

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}
	
	@Override
	public String getMessage() {
	    return super.getMessage();
	}
	
	@Override
	public Map<String, Object> getExtensions() {
	    return Collections.singletonMap("invalidData", data);
	}

}
