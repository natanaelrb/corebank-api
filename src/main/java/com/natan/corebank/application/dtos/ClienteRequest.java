package com.natan.corebank.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {
    
    private String nome;
    private String cpfCnpj;
    private String telefone;
    private String email;
    private String senha;
    private String tipoCliente;

}
