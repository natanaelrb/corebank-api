package com.natan.corebank.application.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.natan.corebank.domain.model.Conta;
import com.natan.corebank.domain.model.Transacao;
import com.natan.corebank.domain.model.enums.StatusTransacao;
import com.natan.corebank.domain.model.enums.TipoTransacao;
import com.natan.corebank.infrastructure.Repository.ContaRepository;
import com.natan.corebank.infrastructure.Repository.TransacaoRepository;

import jakarta.transaction.Transactional;

@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final TransacaoRepository transacaoRepository;

    public ContaService(ContaRepository contaRepository, TransacaoRepository transacaoRepository) {
        this.contaRepository = contaRepository;
        this.transacaoRepository = transacaoRepository;
    }

    @Transactional
    public void transferir(String numeroOrigem, String numeroDestino, BigDecimal valor) {

    if (valor.compareTo(BigDecimal.ZERO) <= 0) {
        throw new IllegalArgumentException("Valor inválido");
    }

    Conta origem = contaRepository.findByNumeroConta(numeroOrigem)
            .orElseThrow(() -> new RuntimeException("Conta origem não encontrada"));

    Conta destino = contaRepository.findByNumeroConta(numeroDestino)
            .orElseThrow(() -> new RuntimeException("Conta destino não encontrada"));

    if (origem.equals(destino)) {
        throw new IllegalArgumentException("Não pode transferir para a mesma conta");
    }

    if (!origem.isAtiva() || !destino.isAtiva()) {
        throw new RuntimeException("Conta inativa");
    }

    if (origem.getSaldo().compareTo(valor) < 0) {
        throw new RuntimeException("Saldo insuficiente");
    }

    origem.sacar(valor);
    destino.depositar(valor);

    Transacao transacao = new Transacao();
    transacao.setValor(valor);
    transacao.setTipoTransacao(TipoTransacao.TRANSFERENCIA);
    transacao.setContaOrigem(origem);
    transacao.setContaDestino(destino);
    transacao.setStatus(StatusTransacao.CONCLUIDA);

    contaRepository.save(origem);
    contaRepository.save(destino);
    transacaoRepository.save(transacao);

    }
}