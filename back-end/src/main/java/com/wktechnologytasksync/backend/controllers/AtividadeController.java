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

import com.wktechnologytasksync.backend.entities.AtividadeEntity;
import com.wktechnologytasksync.backend.service.AtividadeService;

@RestController
@RequestMapping("/backend/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @GetMapping
    public List<AtividadeEntity> listarAtividades() {
        return atividadeService.listarAtividades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtividadeEntity> obterAtividadePorId(@PathVariable Long id) {
        AtividadeEntity atividade = atividadeService.obterAtividadePorId(id);
        if (atividade != null) {
            return ResponseEntity.ok(atividade);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AtividadeEntity> criarAtividade(@RequestBody AtividadeEntity atividade) {
        AtividadeEntity novaAtividade = atividadeService.criarAtividade(atividade);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAtividade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtividadeEntity> atualizarAtividade(@PathVariable Long id, @RequestBody AtividadeEntity atividade) {
        AtividadeEntity atividadeAtualizada = atividadeService.atualizarAtividade(id, atividade);
        if (atividadeAtualizada != null) {
            return ResponseEntity.ok(atividadeAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAtividade(@PathVariable Long id) {
        atividadeService.deletarAtividade(id);
        return ResponseEntity.noContent().build();
    }
}
