package com.api.contadigital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "numero_celular", nullable = false, length = 14)
	private String numeroCelular;

	@Column(name = "endereco", nullable = false)
	private String endereco;

	@Column(name = "ativo", nullable = false)
	private boolean ativo;

	@Column(name = "observacoes", nullable = false)
	private String observacoes;

}