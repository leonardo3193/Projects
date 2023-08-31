package com.wktechnologytasksync.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wktechnologytasksync.backend.entities.ProjetoEntity;
import com.wktechnologytasksync.backend.repositories.ProjetoRepository;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<ProjetoEntity> listarProjetos() {
        return projetoRepository.findAll();
    }

    public ProjetoEntity obterProjetoPorId(Long id) {
        return projetoRepository.findById(id).orElse(null);
    }

    public ProjetoEntity criarProjeto(ProjetoEntity projeto) {
        return projetoRepository.save(projeto);
    }

    public ProjetoEntity atualizarProjeto(Long id, ProjetoEntity projeto) {
        if (projetoRepository.existsById(id)) {
            projeto.setId(id);
            return projetoRepository.save(projeto);
        }
        return null;
    }

    public void deletarProjeto(Long id) {
        projetoRepository.deleteById(id);
    }
}

