package com.revature.exceptions;

public class UnauthenticatedException extends AbstractHttpExceptions {

	public UnauthenticatedException() {
		super("Please log in", 403);
		// TODO Auto-generated constructor stub
	}

}
