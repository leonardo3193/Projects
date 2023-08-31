package com.wktechnologytasksync.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wktechnologytasksync.backend.entities.ClienteEntity;
import com.wktechnologytasksync.backend.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteEntity> listarClientes() {
        return clienteRepository.findAll();
    }

    public ClienteEntity obterClientePorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public ClienteEntity criarCliente(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    public ClienteEntity atualizarCliente(Long id, ClienteEntity cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}


