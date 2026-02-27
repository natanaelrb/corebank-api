package com.natan.corebank.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;

import com.natan.corebank.domain.model.enums.TipoTransacao;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    private Conta conta;
    
}
