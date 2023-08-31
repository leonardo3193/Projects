package com.wktechnologytasksync.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wktechnologytasksync.backend.entities.ProjetoEntity;

public interface ProjetoRepository extends JpaRepository<ProjetoEntity, Long> {
}
