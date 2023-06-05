package com.iiht.training.incometax.exception;

public class PANAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PANAlreadyExistsException() {
	}

	public PANAlreadyExistsException(String message) {
		super(message);
	}

}
