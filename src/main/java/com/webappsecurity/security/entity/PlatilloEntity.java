package com.webappsecurity.security.entity;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


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
<<<<<<< HEAD
<<<<<<< HEAD
	private String imagen;
=======
	private Blob imagen;
>>>>>>> parent of db24545 (ultimos cambiios)
	@NotNull
	@ManyToOne
	private CategoriaEntity categoria;
	
	
	public CategoriaEntity getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}
	public Blob getImagen() {
		return imagen;
	}
	public void setImagen(Blob imagen) {
		this.imagen = imagen;
	}
=======
	
>>>>>>> parent of 0f711a2 (imagen)
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
