package com.natan.corebank.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaRequest {
    
    private String numeroConta;
    private String agencia;
    private String tipoConta;
    private Long clienteId;
}
