package com.revature.exceptions;

public class AbstractHttpExceptions extends RuntimeException {

	private int statusCode;
	
	protected AbstractHttpExceptions(String message, int statusCode) {
		super(message);
		this.statusCode = statusCode;
	}
	
	public int getStatusCode() {
		return this.statusCode;
	}
}
