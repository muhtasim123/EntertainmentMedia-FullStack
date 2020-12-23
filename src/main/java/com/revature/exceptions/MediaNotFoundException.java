package com.revature.exceptions;

public class MediaNotFoundException extends RuntimeException {

	public MediaNotFoundException() {
		super("That Movie Was Not Found, Please Try Again");
	}
}
