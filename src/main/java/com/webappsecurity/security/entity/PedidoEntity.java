package com.webappsecurity.security.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "pedido")
public class PedidoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;
	@ManyToMany
	private List<PlatilloEntity> platillos;
	
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
	//
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public List<PlatilloEntity> getPlatillos() {
		return platillos;
	}
	public void setPlatillos(List<PlatilloEntity> platillos) {
		this.platillos = platillos;
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
