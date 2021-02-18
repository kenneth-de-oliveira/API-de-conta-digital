package com.api.contadigital.service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.contadigital.entity.Conta;
import com.api.contadigital.entity.TransacaoExtrato;
import com.api.contadigital.entity.enums.TransacaoEnum;
import com.api.contadigital.repository.TransacaoExtratoRepository;

@Service
public class TransacaoExtratoService {

	@Autowired
	private TransacaoExtratoRepository ter;

	public void geraExtrato(Conta conta, double valor, TransacaoEnum transacao) {
		TransacaoExtrato te = new TransacaoExtrato();
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
		te.setConta(conta);
		te.setTipoDaTransacao(transacao);
		te.setNumeroDeOrigemDaRecarga(conta.getCliente().getNumeroCelular());
		te.setDataEhoraDaTransacao(formatter.format(ZonedDateTime.now()));
		te.setValorDescontado(valor);
		ter.save(te);
	}

	public List<TransacaoExtrato> extratoContaCliente() {
		return ter.findAll();
	}
}