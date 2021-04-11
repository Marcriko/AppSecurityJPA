package com.webappsecurity.security.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
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

	@NotNull
	private Date fechaInicio;
	@NotNull
	private Date fechaFin;
	@NotNull
	private Double descuento;
	@NotNull
	private Integer limiteUsos;
	//
	@Column(unique = true)
	private String codigo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
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
	public Integer getLimiteUsos() {
		return limiteUsos;
	}
	public void setLimiteUsos(Integer limiteUsos) {
		this.limiteUsos = limiteUsos;
	}
	
}
