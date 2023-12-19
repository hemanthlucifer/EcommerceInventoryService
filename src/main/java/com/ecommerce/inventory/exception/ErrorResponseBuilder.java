package com.ecommerce.inventory.exception;

public class ErrorResponseBuilder {
	
	public String responseBuilder(String statusCode, String message) {
		return (statusCode+" "+":"+" "+message);
	}

}
