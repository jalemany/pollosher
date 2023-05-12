package com.pgrsoft.polloshermanados.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pgrsoft.polloshermanados.business.model.Producto;
import com.pgrsoft.polloshermanados.business.services.ProductoServices;

@Controller
@RequestMapping("/app")
public class AppProductoController {

	@Autowired
	private ProductoServices productoServices;
	
	@GetMapping("/productos")
	public String getPaginaProductos(Model model) {
		List<Producto> productos = productoServices.getAll();  // MODELO
		model.addAttribute("productos", productos);
		return "productos";
	}

}
