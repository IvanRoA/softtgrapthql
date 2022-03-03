package com.ivra.graphql.graphql.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;

@Component
public class GraphqlExceptionHandler {

	@ExceptionHandler(GraphQLException.class)
	public ThrowableGraphQLError handler(GraphQLException e) {
		return new ThrowableGraphQLError(e);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ThrowableGraphQLError handler(RuntimeException e) {
		return new ThrowableGraphQLError(e,"Internal server error");
	}
}
