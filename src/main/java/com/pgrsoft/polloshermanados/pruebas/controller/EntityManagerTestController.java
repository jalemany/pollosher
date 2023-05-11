package com.pgrsoft.polloshermanados.pruebas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.polloshermanados.business.model.Camarero;
import com.pgrsoft.polloshermanados.business.model.Establecimiento;
import com.pgrsoft.polloshermanados.business.model.Producto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

//Documentación de JPA

//https://docs.oracle.com/javaee/6/tutorial/doc/bnbrg.html
//https://www.tutorialspoint.com/es/jpa/index.htm

@RestController
@RequestMapping("/em")
@SuppressWarnings("unchecked")
public class EntityManagerTestController {
	
	@Autowired
	private EntityManager em;

	@GetMapping("/trigger1")
	public void trigger3() {
			
		Query query = em.createQuery("SELECT e FROM Establecimiento AS e WHERE e.nombreComercial LIKE :nombre"); // OJO! Aquí usamos JPQL
		
		query.setParameter("nombre", "%guada%");
		query.setMaxResults(10);
		
		List<Establecimiento> establecimientos = query.getResultList();
		
		System.out.println(establecimientos);
		
	}
	
	@GetMapping("/trigger2")
	public void trigger4() {
			
		List<Producto> productos = em.createQuery("SELECT p FROM Producto p WHERE p.precio > :price ORDER BY p.precio")
									.setParameter("price", 10.0)
									.setMaxResults(100)
									.getResultList();
		
		System.out.println(productos);
	}
	
	@GetMapping("/trigger3")
	@Transactional
	public void trigger2() {
		
		// Las entidades que nos entrega el EntityManager están siendo gestionadas en un "contexto de persistencia"
		
		Camarero camarero = em.find(Camarero.class, "28778214H");
		
		System.out.println(camarero);
		
		camarero.setNombre("NOMBRE CAMBIADO DESDE JAVA");
		camarero.setApellido1("APELLIDO1 CAMBIADO DESDE JAVA");
		
		// System.out.println(1 / 0);  // Si algo va mal se lanza una excepción y se anulan todas las operaciones.
		
		camarero.setApellido2("APELLIDO2 CAMBIADO DESDE JAVA");
		
	}
	
	@GetMapping("/trigger4")
	public void trigger1() {
		
		Camarero camarero1 = em.find(Camarero.class, "28778214H");
		Camarero camarero2 = em.find(Camarero.class, "28778214H");
		
		System.out.println(camarero1);
		System.out.println(camarero2);
		
		System.out.println("camarero1 y camarero2 son iguales: " + camarero1.equals(camarero2));
		System.out.println("camarero1 y camarero2 son referencias a un mismom objeto: " + (camarero1 == camarero2));
		
	}
	
}
