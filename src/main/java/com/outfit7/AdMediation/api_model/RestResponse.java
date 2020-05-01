package com.outfit7.AdMediation.api_model;

import com.outfit7.AdMediation.exceptions.ErrorModel;

public class RestResponse {
	
	private String message;	
	private ErrorModel error;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorModel getError() {
		return error;
	}
	public void setError(ErrorModel error) {
		this.error = error;
	}
}
