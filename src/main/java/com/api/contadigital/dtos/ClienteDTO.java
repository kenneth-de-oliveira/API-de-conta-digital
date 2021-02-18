package com.api.contadigital.dtos;

import lombok.Data;

@Data

public class ClienteDTO {
	
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String email;
	
	
	private boolean ativo;

}
