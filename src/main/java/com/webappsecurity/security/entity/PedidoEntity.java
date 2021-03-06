package com.webappsecurity.security.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "pedido")
public class PedidoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;
	@OneToMany
	private List <OrdenEntity> ordenes;
	
	@NotNull
	@ManyToOne
	private Usuario cliente;
	
	@NotNull
	private Date fecha;
	@ManyToOne
	private PromocionEntity promocion;
	@ManyToOne
	private CuponEntity cupon;
	
	@NotNull
	@ManyToOne
	private EstadoEntity estado;
	
	@NotNull
	private double precio;
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	//
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	
	public Usuario getCliente() {
		return cliente;
	}
	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public PromocionEntity getPromocion() {
		return promocion;
	}
	public void setPromocion(PromocionEntity promocion) {
		this.promocion = promocion;
	}
	public CuponEntity getCupon() {
		return cupon;
	}
	public void setCupon(CuponEntity cupon) {
		this.cupon = cupon;
	}
	public EstadoEntity getEstado() {
		return estado;
	}
	public void setEstado(EstadoEntity estado) {
		this.estado = estado;
	}
	
}
