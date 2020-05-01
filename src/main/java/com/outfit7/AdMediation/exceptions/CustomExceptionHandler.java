package com.outfit7.AdMediation.exceptions;

import javax.persistence.PersistenceException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;

import com.outfit7.AdMediation.api_model.RestResponse;

@ControllerAdvice
public class CustomExceptionHandler {
	
	private ResponseEntity<RestResponse> buildErrorResponse(HttpStatus status, String code, String message, String description) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		RestResponse restResponse = new RestResponse();
		ErrorModel error = new ErrorModel();
		restResponse.setError(error);		
		error.setCode(code);
		error.setMessage(message);		
		error.setDescription(description);

		return new ResponseEntity<>(restResponse, headers, status);
	}
	
	
	@ExceptionHandler(PersistenceException.class)
	public ResponseEntity<RestResponse> persistenceExceptionHandler(PersistenceException e) {
		String message = "Error with DB communication."; 
		return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, message, e.getMessage());
	}
	
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<RestResponse> httpInvalidBodyHandler(HttpMessageNotReadableException e) {
		String message = "REST - Request body is invalid.";
		String description = "Exception message: " + e.getMessage() + ", Cause: " + e.getCause();

		return buildErrorResponse(HttpStatus.BAD_REQUEST, null, message, description);
	}
	
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<RestResponse> httpInvalidMethodHandler(HttpRequestMethodNotSupportedException e) {
		String message = "REST - Unsupported method invoked.";
		String description = "Exception message: " + e.getMessage() + ", Cause: " + e.getCause();

		return buildErrorResponse(HttpStatus.METHOD_NOT_ALLOWED, null, message, description);	
	}
	
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<RestResponse> httpClientErrorExceptionHandler(HttpClientErrorException e) {
		String message = "REST - Client rrror. Status: " + e.getStatusCode().toString();
		String description = "Response header origin: " + e.getResponseHeaders().getOrigin();
		description += ", Response body: " + e.getResponseBodyAsString();

		return buildErrorResponse(e.getStatusCode(), null, message, description);	
	}


	@ExceptionHandler(HttpServerErrorException.class)
	public ResponseEntity<RestResponse> httpServerErrorExceptionHandler(HttpServerErrorException e) {
		String message = "REST - Server error. Status: " + e.getStatusCode().toString();
		String description = "Response header origin: " + e.getResponseHeaders().getOrigin();
		description += ", Response body: " + e.getResponseBodyAsString();

		return buildErrorResponse(e.getStatusCode(), null, message, description);	
	}
	
	@ExceptionHandler(RestClientException.class)
	public ResponseEntity<RestResponse> httpServerErrorExceptionHandler(RestClientException e) {
		String message = "REST - error. ";
		String description = "Exception message: " + e.getMessage() + ", Cause: " + e.getCause();

		return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, message, description);	
	}

	
	@ExceptionHandler(AppException.class)
	public ResponseEntity<RestResponse> appExceptionHandler(AppException e) {
		String message = "An error occured. "; // to do code + language
		String description = "Exception message: " + e.getMessage() + ", Cause: " + e.getCause();

		return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, message, description);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<RestResponse> defaultExceptionHandler(Exception e) {
		String message = "Pojavila se greska. "; // to do code + language
		String description = "Exception message: " + e.getMessage() + ", Cause: " + e.getCause();

		return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, message, description);
	}

}
