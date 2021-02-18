package com.api.contadigital.exceptions;

public class ClienteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClienteException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClienteException(String message) {
		super(message);
	}


}
