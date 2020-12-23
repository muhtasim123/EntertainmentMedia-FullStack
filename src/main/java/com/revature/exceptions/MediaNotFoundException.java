package com.revature.exceptions;

public class MediaNotFoundException extends AbstractHttpExceptions {

	public MediaNotFoundException() {
		super("That Movie Was Not Found, Please Try Again", 1);
	}
}
