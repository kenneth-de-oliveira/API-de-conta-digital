package com.api.contadigital.exceptions;

public class CredenciaisInvalidasException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CredenciaisInvalidasException(String message, Throwable cause) {
		super(message, cause);
	}

	public CredenciaisInvalidasException(String message) {
		super(message);
	}

}
