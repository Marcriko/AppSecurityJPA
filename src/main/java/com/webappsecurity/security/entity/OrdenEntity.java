package com.webappsecurity.security.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orden")
public class OrdenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOrden;
	@ManyToOne
	private PlatilloEntity platillo;
	private String nota; //mensaje personalizado
	
	private int cantidad;
	@OneToMany
	private List<IngredienteEntity> ingredientes;
	public int getIdOrden() {
		return idOrden;
	}
	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}
	public PlatilloEntity getPlatillo() {
		return platillo;
	}
	public void setPlatillo(PlatilloEntity platillo) {
		this.platillo = platillo;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public List<IngredienteEntity> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<IngredienteEntity> ingredientes) {
		this.ingredientes = ingredientes;
	}
	

}
