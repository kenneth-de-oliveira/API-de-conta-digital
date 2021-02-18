package com.api.contadigital.dtos;

import lombok.Data;

@Data
public class RecargaContaCelularDTO{

	private String agencia;

	private String numeroConta;
	
	private String numeroCelular;

	private double valor;
}
