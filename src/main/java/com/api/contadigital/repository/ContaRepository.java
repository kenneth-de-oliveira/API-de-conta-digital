package com.api.contadigital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.contadigital.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
	Conta findByAgenciaAndNumero(String agencia, String conta);

	void save(Optional<Conta> conta);
}
