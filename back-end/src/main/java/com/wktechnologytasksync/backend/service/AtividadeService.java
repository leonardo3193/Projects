package com.wktechnologytasksync.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wktechnologytasksync.backend.entities.AtividadeEntity;
import com.wktechnologytasksync.backend.repositories.AtividadeRepository;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public List<AtividadeEntity> listarAtividades() {
        return atividadeRepository.findAll();
    }

    public AtividadeEntity obterAtividadePorId(Long id) {
        return atividadeRepository.findById(id).orElse(null);
    }

    public AtividadeEntity criarAtividade(AtividadeEntity atividade) {
        return atividadeRepository.save(atividade);
    }

    public AtividadeEntity atualizarAtividade(Long id, AtividadeEntity atividade) {
        if (atividadeRepository.existsById(id)) {
            atividade.setId(id);
            return atividadeRepository.save(atividade);
        }
        return null;
    }

    public void deletarAtividade(Long id) {
        atividadeRepository.deleteById(id);
    }
}

