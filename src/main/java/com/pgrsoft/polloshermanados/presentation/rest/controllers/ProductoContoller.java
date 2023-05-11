package com.pgrsoft.polloshermanados.presentation.rest.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pgrsoft.polloshermanados.business.model.Producto;
import com.pgrsoft.polloshermanados.business.services.ProductoServices;

@RestController
@CrossOrigin
public class ProductoContoller {
	
	@Autowired
	private ProductoServices productoServices;
	
	@GetMapping("/productos")
	public List<Producto> getProductos(@RequestParam(name = "min", required = false) Double min,
			                           @RequestParam(name = "max", required = false) Double max){
		
		List<Producto> productos = null;
		
		if(min == null || max == null) {
			productos = productoServices.getAll();
		} else {
			productos = productoServices.getByPrecioBetween(min, max);
		}
		
		return productos;
	}
	
	@GetMapping("/productos/{codigo}")
	public ResponseEntity<?> getByCodigo(@PathVariable Long codigo){
		
		Producto producto = productoServices.read(codigo);
		
		if(producto == null) {
			
			HttpErrorResponse httpErrorResponse = new HttpErrorResponse("No existe el producto con código " + codigo);
			
			return new ResponseEntity<>(httpErrorResponse, HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(producto);
	}
	
	@PostMapping("/productos")
	public ResponseEntity<?> crear(@RequestBody Producto producto, UriComponentsBuilder ucb) {
		
		Producto createdProducto = productoServices.create(producto);
		
		URI uri = ucb.path("/productos/{codigo}").build(createdProducto.getCodigo());
				
		return ResponseEntity
				.created(uri)
				.build();
	}
	
}
