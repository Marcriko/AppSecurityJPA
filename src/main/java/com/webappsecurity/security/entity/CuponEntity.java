package com.webappsecurity.security.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "cupon")
public class CuponEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@NotBlank
	@NotNull
	private Date fechaInicio;
	@NotBlank
	@NotNull
	private Date fechaFin;
	@NotBlank
	@NotNull
	private Double descuento;
	@NotBlank
	@NotNull
	@ManyToMany
	private List<PlatilloEntity> platillos;
	@NotBlank
	@NotNull
	private Integer limiteUsos;
	//
	public int getIdCupon() {
		return id;
	}
	public void setIdCupon(int idCupon) {
		this.id = idCupon;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	public List<PlatilloEntity> getPlatillos() {
		return platillos;
	}
	public void setPlatillos(List<PlatilloEntity> platillos) {
		this.platillos = platillos;
	}
	public Integer getLimiteUsos() {
		return limiteUsos;
	}
	public void setLimiteUsos(Integer limiteUsos) {
		this.limiteUsos = limiteUsos;
	}
	
}
