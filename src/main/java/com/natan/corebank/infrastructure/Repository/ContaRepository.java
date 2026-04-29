package com.natan.corebank.infrastructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.natan.corebank.domain.model.Conta;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    Optional<Conta> findByNumeroConta(String numeroConta);

}