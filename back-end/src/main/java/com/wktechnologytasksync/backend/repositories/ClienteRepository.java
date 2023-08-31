package com.wktechnologytasksync.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wktechnologytasksync.backend.entities.ClienteEntity;
import com.wktechnologytasksync.backend.service.ClienteService;


public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    ClienteService save(ClienteService cliente);
}
