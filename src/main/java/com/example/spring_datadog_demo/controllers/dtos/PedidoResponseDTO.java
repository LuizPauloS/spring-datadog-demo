package com.example.spring_datadog_demo.controllers.dtos;

public class PedidoResponseDTO {

    private Long id;
    private String descricao;
    private Double valor;

    public PedidoResponseDTO(Long id, String descricao, Double valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }
}
