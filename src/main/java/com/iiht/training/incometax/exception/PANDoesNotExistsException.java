package com.iiht.training.incometax.exception;

public class PANDoesNotExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PANDoesNotExistsException() {
	}

	public PANDoesNotExistsException(String message) {
		super(message);
	}

}
