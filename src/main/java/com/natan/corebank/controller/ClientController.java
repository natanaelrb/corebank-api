package com.natan.corebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natan.corebank.application.dtos.ClienteRequest;
import com.natan.corebank.application.service.ClienteService;
import com.natan.corebank.domain.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente criar(@RequestBody ClienteRequest dto) {
        return clienteService.criarCliente(dto);
    }

}