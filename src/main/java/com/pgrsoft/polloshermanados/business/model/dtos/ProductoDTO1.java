package com.pgrsoft.polloshermanados.business.model.dtos;

import java.io.Serializable;

public class ProductoDTO1 implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String producto;
	private String categoria;
	
	public ProductoDTO1() {
		
	}

	public ProductoDTO1(String producto, String categoria) {
		this.producto = producto;
		this.categoria = categoria;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "ProductoDTO1 [producto=" + producto + ", categoria=" + categoria + "]";
	}
		
}
