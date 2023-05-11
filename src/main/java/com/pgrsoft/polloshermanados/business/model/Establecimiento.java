package com.pgrsoft.polloshermanados.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ESTABLECIMIENTOS")
public class Establecimiento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long codigo;
	
	private String nombreComercial;
	
	@Embedded
	private Direccion direccion;
	
	@Embedded
	@AttributeOverrides(@AttributeOverride(name="telefono", column = @Column(name="TELE")))
	private DatosContacto datosContacto;
	
	@Temporal(TemporalType.DATE)
	private Date fechaInauguracion;
	
	@Temporal(TemporalType.DATE)
	private Date fechaCierre;
	
	@Temporal(TemporalType.TIME)
	private Date horarioApertura;
	
	@Temporal(TemporalType.TIME)
	private Date horarioCierre;
	
	public Establecimiento() {
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public DatosContacto getDatosContacto() {
		return datosContacto;
	}

	public void setDatosContacto(DatosContacto datosContacto) {
		this.datosContacto = datosContacto;
	}

	public Date getFechaInauguracion() {
		return fechaInauguracion;
	}

	public void setFechaInauguracion(Date fechaInauguracion) {
		this.fechaInauguracion = fechaInauguracion;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Date getHorarioApertura() {
		return horarioApertura;
	}

	public void setHorarioApertura(Date horarioApertura) {
		this.horarioApertura = horarioApertura;
	}

	public Date getHorarioCierre() {
		return horarioCierre;
	}

	public void setHorarioCierre(Date horarioCierre) {
		this.horarioCierre = horarioCierre;
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
		Establecimiento other = (Establecimiento) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Establecimiento [codigo=" + codigo + ", nombreComercial=" + nombreComercial + ", direccion=" + direccion
				+ ", datosContacto=" + datosContacto + ", fechaInauguracion=" + fechaInauguracion + ", fechaCierre="
				+ fechaCierre + ", horarioApertura=" + horarioApertura + ", horarioCierre=" + horarioCierre + "]";
	}
	

}
