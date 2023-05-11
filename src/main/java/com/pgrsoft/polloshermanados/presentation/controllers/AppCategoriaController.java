package com.pgrsoft.polloshermanados.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pgrsoft.polloshermanados.business.model.Categoria;
import com.pgrsoft.polloshermanados.business.services.CategoriaServices;

@Controller
public class AppCategoriaController {

	@Autowired
	private CategoriaServices categoriaServices;
	
	@GetMapping("/app/categorias")
	public String getPaginaCategorias(Model model) {
		
		List<Categoria> categorias = categoriaServices.getAll();  // MODELO
		
		model.addAttribute("categorias", categorias);
		
		return "categorias";
	}
	
}
