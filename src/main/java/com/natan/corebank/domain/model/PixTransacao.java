package com.natan.corebank.domain.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "pix_transacao")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PixTransacao extends Transacao {

    private String chaveOrigem;
    private String chaveDestino;

    @Column(unique = true, nullable = false)
    private String e2eId;

    @PrePersist
    public void gerarE2E() {
        this.e2eId = UUID.randomUUID().toString();
    }

}
