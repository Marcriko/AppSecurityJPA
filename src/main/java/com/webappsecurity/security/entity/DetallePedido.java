package com.webappsecurity.security.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detallePedido")
public class DetallePedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetallePedido;
	@ManyToOne
	private PlatilloEntity platillo;
	@ManyToOne
	private PedidoEntity pedido;
	
	
	private String nota; //mensaje personalizado
	
	private int cantidad;
	
	public PedidoEntity getPedido() {
		return pedido;
	}
	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}
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
	
	

}
