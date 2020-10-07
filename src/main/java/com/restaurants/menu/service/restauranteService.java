package com.restaurants.menu.service;

import java.util.List;
import java.util.Map;

import com.restaurants.menu.models.restaurante;

public interface restauranteService {
 
	public restaurante insert(restaurante rest);
	public Map<String,String> eliminar(Long id);
	public restaurante actualizar(restaurante rest);
	public List<restaurante> getRestaurntes();
	public restaurante getSoloRestaurante(Long id_restaurante);
	public restaurante getSoloRestauranteRestaurante(String nombreRestaurante);
	
}
