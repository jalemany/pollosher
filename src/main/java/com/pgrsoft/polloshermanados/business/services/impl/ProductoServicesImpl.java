package com.pgrsoft.polloshermanados.business.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.polloshermanados.business.model.Categoria;
import com.pgrsoft.polloshermanados.business.model.Producto;
import com.pgrsoft.polloshermanados.business.model.dtos.ProductoDTO1;
import com.pgrsoft.polloshermanados.business.services.ProductoServices;
import com.pgrsoft.polloshermanados.integration.repositories.CategoriaRepository;
import com.pgrsoft.polloshermanados.integration.repositories.ProductoRepository;

import javax.transaction.Transactional;

@Service
public class ProductoServicesImpl implements ProductoServices{

	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	@Transactional
	public Producto create(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Producto read(Long codigo) {
		return productoRepository.findById(codigo).orElse(null);
	}

	@Override
	public List<Producto> getAll() {
		return productoRepository.findAll();
	}

	@Override
	public int getNumeroTotalProductos() {
		return (int) productoRepository.count();
	}

	@Override
	public List<Producto> getByPrecioBetween(double min, double max) {
		return productoRepository.getByPreciosBetween(min, max);
	}

	@Override
	public Map<Categoria, Integer> getEstadisticaNumeroProductosGroupByCategoria() {
		
		List<Object[]> resultados = productoRepository.getEstadisticaNumeroProductos();
		
		Map<Categoria, Integer> mapaResultados = new HashMap<>();
		
		// No sería necesario silicitar todas las categorias si la query JPQL en el repositorio hiciera bien su trabajo.
		
		List<Categoria> categorias = categoriaRepository.findAll();
		
		for(Categoria categoria: categorias) {
			mapaResultados.put(categoria, 0);
		}
		
		for(Object[] fila : resultados) {
			Categoria categoria = (Categoria) fila[0];
			Integer numeroProductos = ((Long) fila[1]).intValue();
			mapaResultados.replace(categoria, numeroProductos);
		}
		
		return mapaResultados;
	}

	@Override
	public Map<Categoria, Double> getEstadisticaPrecioMedioProductosGroupByCategoria() {
		
		List<Object[]> resultados = productoRepository.getEstadisticaPrecioMedioProductos();
		
		Map<Categoria, Double> mapaResultados = new HashMap<>();
		
		List<Categoria> categorias = categoriaRepository.findAll();
		
		for(Categoria categoria: categorias) {
			mapaResultados.put(categoria, null);
		}
		
		for(Object[] fila : resultados) {
			Categoria categoria = (Categoria) fila[0];
			Double numeroProductos = (Double) fila[1];
			mapaResultados.replace(categoria, numeroProductos);
		}
		
		return mapaResultados;
	}

	@Override
	public List<ProductoDTO1> getAllProductoDTO1() {
		return productoRepository.findAllProductoDTO1();
	}

}
