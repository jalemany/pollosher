package com.pgrsoft.polloshermanados.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.polloshermanados.business.model.Pedido;
import com.pgrsoft.polloshermanados.business.services.PedidoServices;
import com.pgrsoft.polloshermanados.integration.repositories.PedidoRepository;

@Service
public class PedidoServicesImpl implements PedidoServices {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public List<Pedido> getAll() {
		return pedidoRepository.findAll();
	}

	@Override
	public Pedido create(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@Override
	public Pedido read(Long codigo) {
		return pedidoRepository.findById(codigo).orElse(null);
	}

	@Override
	public List<Pedido> getByCamareroDNI(String DNI) {
		return pedidoRepository.findByCamareroDNIOrderByCodigo(DNI);
	}

}
