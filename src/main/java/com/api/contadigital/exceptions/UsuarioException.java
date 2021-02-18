package com.api.contadigital.exceptions;

public class UsuarioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsuarioException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsuarioException(String message) {
		super(message);
	}
	
}
