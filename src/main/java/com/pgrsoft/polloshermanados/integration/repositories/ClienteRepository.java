package com.pgrsoft.polloshermanados.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgrsoft.polloshermanados.business.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
