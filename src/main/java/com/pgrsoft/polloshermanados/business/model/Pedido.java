package com.pgrsoft.polloshermanados.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PEDIDOS")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "GENERADOR",
					table = "SECUENCIAS",
					pkColumnName = "NOMBRE",
					pkColumnValue = "PEDIDO_SEQ",
					valueColumnName = "VALOR",
					allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="GENERADOR")
	private Long codigo;
	
	@Column(name="FECHA_HORA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="DNI_CAMARERO")
	private Camarero camarero;
	
	@ManyToOne
	@JoinColumn(name="DNI_CLIENTE")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="CODIGO_ESTABLECIMIENTO")
	private Establecimiento establecimiento;
	
	@Enumerated(EnumType.STRING)
	private EstadoPedido estado;
	
	@ElementCollection
	@JoinTable(name="LINEAS_PEDIDO",
	           joinColumns = @JoinColumn(name = "CODIGO_PEDIDO"))
	private List<LineaPedido> lineas;
	
	public Pedido() {
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Camarero getCamarero() {
		return camarero;
	}

	public void setCamarero(Camarero camarero) {
		this.camarero = camarero;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Establecimiento getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(Establecimiento establecimiento) {
		this.establecimiento = establecimiento;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public List<LineaPedido> getLineas() {
		return lineas;
	}

	public void setLineas(List<LineaPedido> lineas) {
		this.lineas = lineas;
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
		Pedido other = (Pedido) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", fecha=" + fecha + ", camarero=" + camarero + ", estado=" + estado
				+ ", lineas=" + lineas + "]";
	}

}
