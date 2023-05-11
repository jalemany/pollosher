package com.pgrsoft.polloshermanados.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgrsoft.polloshermanados.business.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}
