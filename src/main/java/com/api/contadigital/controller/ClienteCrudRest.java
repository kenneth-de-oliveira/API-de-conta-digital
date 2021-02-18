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
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.contadigital.entity.Cliente;
import com.api.contadigital.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST de Conta")
public abstract class ClienteCrudRest {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "cria um novo cliente")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Cliente> criaCliente(@RequestBody Cliente cliente) {
		cliente = clienteService.criaCliente(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "atualiza um cliente")
	@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody ResponseEntity<Cliente> update(@RequestBody Cliente newCli, final @PathVariable Long id) {
		Cliente cli = clienteService.update(newCli, id);
		return new ResponseEntity<>(cli, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "remove um cliente")
	@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody ResponseEntity<Cliente> delete(final @PathVariable Long id) {
		Cliente cli = clienteService.delete(id);
		return new ResponseEntity<>(cli, HttpStatus.OK);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "consulta clientes")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Cliente>> listarClientes() {
		List<Cliente> listaCli = clienteService.listarClientes();
		return new ResponseEntity<>(listaCli, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "consulta um cliente")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Cliente> buscarCliente(final @PathVariable Long id) {
		Cliente cli = clienteService.buscarCliente(id);
		return new ResponseEntity<>(cli, HttpStatus.OK);
	}

}
