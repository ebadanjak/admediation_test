package com.outfit7.AdMediation.exceptions;

public class AppException extends Exception {
	
	public AppException(String message) {
		super("App message: " + message);
	}
	
	public AppException(String message, Throwable e) {
		super("App message: " + message + ". Original exception message: " + e.getMessage(), e);
	}
}