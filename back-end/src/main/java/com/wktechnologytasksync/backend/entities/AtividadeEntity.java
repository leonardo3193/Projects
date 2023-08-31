package com.wktechnologytasksync.backend.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class AtividadeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome_atividade;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataTerminoPrevista;
    private StatusAtividade status; // Enum: PENDENTE, EM_ANDAMENTO, CONCLUIDA, etc.
    
    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private ProjetoEntity projeto;
    
    // Getters e setters
    
}


