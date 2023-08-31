package com.wktechnologytasksync.backend.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class ProjetoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome_projeto;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataTerminoPrevista;
    private StatusProjeto status; // Enum: ABERTO, EM_ANDAMENTO, CONCLUIDO, etc.
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;
    
    @OneToMany(mappedBy = "projeto")
    private List<AtividadeEntity> atividades;
    
    // Getters e setters
}


