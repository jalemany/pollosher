package com.pgrsoft.polloshermanados.presentation.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.polloshermanados.business.model.Categoria;
import com.pgrsoft.polloshermanados.business.services.CategoriaServices;

@RestController
@CrossOrigin
public class CategoriaController {

	@Autowired
	private CategoriaServices categoriaServices;
	
	// end-point para devolver todas las categorías
	
	@GetMapping("/categorias")
	public List<Categoria> getAll(){
			
		// Jackson es la librería que está convirtiendo un objeto Java -> JSON
		
		return categoriaServices.getAll();
	}
	
	// end-point para devolver una categoría a partir de su código (que nos llega como path variable)
	// http://localhost:8080/categorias/4
	
	@GetMapping("/categorias/{codigo}")
	public Categoria getByCodigo(@PathVariable Long codigo) {
		
		System.out.println("Me piden la categoria " +  codigo);
		
		return categoriaServices.read(codigo);
	}
	
	// end-point para crear una categoria nueva!
	// http://localhost:8080/categorias
	
	@PostMapping("/categorias")
	public Categoria create(@RequestBody Categoria categoria) {
		
		System.out.println("vamos a crear la nueva categoria: " + categoria);
		
		Categoria createdCategoria = categoriaServices.create(categoria);
		
		return createdCategoria;
	}
	
	
}
