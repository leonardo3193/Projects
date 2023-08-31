package com.wktechnologytasksync.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wktechnologytasksync.backend.entities.ClienteEntity;
import com.wktechnologytasksync.backend.service.ClienteService;

@RestController
@RequestMapping("/backend/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteEntity> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> obterClientePorId(@PathVariable Long id) {
        ClienteEntity cliente = clienteService.obterClientePorId(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ClienteEntity> criarCliente(@RequestBody ClienteEntity cliente) {
        ClienteEntity novoCliente = clienteService.criarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteEntity> atualizarCliente(@PathVariable Long id, @RequestBody ClienteEntity cliente) {
        ClienteEntity clienteAtualizado = clienteService.atualizarCliente(id, cliente);
        if (clienteAtualizado != null) {
            return ResponseEntity.ok(clienteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}

