package com.restaurants.menu.service;

import java.io.IOException;
import java.util.Map;

public interface imagenesProductosService  {
	public  Map<String, String> insertarImagen(byte[] base64, String id_producto)  throws IOException;
	 public byte[] consultarImagen(String id_producto);
}
