package com.example.spring_datadog_demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.spring_datadog_demo.controllers.dtos.PedidoRequestDTO;
import com.example.spring_datadog_demo.controllers.dtos.PedidoResponseDTO;
import com.example.spring_datadog_demo.services.PedidoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/adicionar")
    public ResponseEntity<PedidoResponseDTO> save(@RequestBody PedidoRequestDTO pedidoRequest) {
        var pedidoResponse = this.pedidoService.processarPedido(pedidoRequest);
        return ResponseEntity.status(HttpStatus.OK).body(pedidoResponse);
    }
    
    @GetMapping("/listar")
    public ResponseEntity<List<PedidoResponseDTO>> list() {
        var pedidosResponse = this.pedidoService.listarPedidos();
        return ResponseEntity.status(HttpStatus.OK).body(pedidosResponse);
    }
    
}
