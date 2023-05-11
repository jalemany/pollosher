package com.pgrsoft.polloshermanados.pruebas.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.polloshermanados.business.model.Categoria;
import com.pgrsoft.polloshermanados.business.model.Producto;
import com.pgrsoft.polloshermanados.business.model.dtos.ProductoDTO1;
import com.pgrsoft.polloshermanados.integration.repositories.ProductoRepository;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/producto-repository")
public class ProductoRepositoryTestController {

	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping("/test1")
	public void test1(){
		
		// Métodos del interface JpaRepository<T,K> implementados automáticamente por Spring Data 
		
		System.out.println("Número de productos: " + productoRepository.count());
		System.out.println("El producto 105 existe: " + productoRepository.existsById(105L));
		System.out.println("Producto 112L: " + productoRepository.findById(112L).orElse(null));
		
		System.out.println("\nTodos los productos:\n");
		
		for(Producto producto: productoRepository.findAll()) {
			System.out.println(producto);
		}
	
		System.out.println("\nProductos ordenados por nombre de categoria y nombre de producto:\n");
		
		for(Producto producto : productoRepository.findAll(Sort.by("categoria.nombre","nombre"))) {
			System.out.println(producto.getCategoria().getNombre() + ": " + producto.getNombre());
		}
		
		productoRepository.deleteById(119L);
		
		// Persistir un producto
		
		Producto producto = new Producto();
		
		Categoria categoria = new Categoria();
		categoria.setCodigo(1L);
		
		producto.setCategoria(categoria);
		producto.setCodigo((long)(Math.random() * 100000000000L));
		producto.setDescatalogado(false);
		producto.setNombre("Whisky Oban");
		producto.setDescripcion("Delicioso Whisky escocés de 14 años");
		producto.setPrecio(16.0);
		producto.setFechaAlta(new Date(1009920556633L)); //1009920556633L milisegundos a partir de 01/01/1970
		
		Producto createdProduct = productoRepository.save(producto);
		
		System.out.println(createdProduct);
		
	}
	
	@GetMapping("/test2")
	public void test2(){
		
		// Métodos implementados con JPQL (usando la anotación @Query de Spring Data)
		
		//System.out.println(productoRepository.getProductsConNumeroDeCaracteresEnElNombrePar()); 
		//System.out.println(productoRepository.getByPreciosBetween(5.0, 10.0));
		//System.out.println(productoRepository.getByPrecioMayorQueOrdenadoPorPrecio(10.0));
		//System.out.println(productoRepository.getByDescatalogadosAndFechaAltaAnteriorA(new Date()));
		//System.out.println(productoRepository.getByNombreProductoLike("%CoN%"));
		//System.out.println(productoRepository.getProductsConNumeroDeCaracteresEnElNombrePar());
		
		List<Object[]> tabla = productoRepository.getEstadisticaNumeroProductos();
		
		for(Object[] fila: tabla) {
			System.out.println(Arrays.toString(fila));
		}
		
	}
	
	@GetMapping("/test3")
	public void test3(){
		
		// Métodos implementados automáticamente por Spring Data usando reflection.

		for(Producto producto: productoRepository.findByPrecioGreaterThanAndNombreLike(7.0, "%dillo%")) {
			System.out.println(producto);
		}
	}
	
	@GetMapping("/test4")
	public void test4(){
		
		// Métodos que devuelven DTOs
		
		for(ProductoDTO1 productoDTO1: productoRepository.findAllProductoDTO1()) {
			System.out.println(productoDTO1.getCategoria() + ": " + productoDTO1.getProducto());
		}
		
	}
	
	@GetMapping("/test5")
	public void test5(){
		
		// Métodos que devuelven tablas de datos
		
		List<Object[]> tabla = productoRepository.getListaPreciosVenta(100.0);
		
		for(Object[] fila: tabla) {
			
			Object columna0 = fila[0];
			Object columna1 = fila[1];
			Object columna2 = fila[2];
			Object columna3 = fila[3];
			
			String nombre = (String) columna0;
			Double precio = (Double) columna1;
			Double precioVenta = (Double) columna2;
			Boolean descatalogado = (Boolean) columna3;
			
			System.out.println(nombre + ": " + precio + "  [" + precioVenta + "]  " + descatalogado);
			
		}
		
	}
	
	@GetMapping("/test6")
	@Transactional
	public void test6(){
		
		// Métodos que insertan, actualizan o eliminan...
		
		int numeroProductosActualizados = productoRepository.incorporarAsteriscoALosNombres();
		
		System.out.println("Número de productos actualizados: " + numeroProductosActualizados);
		
		int numeroProductosEliminados = productoRepository.eliminarProductoAPartirCodigo(168L);
		
		System.out.println("Número de productos eliminados: " + numeroProductosEliminados);
		
		//productoRepository.eliminarProductosNoVendidos();
		
	}
	
	@GetMapping("/test7")
	public void test7(){
		
		List<Object[]> resultados = productoRepository.getListaEspecialProductos();
		
		for(Object[] fila: resultados) {
			System.out.println(fila[0] + ": " + fila[1]);
		}
		
	}
	
	@GetMapping("/test8")
	public void test8(){
		
		List<Producto> productos = productoRepository.getProductosDeFormaNativa();
		
		for(Producto producto: productos) {
			System.out.println(producto);
		}
		
	}

}
