package com.pgrsoft.polloshermanados.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.polloshermanados.business.model.Categoria;
import com.pgrsoft.polloshermanados.business.services.CategoriaServices;
import com.pgrsoft.polloshermanados.integration.repositories.CategoriaRepository;

@Service
public class CategoriaServicesImpl implements CategoriaServices {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public Categoria create(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public Categoria read(Long codigo) {
		return categoriaRepository.findById(codigo).orElse(null);
	}

	@Override
	public List<Categoria> getAll() {
		return categoriaRepository.findAll();
	}

	@Override
	public int getNumeroTotalCategorias() {
		return (int) categoriaRepository.count();
	}

}
