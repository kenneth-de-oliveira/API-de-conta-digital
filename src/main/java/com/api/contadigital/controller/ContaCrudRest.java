package com.api.contadigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.api.contadigital.entity.Conta;
import com.api.contadigital.service.ContaService;

import io.swagger.annotations.ApiOperation;

public abstract class ContaCrudRest {

	@Autowired
	private ContaService contaService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "cria uma nova conta")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Conta> criarConta(@RequestBody Conta conta) {
		conta = contaService.criarConta(conta);
		return new ResponseEntity<>(conta, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "consulta contas")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Conta>> listarContas() {
		List<Conta> contas = contaService.listarContas();
		return new ResponseEntity<>(contas, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "consulta uma conta")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Conta> buscarContaCliente(final @PathVariable Long id) {
		Conta conta = contaService.buscarContaCliente(id);
		return new ResponseEntity<>(conta, HttpStatus.OK);
	}

}
