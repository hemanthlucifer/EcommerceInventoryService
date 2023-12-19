package com.ecommerce.inventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> productNotFound(ProductNotFoundException exception){
		ErrorResponseBuilder errorResponse = new ErrorResponseBuilder();
		String message = errorResponse.responseBuilder(ExceptionCodes.productNotFoundCode, exception.getMessage());
		return new ResponseEntity <>(message,HttpStatus.NOT_FOUND);
	}

}
