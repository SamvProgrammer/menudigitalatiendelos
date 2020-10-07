package com.restaurants.menu.service;


import java.io.IOException;
import java.util.Map;


public interface imagenesRestauranteService {

	 public  Map<String, String> insertarImagen(byte[] base64, Long id_restaurante,String nombreArchivo)throws IOException;
	 public byte[] consultarImagen(Long id_restaurante,String nombreImagen,String resolucion)throws IOException;;
}
