package com.api.contadigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.contadigital.dtos.RecargaContaCelularDTO;
import com.api.contadigital.dtos.TransferenciaDTO;
import com.api.contadigital.entity.Conta;
import com.api.contadigital.entity.TransacaoExtrato;
import com.api.contadigital.service.ContaService;
import com.api.contadigital.service.TransacaoExtratoService;

import io.swagger.annotations.ApiOperation;

@RestController()
@CrossOrigin(origins = "*")
@RequestMapping("rest/conta")
public class ContaRest extends ContaCrudRest {

	@Autowired
	private ContaService contaService;

	@Autowired
	private TransacaoExtratoService tes;

	@RequestMapping(value = "/consultar-saldo-conta/{agencia}/{numConta}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "consulta saldo de uma conta")
	@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody ResponseEntity<Double> consultarSaldoConta(final @PathVariable String agencia,
			final @PathVariable String numConta) {
		double saldo = contaService.consultarSaldo(agencia, numConta);
		return new ResponseEntity<>(saldo, HttpStatus.OK);
	}

	@RequestMapping(value = "/buscar-por-nome/{nome}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "busca conta pelo nome do cliente")
	@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody ResponseEntity<Conta> buscarClientePorNome(final @PathVariable String nome) {
		Conta Conta = contaService.buscarClientePorNome(nome);
		return new ResponseEntity<>(Conta, HttpStatus.OK);
	}

	@RequestMapping(value = "/recarga", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "realiza recarga de celular")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Conta> RecargaContaCelular(final @RequestBody RecargaContaCelularDTO conta) {
		Conta recarga = contaService.recarga(conta.getAgencia(), conta.getNumeroConta(), conta.getNumeroCelular(),
				conta.getValor());
		return new ResponseEntity<>(recarga, HttpStatus.OK);
	}

	@RequestMapping(value = "/transferencia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "transfere valor de uma conta para outra")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Conta>> transferir(@RequestBody TransferenciaDTO conta) {
		List<Conta> contas = contaService.transferir(conta);
		return new ResponseEntity<>(contas, HttpStatus.OK);
	}

	@RequestMapping(value = "/extrato", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "consulta extrato de transacao bancaria ")
	@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody ResponseEntity<List<TransacaoExtrato>> extratoContaCliente() {
		List<TransacaoExtrato> lista = tes.extratoContaCliente();
		return new ResponseEntity<List<TransacaoExtrato>>(lista, HttpStatus.OK);
	}
}