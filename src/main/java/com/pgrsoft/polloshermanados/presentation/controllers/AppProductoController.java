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
	
	@GetMapping("/productos/estadisticas")
	public String getEstadisticasProductos() {
		
		// TODO 2
		
		// Devolvemos una página de estadísticas de productos que incluye:
		
		// 1.- Número total de productos
		// 2.- Número total de productos para cada categoria (tabla)
		// 3.- Precop medio de productos para cada catgoria (tabla)
		
		// Tenemos que llamar a la lógica de negocio, enviar el modelo a la vita y crear la vista...
		
		return null;
	}

}
