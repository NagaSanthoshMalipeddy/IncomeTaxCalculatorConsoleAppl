package com.iiht.training.incometax.exception;

public class InvalidPANException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidPANException() {
	}

	public InvalidPANException(String message) {
		super(message);
	}

}
