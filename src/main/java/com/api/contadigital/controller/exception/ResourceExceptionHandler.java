package com.api.contadigital.controller.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.contadigital.exceptions.ClienteException;
import com.api.contadigital.exceptions.ContaException;
import com.api.contadigital.exceptions.CredenciaisInvalidasException;
import com.api.contadigital.exceptions.DataIntegrityViolationException;
import com.api.contadigital.exceptions.UsuarioException;

@RestControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ClienteException.class)
	public ResponseEntity<StandardError> ClienteException(ClienteException obj) {
		StandardError se = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				obj.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
	}

	@ExceptionHandler(ContaException.class)
	public ResponseEntity<StandardError> ContaException(ContaException obj) {
		StandardError se = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				obj.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
	}
	
	@ExceptionHandler(CredenciaisInvalidasException.class)
	public ResponseEntity<StandardError> CredenciaisInvalidasException(CredenciaisInvalidasException obj) {
		StandardError se = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				obj.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
	}
	
	@ExceptionHandler(UsuarioException.class)
	public ResponseEntity<StandardError> UsuarioException(UsuarioException obj) {
		StandardError se = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				obj.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> DataIntegrityViolationException(DataIntegrityViolationException obj) {
		StandardError se = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				obj.getMessage());
		return ResponseEntity.status(BAD_REQUEST).body(se);
	}

}
