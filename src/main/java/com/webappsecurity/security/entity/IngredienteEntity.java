package com.webappsecurity.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;

@Entity
@Table(name = "ingrediente")
public class IngredienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIngrediente;
	@NotNull(message = "Ingresar un nombre para el ingrediente")
	@Column(unique = true)
	private String nombre;
	//
	public int getIdIngrediente() {
		return idIngrediente;
	}
	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "IngredienteEntity [idIngrediente=" + idIngrediente + ", nombre=" + nombre + "]";
	}
}
