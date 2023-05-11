package com.pgrsoft.polloshermanados.integration.repositories;

import java.util.Date;
import java.util.List;

// https://en.wikibooks.org/wiki/Java_Persistence/JPQL

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.pgrsoft.polloshermanados.business.model.Producto;
import com.pgrsoft.polloshermanados.business.model.dtos.ProductoDTO1;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

	// *************************************************************************
	//
	// 1.- CONSULTAS IMPLEMENTADAS CON JPQL
	//
	// *************************************************************************
	
	// 1.1 Consultas que devuelven una lista de objetos
	
	@Query("SELECT p FROM Producto p WHERE p.precio BETWEEN :min AND :max ORDER BY p.precio")			// mejor que >= AND <=
	List<Producto> getByPreciosBetween(double min, double max);
	
	@Query("SELECT p FROM Producto p WHERE p.precio > :min ORDER BY p.precio")
	List<Producto> getByPrecioMayorQueOrdenadoPorPrecio(double min);
	
	@Query("SELECT p FROM Producto p WHERE p.descripcion IS NULL AND LENGTH(p.nombre) > :numeroCaracteresNombre")
	List<Producto> getByDescripcionNullAndNombreConMasDeNCaracteres(int numeroCaracteresNombre);
	
	@Query("SELECT p FROM Producto p WHERE p.descatalogado = true AND p.fechaAlta < :fecha")
	List<Producto> getByDescatalogadosAndFechaAltaAnteriorA(Date fecha);
	
	@Query("SELECT p FROM Producto p WHERE UPPER(p.nombre) LIKE UPPER(:texto)")
	List<Producto> getByNombreProductoLike(String texto);
	
	@Query("SELECT p FROM Producto p WHERE MOD(LENGTH(p.nombre), 2) != 0 ORDER BY LENGTH(p.nombre)")
	List<Producto> getProductsConNumeroDeCaracteresEnElNombrePar();
	
	// 1.2 Consultas que devuelven un único objeto
	
	
	// 1.3 Consultas que devuelven tablas de datos
	
	@Query("SELECT p.nombre, p.precio, p.precio + (p.precio * :margen / 100), p.descatalogado FROM Producto p")
	List<Object[]> getListaPreciosVenta(double margen);
	
	// 1.4 Consultas de inserción, actualuzación y eliminación

	@Modifying
	@Query("UPDATE Producto p SET p.nombre = CONCAT('*_', p.nombre, '_*')")
	int incorporarAsteriscoALosNombres();
	
	
	@Modifying
	@Query("DELETE Producto p WHERE p.codigo = :codigo")
	int eliminarProductoAPartirCodigo(Long codigo);
	
	// TODO Completar el ejemplo
	
//	@Modifying
//	@Query("DELETE Producto p WHERE p.codigo NOT IN (SELECT DISTINCT lp.producto.codigo FROM LineaPedido lp)")
//	int eliminarProductosNoVendidos();
	
	// 1.5 Consultas que obtienen datos agrupados
	
	@Query("SELECT p.categoria, COUNT(p) FROM Producto p GROUP BY p.categoria")
	List<Object[]> getEstadisticaNumeroProductos();
	
	@Query("SELECT p.categoria, AVG(p.precio) FROM Producto p GROUP BY p.categoria")
	List<Object[]> getEstadisticaPrecioMedioProductos();
	
	// 1.6 Consultas que devuelven DTOs
	
	@Query("SELECT new com.pgrsoft.polloshermanados.business.model.dtos.ProductoDTO1(p.nombre, p.categoria.nombre) FROM Producto p ORDER BY p.nombre")
	List<ProductoDTO1> findAllProductoDTO1();
	
	// 1.8 Ejemplo del uso de COALESCE (muy util)
	
	@Query("SELECT p.nombre, COALESCE(p.descripcion, '****** DESCRIPCION NO DISPONIBLE ******') FROM Producto p")
	List<Object[]> getListaEspecialProductos();
	
	// *************************************************************************
	//
	// 2.- CONSULTAS IMPLEMENTADAS CON SISTEMA DE NOMBRES DE SPRING DATA
	//
	// https://docs.spring.io/spring-data/commons/docs/current/reference/html/
	// Appendix C: Repository query keywords
	//
	// *************************************************************************
	
	List<Producto> findByPrecioGreaterThanAndNombreLike(double precio, String nombre);
	List<Producto> findByCategoriaNombreLikeIgnoreCase(String nombreCategoria);
	
	// *************************************************************************
	//
	// 3.- CONSULTAS IMPLEMENTADAS CON SQL NATIVO
	//
	// *************************************************************************
	
	@Query(value= "SELECT P.CODIGO,          "
	    +  "              P.NOMBRE,          "
	    +  "              P.DESCRIPCION,     "
	    +  "              P.PRECIO,          "
	    +  "              P.DESCATALOGADO,   "
	    +  "              P.FECHA_ALTA,      "
	    +  "              P.CODIGO_CATEGORIA "
	
	    +  "       FROM   PRODUCTOS P        ", nativeQuery = true)
	List<Producto> getProductosDeFormaNativa();
	
}
