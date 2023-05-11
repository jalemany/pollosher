package com.pgrsoft.polloshermanados.business.services;

import java.util.List;

import com.pgrsoft.polloshermanados.business.model.Categoria;

public interface CategoriaServices {

	Categoria create(Categoria categoria);
	Categoria read(Long codigo);
	
	List<Categoria> getAll();
	int getNumeroTotalCategorias();
	
	
}
