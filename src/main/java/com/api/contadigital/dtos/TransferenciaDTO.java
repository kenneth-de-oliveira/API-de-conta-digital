package com.api.contadigital.dtos;

import lombok.Data;

@Data
public class TransferenciaDTO {

	private String agenciaOrigem;

	private String numeroContaOrigem;

	private String agenciaDestino;

	private String numeroContaDestino;
	
	private String numeroCelularOrigem;

	private String numeroCelularDestino;
	
	private double valor;
}
