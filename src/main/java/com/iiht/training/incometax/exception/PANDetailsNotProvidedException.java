package com.iiht.training.incometax.exception;

public class PANDetailsNotProvidedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PANDetailsNotProvidedException() {
	}

	public PANDetailsNotProvidedException(String message) {
		super(message);
	}

}
