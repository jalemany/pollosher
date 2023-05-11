package com.pgrsoft.polloshermanados.presentation.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pgrsoft.polloshermanados.business.model.Camarero;
import com.pgrsoft.polloshermanados.business.services.CamareroServices;

@RestController
@CrossOrigin
public class CamareroController {
	
	@Autowired
	private CamareroServices camareroServices;
	
	@GetMapping("/camareros")
	public List<Camarero> getAll(){
		return camareroServices.getAll();
	}
	
	@GetMapping("/camareros/{dni}")
	public ResponseEntity<?> getByDni(@PathVariable("dni") String DNI) {
		
		Camarero camarero = camareroServices.read(DNI);
		
		if(camarero == null) {
		
			HttpErrorResponse httpErrorResponse = new HttpErrorResponse("No existe el camarero con DNI " + DNI);
			
			return new ResponseEntity<>(httpErrorResponse, HttpStatus.NOT_FOUND);
		} 
		
		return ResponseEntity.ok(camarero); 
	}
	
	@PostMapping("/camareros")
	public ResponseEntity<?> create(@RequestBody Camarero camarero, UriComponentsBuilder ucb) {
		
		Camarero createdCamarero = null;
			
		try {
			createdCamarero = camareroServices.create(camarero);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new HttpErrorResponse(e.getMessage()));
			
		}
		
		return ResponseEntity
				.created(ucb.path("/camareros/{dni}").build(createdCamarero.getDNI()))
				.build();
	}
	
}
