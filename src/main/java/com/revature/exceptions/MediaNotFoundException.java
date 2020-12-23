package com.revature.exceptions;

public class MediaNotFoundException extends Exception {

	public MediaNotFoundException() {
		super("That Movie Was Not Found, Please Try Again");
	}
}
