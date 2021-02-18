package com.api.contadigital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_contas")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "agencia", nullable = false)
	private String agencia;

	@Column(name = "numero_conta", nullable = false, length = 6)
	private String numero;

	@Column(name = "saldo", nullable = false)
	private double saldo;

	@Column(name = "senha", nullable = false)
	private String senha;
	
	@ManyToOne
	@JoinColumn(name = "fk_cliente_id", nullable = false)
	private Cliente cliente;
			
}

