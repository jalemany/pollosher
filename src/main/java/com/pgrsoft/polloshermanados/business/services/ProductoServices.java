package com.pgrsoft.polloshermanados.business.services;

import java.util.List;
import java.util.Map;

import com.pgrsoft.polloshermanados.business.model.Categoria;
import com.pgrsoft.polloshermanados.business.model.Producto;
import com.pgrsoft.polloshermanados.business.model.dtos.ProductoDTO1;

public interface ProductoServices {

	Producto create(Producto producto);
	Producto read(Long codigo);        // si el producto no existe me devuelve null
	
	List<Producto> getAll();		   // devuelve todos los productos
	int getNumeroTotalProductos();	   // devuelve el número total de productos
	
	// Necesitamos filtros customizados
	
	List<Producto> getByPrecioBetween(double min, double max);
	
	// Necesitamos datos estadísticos
	
	Map<Categoria, Integer> getEstadisticaNumeroProductosGroupByCategoria();
	Map<Categoria, Double> getEstadisticaPrecioMedioProductosGroupByCategoria();
	
	// Necesitamos datos procesados, DTOs (datos que no son exactamente el modelo de business)
	
	List<ProductoDTO1> getAllProductoDTO1();
	
}
