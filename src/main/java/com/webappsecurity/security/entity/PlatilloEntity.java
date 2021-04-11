package com.webappsecurity.security.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
@Table(name = "platillo")
public class PlatilloEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlatillo;
	@NotNull
	private String nombre;

	@NotNull
	private String descripcion;

	@NotNull
	private Double precio;
	@ManyToMany
	private List<IngredienteEntity> ingredientes;
	
	//
	public int getIdPlatillo() {
		return idPlatillo;
	}
	public void setIdPlatillo(int idPlatillo) {
		this.idPlatillo = idPlatillo;
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
	public List<IngredienteEntity> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<IngredienteEntity> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
}
