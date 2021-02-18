package com.api.contadigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.contadigital.entity.TransacaoExtrato;

@Repository
public interface TransacaoExtratoRepository extends JpaRepository<TransacaoExtrato, Long> {

}
