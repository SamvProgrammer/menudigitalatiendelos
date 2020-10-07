package com.restaurants.menu.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class llaveImagenesCompuesta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "id_restaurante")
	private Long idRestaurante;
	@Column(name = "nombre_imagen")  
	private String nombreImagen;

	public Long getIdRestaurante() {
		return idRestaurante;
	}         

	public void setIdRestaurante(Long idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
