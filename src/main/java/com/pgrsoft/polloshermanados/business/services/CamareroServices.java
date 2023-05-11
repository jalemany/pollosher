package com.pgrsoft.polloshermanados.business.services;

import java.util.List;

import com.pgrsoft.polloshermanados.business.model.Camarero;

public interface CamareroServices {

	Camarero read(String dni);
	Camarero create(Camarero camarero);
	
	List<Camarero> getAll();
	
	
	
}
