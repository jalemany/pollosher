package com.pgrsoft.polloshermanados.pruebas.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.polloshermanados.business.model.Categoria;
import com.pgrsoft.polloshermanados.business.model.Producto;
import com.pgrsoft.polloshermanados.business.services.ProductoServices;

@RestController
public class ProductoServicesTestController {

	@Autowired
	private ProductoServices productoServices;
	
	@GetMapping("/producto-services/test")	
	public void testProductoServices() {
		
		System.out.println("Número total de productos: " + productoServices.getNumeroTotalProductos() + "\n");
		System.out.println(productoServices.read(100L) + "\n");
		System.out.println(productoServices.getAll());
		
		// creamos producto
		
		Producto producto = new Producto();
		
		{
			Categoria categoria = new Categoria();
			categoria.setCodigo(1L);
			
			producto.setCategoria(categoria);
			producto.setCodigo((long)(Math.random() * 100000000000L));
			producto.setDescatalogado(false);
			producto.setNombre("Producto creado desde controlador");
			producto.setDescripcion(null);
			producto.setPrecio(16.0);
			producto.setFechaAlta(new Date(1009920556633L));
			
			Producto createdProducto = productoServices.create(producto);
			
			System.out.println(createdProducto + "\n");
		}
		
		Map<Categoria, Integer> estadistica = productoServices.getEstadisticaNumeroProductosGroupByCategoria();
		
		for(Categoria categoria: estadistica.keySet()) {
			System.out.println(categoria.getNombre() + ": " + estadistica.get(categoria));
		}
		
	}

}
