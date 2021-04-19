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


@Entity
@Table(name = "promocion")
public class PromocionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int idPromocion;
	
	@NotNull
	private String descripcion;
	
	@NotNull
	private Integer limitePromociones;
	
	@NotNull
	private Date fechaInicio;
	
	@NotNull
	private Date fechaFin;
	@NotNull
	private String imagen;
	
	@NotNull
	@ManyToMany
	private List<PlatilloEntity> platillos;
	
	@NotNull
	private Double precioPromocion;
	//
	public int getIdPromocion() {
		return idPromocion;
	}
	public void setIdPromocion(int idPromocion) {
		this.idPromocion = idPromocion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getLimitePromociones() {
		return limitePromociones;
	}
	public void setLimitePromociones(Integer limitePromociones) {
		this.limitePromociones = limitePromociones;
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
	public List<PlatilloEntity> getPlatillos() {
		return platillos;
	}
	public void setPlatillos(List<PlatilloEntity> platillos) {
		this.platillos = platillos;
	}
	public Double getPrecioPromocion() {
		return precioPromocion;
	}
	public void setPrecioPromocion(Double precioPromocion) {
		this.precioPromocion = precioPromocion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	@Override
	public String toString() {
		return "PromocionEntity [idPromocion=" + idPromocion + ", descripcion=" + descripcion + ", limitePromociones="
				+ limitePromociones + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", imagen=" + imagen
				+ ", platillos=" + platillos + ", precioPromocion=" + precioPromocion + "]";
	}
	
	
}
