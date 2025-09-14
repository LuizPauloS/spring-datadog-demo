package com.example.spring_datadog_demo.controllers.dtos;

public class PedidoRequestDTO {

    private String descricao;
    private Double valor;

    public PedidoRequestDTO(String descricao, Double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }
}
