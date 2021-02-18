package com.api.contadigital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.contadigital.entity.Cliente;
import com.api.contadigital.exceptions.ClienteException;
import com.api.contadigital.exceptions.DataIntegrityViolationException;
import com.api.contadigital.repository.ClienteRepository;
import com.api.contadigital.util.CpfUtil;

@Service
public class ClienteService {

	@Autowired

	private ClienteRepository clienteRepository;

	public Cliente buscarCliente(final Long id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ClienteException(
				"Cliente inexistente, id:" + id + ", tipo: " + ClienteException.class.getName()));
	}

	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}

	public Cliente buscarClientePorNome(final String nome) {
		Cliente cli = clienteRepository.findByNome(nome);

		if (nome == null || nome.isBlank() || cli == null) {
			throw new ClienteException("Erro, campo inválido ou usuário não encontrado!");
		}
		return cli;
	}

	public Cliente buscarClientePorCpf(final String cpf) {
		try {
			Cliente cli = this.buscarCliente(clienteRepository.findByCpf(cpf).getId());
			if (!cpfEhValido(cpf)) {
				throw new ClienteException("o cpf informado é inválido!");
			}
			return cli;
		} catch (Exception e) {
			throw new ClienteException("Erro, campo inválido ou cliente não encontrado!");
		}
	}

	public boolean cpfEhValido(final String cpf) {
		return CpfUtil.validaCPF(cpf);
	}

	public Cliente criaCliente(Cliente cliente) {
		try {
			cliente.setId(null);
			return clienteRepository.save(cliente);
		} catch (Exception e) {
			throw new DataIntegrityViolationException("Não foi possível criar o cliente!");
		}
	}

	public Cliente update(Cliente newCli, final Long id) {
		Cliente cli = this.buscarCliente(id);
		cli.setCpf(newCli.getCpf());
		cli.setNome(newCli.getNome());
		cli.setEmail(newCli.getEmail());
		cli.setAtivo(true);
		cli.setNumeroCelular(newCli.getNumeroCelular());
		cli.setEndereco(newCli.getEndereco());
		cli.setObservacoes(newCli.getObservacoes());
		return clienteRepository.save(cli);
	}

	public Cliente delete(final Long id) {
		Cliente cli = this.buscarCliente(id);
		try {
			clienteRepository.deleteById(id);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Objeto não pode ser deletado!");
		}
		return cli;
	}

}
