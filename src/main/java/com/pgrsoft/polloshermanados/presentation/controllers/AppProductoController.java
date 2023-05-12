package com.pgrsoft.polloshermanados.presentation.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pgrsoft.polloshermanados.business.model.Categoria;
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
	public String getEstadisticasProductos(Model model) {
		
		// TODO 2
		
		Map<Categoria, Integer> estadistica1 = productoServices.getEstadisticaNumeroProductosGroupByCategoria();
		Map<Categoria, Double> estadistica2 = productoServices.getEstadisticaPrecioMedioProductosGroupByCategoria();
		int numeroTotalProductos = productoServices.getNumeroTotalProductos();
		
		model.addAttribute("estadistica1", estadistica1);
		model.addAttribute("estadistica2", estadistica2);
		model.addAttribute("numeroTotalProductos", numeroTotalProductos);
		
		return "estadisticas-producto";
	}

}
