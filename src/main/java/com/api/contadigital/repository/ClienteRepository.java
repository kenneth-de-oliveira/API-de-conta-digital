package com.api.contadigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.contadigital.entity.*;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	public Cliente findByCpf(String cpf);
	public Cliente findByNome(String nome);
}