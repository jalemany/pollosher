package com.pgrsoft.polloshermanados.business.services;

import java.util.List;

import com.pgrsoft.polloshermanados.business.model.Pedido;

public interface PedidoServices {

	Pedido create(Pedido pedido);
	Pedido read(Long codigo);  
	
	List<Pedido> getAll();
	List<Pedido> getByCamareroDNI(String DNI);
      
}
