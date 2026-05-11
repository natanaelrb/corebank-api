package com.natan.corebank.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natan.corebank.application.dtos.ClienteRequest;
import com.natan.corebank.domain.model.Cliente;
import com.natan.corebank.domain.model.enums.TipoCliente;
import com.natan.corebank.infrastructure.Repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(ClienteRequest dto) {
        Cliente cliente = new Cliente();

        cliente.setNome(dto.getNome());
        cliente.setCpfCnpj(dto.getCpfCnpj());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEmail(dto.getEmail());
        cliente.setPasswordHash(dto.getSenha());
        cliente.setTipoCliente(TipoCliente.valueOf(dto.getTipoCliente()));

        return clienteRepository.save(cliente);
    }
}
