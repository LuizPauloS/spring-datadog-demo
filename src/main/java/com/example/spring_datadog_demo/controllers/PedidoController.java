package com.example.spring_datadog_demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.spring_datadog_demo.controllers.dtos.PedidoRequestDTO;
import com.example.spring_datadog_demo.controllers.dtos.PedidoResponseDTO;
import com.example.spring_datadog_demo.services.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<PedidoResponseDTO> getMethodName(@RequestBody PedidoRequestDTO pedidoRequest) {
        var pedidoResponse = this.pedidoService.processarPedido(pedidoRequest);
        return ResponseEntity.status(HttpStatus.OK).body(pedidoResponse);
    }
    
}
