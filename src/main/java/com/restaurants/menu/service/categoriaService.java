package com.restaurants.menu.service;

import java.util.List;
import java.util.Map;

import com.restaurants.menu.models.categoria;

public interface categoriaService {
	public List<categoria> getCategorias();
	public categoria getSoloCategoria(String id_categoria);
	public categoria insert(categoria categ);
	public Map<String,String> eliminar(String id_categoria);
	public categoria actualizar(categoria categ);
}
