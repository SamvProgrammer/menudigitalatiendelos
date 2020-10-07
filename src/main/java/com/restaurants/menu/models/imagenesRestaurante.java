package com.restaurants.menu.models;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "imagenes_restaurante")
public class imagenesRestaurante {

	
	@EmbeddedId
	private llaveImagenesCompuesta llave;

	@Lob
	private byte[] imagen;

	public llaveImagenesCompuesta getLlave() {
		return llave;
	}

	public void setLlave(llaveImagenesCompuesta llave) {
		this.llave = llave;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}


	
}

