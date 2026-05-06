package com.natan.corebank.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natan.corebank.application.dtos.TransferenciaRequest;
import com.natan.corebank.application.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {
    
    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping("/transferir")
    public void transferir(@RequestBody TransferenciaRequest request) {

        contaService.transferir(
            request.getNumeroOrigem(),
            request.getNumeroDestino(),
            request.getValor()
        );
    }
}
