package com.revature.exceptions;

public class UnauthorizedException extends AbstractHttpExceptions {

	public UnauthorizedException() {
		super("Unauthorized User", 403);
	}
}
