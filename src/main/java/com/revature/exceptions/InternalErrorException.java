package com.revature.exceptions;

public class InternalErrorException extends AbstractHttpExceptions {
	public InternalErrorException() {
		super("OOPS, something went wrong", 1);
	}
}
