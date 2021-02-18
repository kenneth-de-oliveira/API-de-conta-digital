package com.api.contadigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.contadigital.entity.Cliente;
import com.api.contadigital.service.ClienteService;

import io.swagger.annotations.ApiOperation;

@RestController()
@CrossOrigin(origins = "*")
@RequestMapping("rest/cliente")
public class ClienteRest extends ClienteCrudRest{

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/buscar-por-nome/{nome}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "consulta cliente por nome")
	@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody ResponseEntity<Cliente> buscarClientePorNome(final @PathVariable String nome) {
		Cliente cli = clienteService.buscarClientePorNome(nome);
		return new ResponseEntity<>(cli, HttpStatus.OK);

	}

	@RequestMapping(value = "/buscar-por-cpf/{cpf}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "consulta cliente por cpf")
	@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody ResponseEntity<Cliente> buscarClientePorCpf(final @PathVariable String cpf) {
		Cliente conta = clienteService.buscarClientePorCpf(cpf);
		return new ResponseEntity<Cliente>(conta, HttpStatus.OK);
	}

}
