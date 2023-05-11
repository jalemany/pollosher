package com.pgrsoft.polloshermanados.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgrsoft.polloshermanados.business.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	List<Pedido> findByCamareroDNIOrderByCodigo(String DNI);
	
}
