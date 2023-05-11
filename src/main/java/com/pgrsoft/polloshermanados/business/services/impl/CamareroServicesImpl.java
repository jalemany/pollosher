package com.pgrsoft.polloshermanados.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.polloshermanados.business.model.Camarero;
import com.pgrsoft.polloshermanados.business.services.CamareroServices;
import com.pgrsoft.polloshermanados.integration.repositories.CamareroRepository;

import javax.transaction.Transactional;

@Service
public class CamareroServicesImpl implements CamareroServices {

	@Autowired
	private CamareroRepository camareroRepository;
	
	@Override
	public List<Camarero> getAll() {
		return camareroRepository.findAll();
	}

	@Override
	public Camarero read(String dni) {
		return camareroRepository.findById(dni).orElse(null);
	}

	@Override
	@Transactional
	public Camarero create(Camarero camarero) {
		
		boolean existe = camareroRepository.existsById(camarero.getDNI());
		
		if(existe) {
			throw new IllegalStateException("El camarero con DNI [" + camarero.getDNI() + "] ya existe. No se puede crear.");
		}
		
		return camareroRepository.save(camarero);
	}

}
