package com.restaurants.menu.service;

import java.util.Map;

import com.restaurants.menu.models.producto;

public interface productosService {

	
	public Map<String,Object> eliminar(String codigo);
	
	public producto guardarProducto(producto pro);
}
