package com.natan.corebank.domain.model.enums;

public enum TipoLancamento {

    CREDITO("Entrada"),
    DEBITO("Saída");

    private final String descricao;

    TipoLancamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
