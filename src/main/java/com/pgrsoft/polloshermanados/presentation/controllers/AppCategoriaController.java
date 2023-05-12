package com.pgrsoft.polloshermanados.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pgrsoft.polloshermanados.business.model.Categoria;
import com.pgrsoft.polloshermanados.business.services.CategoriaServices;

@Controller
@RequestMapping("/app")
public class AppCategoriaController {
	
	@Autowired
	private CategoriaServices categoriaServices;
	
	@GetMapping("/categorias")
	public String getPaginaCategorias(Model model) {
		List<Categoria> categorias = categoriaServices.getAll();  // MODELO
		model.addAttribute("categorias", categorias);
		return "categorias";
	}
	
	@GetMapping("/alta-categoria")
    public String showForm(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "formulario-alta-categoria";
    }
	
	@PostMapping("/crear-categoria")
	public String submitForm(@ModelAttribute("categoria") Categoria categoria) {
	    categoriaServices.create(categoria);
	    return "redirect:/app/categorias";
	}

}
