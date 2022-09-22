package com.rsmotola.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rsmotola.exceptions.ExceptioResponse;
import com.rsmotola.exceptions.UnsupportedMathOperationException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptioResponse> handleAllExceptions(
			Exception ex, WebRequest request) {
		
		ExceptioResponse exceptioResponse = new ExceptioResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		
		
		return new ResponseEntity<>(exceptioResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@ExceptionHandler(UnsupportedMathOperationException.class)
	public final ResponseEntity<ExceptioResponse> handleBadRequestExceptions(
			Exception ex, WebRequest request) {
		
		ExceptioResponse exceptioResponse = new ExceptioResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		
		
		return new ResponseEntity<>(exceptioResponse, HttpStatus.BAD_REQUEST);
		
	}

}
