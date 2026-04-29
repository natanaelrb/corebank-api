package com.natan.corebank.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.EnumType;
import jakarta.persistence.InheritanceType;

import com.natan.corebank.domain.model.enums.StatusTransacao;
import com.natan.corebank.domain.model.enums.TipoTransacao;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Transacao")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.JOINED) // Define a herança
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(length = 255)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusTransacao status;

    @Column(unique = true)
    private String referenciaExterna;

    @ManyToOne
    @JoinColumn(name = "conta_origem_id")
    private Conta contaOrigem;

    @ManyToOne
    @JoinColumn(name = "conta_destino_id")
    private Conta contaDestino;

    @PrePersist
    public void onCreate() {
        this.dataHora = LocalDateTime.now();
    }

    @PrePersist
    public void gerarReferencia() {
        if (this.referenciaExterna == null) {
            this.referenciaExterna = UUID.randomUUID().toString();
        }
    }
}
