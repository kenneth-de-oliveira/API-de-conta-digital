package com.api.contadigital.exceptions;

public class ContaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ContaException(String message, Throwable cause) {
		super(message, cause);
	}

	public ContaException(String message) {
		super(message);
	}

}
