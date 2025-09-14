package com.example.spring_datadog_demo.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.spring_datadog_demo.controllers.dtos.PedidoRequestDTO;
import com.example.spring_datadog_demo.controllers.dtos.PedidoResponseDTO;
import com.example.spring_datadog_demo.models.PedidoRepository;
import com.example.spring_datadog_demo.models.entities.PedidoEntity;

import io.micrometer.core.instrument.MeterRegistry;

@Service
public class PedidoService {

    Logger log = LoggerFactory.getLogger(PedidoService.class);

    private final MeterRegistry meterRegistry;
    private final PedidoRepository pedidoRepository;

    public PedidoService(MeterRegistry meterRegistry, 
                         PedidoRepository pedidoRepository) {
        this.meterRegistry = meterRegistry;
        this.pedidoRepository = pedidoRepository;
    }

    public PedidoResponseDTO processarPedido(PedidoRequestDTO pedidoRequest) {
        log.info("Processando pedido: {}", pedidoRequest.getDescricao());
        var pedidoEntity = new PedidoEntity(pedidoRequest.getDescricao(), pedidoRequest.getValor());
        pedidoEntity = this.pedidoRepository.save(pedidoEntity);

        meterRegistry.counter("pedidos.processados.total", "status", "sucesso", "id", pedidoEntity.getId().toString()).increment();
        log.info("Pedido de id:{} processado com sucesso!", pedidoEntity.getId());

        var pedidoResponse = new PedidoResponseDTO(pedidoEntity.getId(), pedidoEntity.getDescricao(), pedidoEntity.getValor());
        return pedidoResponse;
    }

    public List<PedidoResponseDTO> listarPedidos() {
        log.info("Listando pedidos...");
        var pedidos = this.pedidoRepository.findAll();
        var pedidoResponses = pedidos.stream()
                .map(p -> new PedidoResponseDTO(p.getId(), p.getDescricao(), p.getValor()))
                .toList();
        log.info("Total de pedidos encontrados: {}", pedidoResponses.size());
        return pedidoResponses;
    }
}
