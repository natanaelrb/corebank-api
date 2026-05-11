package com.natan.corebank.infrastructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natan.corebank.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {

    

    
}
