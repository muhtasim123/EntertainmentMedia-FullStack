package com.revature.exceptions;

public class UserNotFoundException extends Exception {
	public UserNotFoundException() {
		super("User Not Found");
	}
}
