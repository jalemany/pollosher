package com.pgrsoft.polloshermanados.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pgrsoft.polloshermanados.business.services.PedidoServices;

@Controller
public class AppPedidosController {

	@Autowired
	private PedidoServices pedidoServices;
	
	@GetMapping("/app/pedidos")
	public String getPaginaPedidos(Model model, 
			                       @RequestParam(name="codigo", required=false) Long codigo) {
		
		// Ejemplo de controlador "controlando"...
		
		if(codigo == null) {
			model.addAttribute("pedidos", pedidoServices.getAll());
			return "pedidos";
		} else {
			model.addAttribute("pedido", pedidoServices.read(codigo));
			return "pedido";
		}
		
	}
	
}
