package com.restaurants.menu.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "desglose_producto")
public class desgloseProducto {

	
	@Id
	@Column(name = "id_desglose")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	   
	private String nombre;
	private double precio;
	
	@Column(name = "modo_seleccion")
	private String modoSeleccion;
	
	
	
	private String id_producto;
	
	

	public String getId_producto() {
		return id_producto;
	}

	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getModoSeleccion() {
		return modoSeleccion;
	}

	public void setModoSeleccion(String modoSeleccion) {
		this.modoSeleccion = modoSeleccion;
	}

	

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
