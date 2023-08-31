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

import com.wktechnologytasksync.backend.entities.ProjetoEntity;
import com.wktechnologytasksync.backend.service.ProjetoService;

@RestController
@RequestMapping("/backend/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public List<ProjetoEntity> listarProjetos() {
        return projetoService.listarProjetos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoEntity> obterProjetoPorId(@PathVariable Long id) {
        ProjetoEntity projeto = projetoService.obterProjetoPorId(id);
        if (projeto != null) {
            return ResponseEntity.ok(projeto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ProjetoEntity> criarProjeto(@RequestBody ProjetoEntity projeto) {
        ProjetoEntity novoProjeto = projetoService.criarProjeto(projeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProjeto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoEntity> atualizarProjeto(@PathVariable Long id, @RequestBody ProjetoEntity projeto) {
        ProjetoEntity projetoAtualizado = projetoService.atualizarProjeto(id, projeto);
        if (projetoAtualizado != null) {
            return ResponseEntity.ok(projetoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable Long id) {
        projetoService.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }
}
