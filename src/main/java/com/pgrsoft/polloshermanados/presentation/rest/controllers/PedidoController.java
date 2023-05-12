package com.pgrsoft.polloshermanados.presentation.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.polloshermanados.business.model.Pedido;
import com.pgrsoft.polloshermanados.business.services.PedidoServices;

@RestController
@CrossOrigin
public class PedidoController {

	@Autowired
	private PedidoServices pedidoServices;

	@GetMapping("/pedidos")
	public List<Pedido> getPedidos(@RequestParam(name ="dni", required = false) String dni){
		
		List<Pedido> pedidos = null;
		
		if(dni == null) {
			pedidos = pedidoServices.getAll();
		} else {
			pedidos = pedidoServices.getByCamareroDNI(dni);
		}
		
		return pedidos;
	}
	
	@GetMapping("/pedidos/{codigo}")
	public Pedido getByCodigo(@PathVariable Long codigo ){
		return pedidoServices.read(codigo);
	}
	
}
