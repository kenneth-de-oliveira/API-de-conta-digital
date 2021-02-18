package com.api.contadigital.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.contadigital.dtos.TransferenciaDTO;
import com.api.contadigital.entity.Cliente;
import com.api.contadigital.entity.Conta;
import com.api.contadigital.entity.enums.TransacaoEnum;
import com.api.contadigital.exceptions.ContaException;
import com.api.contadigital.exceptions.DataIntegrityViolationException;
import com.api.contadigital.repository.ClienteRepository;
import com.api.contadigital.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private TransacaoExtratoService tes;

	public List<Conta> listarContas() {
		return contaRepository.findAll();
	}

	public Conta buscarClientePorNome(final String nome) {
		try {
			Cliente cli = clienteRepository.findByNome(nome);
			Conta conta = this.buscarContaCliente(cli.getId());

			if (nome == null || nome.isBlank() || cli == null) {
				throw new ContaException("Erro, campo inválido ou conta não encontrada!");
			}
			return conta;
		} catch (Exception e) {
			throw new ContaException("Erro, campo inválido ou conta não encontrada!");
		}
	}

	public Conta buscarContaCliente(final Long id) {
		try {
			Optional<Conta> conta = contaRepository.findById(id);
			return conta.orElseThrow(() -> new ContaException(
					"Conta não encontrado, id:" + conta.get().getId() + ", tipo: " + ContaException.class.getName()));
		} catch (Exception e) {
			throw new ContaException("Erro, campo inválido ou conta não encontrada!");
		}
	}

	public double consultarSaldo(final String agencia, final String numeroConta) {
		Conta conta = this.consultaConta(agencia, numeroConta);
		return conta.getSaldo();
	}

	public Conta consultaConta(final String agencia, final String numeroConta) {
		try {
			Conta conta = contaRepository.findByAgenciaAndNumero(agencia, numeroConta);
			return conta;
		} catch (Exception e) {
			throw new ContaException("Erro, conta inexistente!");
		}
	}

	public Conta criarConta(Conta conta) {
		try {
			conta.setId(null);
			BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
			textEncryptor.
				setPasswordCharArray("conta-digital"
						.toCharArray()); // key
			String senha = textEncryptor
					.encrypt(conta.getSenha()); // password
			conta.setSenha(senha);
			conta.setSaldo(conta.getSaldo() + 100);
			return contaRepository.save(conta);
		} catch (Exception e) {
			throw new DataIntegrityViolationException("Não foi possível criar Conta!");
		}
	}

	public Conta depositar(final String agencia, final String numeroConta, final double valor) {
		Conta conta = this.consultaConta(agencia, numeroConta);
		conta.setSaldo(conta.getSaldo() + valor);
		contaRepository.save(conta);
		return conta;
	}

	public Conta recarga(final String agencia, final String numeroConta, final String numeroCelular,
			final double valor) {
		if (numeroCelular.length() <= 14 && numeroCelular.length() >= 14) {
			TransacaoEnum trasacao = TransacaoEnum.RECARGA;
			Conta conta = this.consultaConta(agencia, numeroConta);
			if (conta.getSaldo() < valor || valor <= 0) {
				throw new ContaException("Transação impossível! não foi possível efetuar a recarga!");
			}
			conta.setSaldo(conta.getSaldo() - valor);
			contaRepository.save(conta);
			tes.geraExtrato(conta, (-valor), trasacao);
			return conta;
		}
		throw new ContaException("Numero de celular inválido!");
	}

	private Conta saque(final String agencia, final String numeroConta, final double valor) {
		Conta conta = this.consultaConta(agencia, numeroConta);
		if (conta.getSaldo() < valor || valor <= 0) {
			throw new ContaException("Transação impossível! não foi possível efetuar a recarga!");
		}
		conta.setSaldo(conta.getSaldo() - valor);
		contaRepository.save(conta);
		return conta;
	}

	@Transactional(rollbackOn = Exception.class)
	public List<Conta> transferir(TransferenciaDTO dto) {
		try {
			List<Conta> contas = new ArrayList<Conta>();
			TransacaoEnum trasacao = TransacaoEnum.TRANSFERENCIA;
			this.depositar(dto.getAgenciaDestino(), dto.getNumeroContaDestino(), dto.getValor());
			this.saque(dto.getAgenciaOrigem(), dto.getNumeroContaOrigem(), dto.getValor());
			contas.add(this.consultaConta(dto.getAgenciaOrigem(), dto.getNumeroContaOrigem()));
			contas.add(this.consultaConta(dto.getAgenciaDestino(), dto.getNumeroContaDestino()));
			Conta contaDestino = this.consultaConta(dto.getAgenciaDestino(), dto.getNumeroContaDestino());
			tes.geraExtrato(contaDestino, dto.getValor(), trasacao);
			return contas;
		} catch (Exception e) {
			throw new ContaException("Ocorreu algum problema! não foi possível efetuar a transferência!");
		}
	}

}