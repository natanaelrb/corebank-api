package com.natan.corebank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> transferir(@RequestBody TransferenciaRequest request) {

    try {
        contaService.transferir(
            request.getNumeroOrigem(),
            request.getNumeroDestino(),
            request.getValor()
        );

        return ResponseEntity.ok("Transferência realizada com sucesso");
        
    } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
        
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

    }

    }
}