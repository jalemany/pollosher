package com.pgrsoft.polloshermanados.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgrsoft.polloshermanados.business.model.Camarero;

public interface CamareroRepository extends JpaRepository<Camarero, String> {

}
