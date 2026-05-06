package com.natan.corebank.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.natan.corebank.domain.model.enums.TipoConta;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "conta")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, unique = true)
    private String numeroConta;

    @Column(nullable = false)
    private String agencia;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal saldo = BigDecimal.ZERO;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal limite = BigDecimal.ZERO;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoConta tipoConta;

    @Column(nullable = false)
    private boolean ativa = true;

    @Column(nullable = false, updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCadastro; 

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @PrePersist
    public void onCreate() {
        this.dataCadastro = LocalDateTime.now();
    }

    public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }

        this.saldo = this.saldo.add(valor);
    }

    public void sacar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        if (this.saldo.compareTo(valor) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        this.saldo = this.saldo.subtract(valor);
    }

    @OneToMany(mappedBy = "contaOrigem", cascade = CascadeType.ALL)
    private List<Transacao> transacoesEnviadas = new ArrayList<>();

    @OneToMany(mappedBy = "contaDestino", cascade = CascadeType.ALL)
    private List<Transacao> transacoesRecebidas = new ArrayList<>();

}
