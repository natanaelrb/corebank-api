package com.natan.corebank.application.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferenciaResponse {
    
    private String mensagem;
    private BigDecimal saldoOrigem;
    private BigDecimal saldoDestino;

   
}
