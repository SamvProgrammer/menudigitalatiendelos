package com.restaurants.menu.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
public class categoria {
	@Id
	@Column(name = "id_categoria")
	private String id;
	private String nombre;
	
	private Long id_restaurante;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_categoria",referencedColumnName = "id_categoria")
	private List<producto> listaProducto;
	
	
	
	
	

	public List<producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId_restaurante() {
		return id_restaurante;
	}

	public void setId_restaurante(Long id_restaurante) {
		this.id_restaurante = id_restaurante;
	}

	
	



	
	

}
