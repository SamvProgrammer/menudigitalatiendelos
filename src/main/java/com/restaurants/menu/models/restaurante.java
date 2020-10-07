package com.restaurants.menu.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;


@Entity
public class restaurante {
	@Id
	@Column(name = "id_restaurante")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String descripcion;
	private String telefono;
	private String correo;
	private String pais;
	private String direccion1;
	private String direccion2;
	private String ciudad;
	private String estado;
	private String codigopostal;
	
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "id_restaurante",referencedColumnName = "id_restaurante")
	private List<categoria> categorias;
	
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_restaurante",referencedColumnName = "id_restaurante")
	@OrderBy("id ASC")
	private List<horariosRestaurante> horarios;
	
	
	
	ArrayList<String> ruta_imagenes;
	
	
	private String logo;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDireccion1() {
		return direccion1;
	}

	public void setDireccion1(String direccion1) {
		this.direccion1 = direccion1;
	}

	public String getDireccion2() {
		return direccion2;
	}

	public void setDireccion2(String direccion2) {
		this.direccion2 = direccion2;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}

	

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public ArrayList<String> getRuta_imagenes() {
		return ruta_imagenes;
	}

	public void setRuta_imagenes(ArrayList<String> ruta_imagenes) {
		this.ruta_imagenes = ruta_imagenes;
	}

	public List<categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<categoria> categorias) {
		this.categorias = categorias;
	}

	public List<horariosRestaurante> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<horariosRestaurante> horarios) {
		this.horarios = horarios;
	}

	

	

}
