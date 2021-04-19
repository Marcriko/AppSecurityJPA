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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orden")
public class OrdenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetallePedido;
	@NotNull
	@ManyToOne
	private PlatilloEntity platillo;
<<<<<<< HEAD:src/main/java/com/webappsecurity/security/entity/DetallePedido.java
	
	private String nota; //mensaje personalizado
	
	private int cantidad;
	
	
	public int getIdDetallePedido() {
		return idDetallePedido;
=======
	private String nota; //mensaje personalizado
	
	private int cantidad;
	@OneToMany
	private List<IngredienteEntity> ingredientes;
	public int getIdOrden() {
		return idOrden;
>>>>>>> parent of 0f711a2 (imagen):src/main/java/com/webappsecurity/security/entity/OrdenEntity.java
	}
	public void setIdDetallePedido(int idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
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
