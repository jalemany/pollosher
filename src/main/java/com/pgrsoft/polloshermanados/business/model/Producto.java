package com.pgrsoft.polloshermanados.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PRODUCTOS")
public class Producto implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "GENERADOR",
					table = "SECUENCIAS",
					pkColumnName = "NOMBRE",
					pkColumnValue = "PRODUCTO_SEQ",
					valueColumnName = "VALOR",
					allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="GENERADOR")
	private Long codigo;
	
	private String nombre;
	private String descripcion;
	private Double precio;
	private Boolean descatalogado;
	
	@Temporal(value = TemporalType.DATE)
	private Date fechaAlta;
	
	@ManyToOne
	@JoinColumn(name="CODIGO_CATEGORIA")
	private Categoria categoria;
	
	public Producto() {
		
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Boolean getDescatalogado() {
		return descatalogado;
	}

	public void setDescatalogado(Boolean descatalogado) {
		this.descatalogado = descatalogado;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
		Producto other = (Producto) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
				+ precio + ", descatalogado=" + descatalogado + ", fechaAlta=" + fechaAlta + ", categoria=" + categoria
				+ "]";
	}
	
}
