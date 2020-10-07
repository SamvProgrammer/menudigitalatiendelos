package com.restaurants.menu.service;

import java.io.IOException;
import java.util.Map;

public interface logoRestaurantService {

	
	public Map<String,String> subirImagen(Long idRestaurant,byte[] imagen) throws IOException;
	
	public byte[] getImagen(Long idRestaurant);
	
}
