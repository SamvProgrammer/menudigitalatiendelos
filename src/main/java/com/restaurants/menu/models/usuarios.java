package com.restaurants.menu.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class usuarios {
   
	
	@Id
	private Long id;
	private String nombre;
	private String apellido;
	private String correo;
	private String telefono;
	@Column(name = "fecha_cumpleaños")
	private Date fechaCumpleaños;
	private String password;
	private String usuario;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Date getFechaCumpleaños() {
		return fechaCumpleaños;
	}
	public void setFechaCumpleaños(Date fechaCumpleaños) {
		this.fechaCumpleaños = fechaCumpleaños;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
}
