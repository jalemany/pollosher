package com.pgrsoft.polloshermanados.presentation.rest.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pgrsoft.polloshermanados.business.model.Categoria;
import com.pgrsoft.polloshermanados.business.services.CategoriaServices;

@RestController
@CrossOrigin
public class CategoriaController {

	@Autowired
	private CategoriaServices categoriaServices;
	
	@GetMapping("/categorias")
	public List<Categoria> getAll(){
		return categoriaServices.getAll();
	}
	
	@GetMapping("/categorias/{codigo}")
	public Categoria getByCodigo(@PathVariable Long codigo) {
		return categoriaServices.read(codigo);
	}

	@PostMapping("/categorias")
	public ResponseEntity<?> create(@RequestBody Categoria categoria, UriComponentsBuilder ucb) {
		
		Categoria createdCategoria = categoriaServices.create(categoria);
		
		URI uri = ucb.path("/categorias/{codigo}").build(createdCategoria.getCodigo());
		
		return ResponseEntity
				.created(uri)
				.build();
	}
	
}
