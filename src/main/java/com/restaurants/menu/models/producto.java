package com.restaurants.menu.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class producto {

	@Id
	@Column(name = "id_producto")
	private String codigoProducto;
	private String nombre;
	private String descripcion;
	
	private double precio;
	
	
	@OneToMany( cascade = CascadeType.ALL )
	@JoinColumn(name = "id_producto",referencedColumnName = "id_producto")
	private List<desgloseProducto> desglose;
	
	private String id_categoria;  
	
	@Column(name = "ruta_imagen")
	private String rutaImagen;
	
	


	public String getId_categoria() {
		return id_categoria;
	}


	public void setId_categoria(String id_categoria) {
		this.id_categoria = id_categoria;
	}


	public String getCodigoProducto() {
		return codigoProducto;
	}


	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
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


	public List<desgloseProducto> getDesglose() {
		return desglose;
	}


	public void setDesglose(List<desgloseProducto> desglose) {
		this.desglose = desglose;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public String getRutaImagen() {
		return rutaImagen;
	}


	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	
	
	
}
