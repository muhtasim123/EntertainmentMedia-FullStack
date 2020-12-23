package com.revature.exceptions;

public class UserNotFoundException extends AbstractHttpExceptions {
	public UserNotFoundException() {
		super("User Not Found", 1);
	}
}
