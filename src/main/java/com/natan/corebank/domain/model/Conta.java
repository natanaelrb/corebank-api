package com.natan.corebank.domain.model;

import java.math.BigDecimal;

import com.natan.corebank.domain.model.enums.TipoConta;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numero;

    @Column(nullable = false)
    private String agencia;

    @Column(nullable = false)
    private BigDecimal saldo = BigDecimal.ZERO;
    
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente titular;

    
}
