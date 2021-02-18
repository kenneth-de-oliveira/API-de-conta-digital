package com.api.contadigital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.api.contadigital.entity.enums.TransacaoEnum;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_transacao_extrato")
public class TransacaoExtrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "transacao_extrato", nullable = false)
	private TransacaoEnum tipoDaTransacao;

	@Column(name = "valor_transacao", nullable = false)
	private double valorDescontado;

	@Column(name = "data_transacao", nullable = false)
	private String dataEhoraDaTransacao;
	
	@Column(name = "numero_celular", nullable = false)
	private String numeroDeOrigemDaRecarga;
	
	@ManyToOne
	@JoinColumn(name = "fk_conta_id", nullable = false)
	private Conta conta;
}