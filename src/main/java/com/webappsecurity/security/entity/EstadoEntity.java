package com.webappsecurity.security.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;

@Entity
@Table(name = "Estado")
public class EstadoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstado;
	@NotBlank
	@NotNull
	private String estado;
	//
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
