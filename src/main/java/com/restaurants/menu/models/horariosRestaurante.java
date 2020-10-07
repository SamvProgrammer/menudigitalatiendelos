package com.restaurants.menu.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "horarios_restaurantes")
public class horariosRestaurante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String horarios;
	private String dia;
	private boolean abierto;

	private Long id_restaurante;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHorarios() {
		return horarios;
	}

	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}

	public Long getId_restaurante() {
		return id_restaurante;
	}

	public void setId_restaurante(Long id_restaurante) {
		this.id_restaurante = id_restaurante;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public boolean isAbierto() {
		return abierto;
	}

	public void setAbierto(boolean abierto) {
		this.abierto = abierto;
	}

	
	
	
}
