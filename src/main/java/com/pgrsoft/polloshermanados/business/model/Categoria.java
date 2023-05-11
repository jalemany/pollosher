package com.pgrsoft.polloshermanados.business.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="CATEGORIAS")
public class Categoria implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "GENERADOR",
					table = "SECUENCIAS",
					pkColumnName = "NOMBRE",
					pkColumnValue = "CATEGORIA_SEQ",
					valueColumnName = "VALOR",
					allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="GENERADOR")
	private Long codigo;
	
	private String nombre;
	
	public Categoria() {
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Categoria [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
}
