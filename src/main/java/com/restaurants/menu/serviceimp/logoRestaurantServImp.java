package com.restaurants.menu.serviceimp;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurants.menu.models.logoRestaurant;
import com.restaurants.menu.models.restaurante;
import com.restaurants.menu.repository.logoRestaurantRepository;
import com.restaurants.menu.repository.restauranteRepository;
import com.restaurants.menu.service.logoRestaurantService;

@Service
public class logoRestaurantServImp implements logoRestaurantService {

	@Autowired
	private logoRestaurantRepository repositorio;

	@Autowired
	private restauranteRepository repositorioRestaurante;

	@Override
	public Map<String, String> subirImagen(Long idRestaurant, byte[] imagen) throws IOException {
		
		
		logoRestaurant rest = new logoRestaurant();
		
		ByteArrayInputStream  arrayinput = new ByteArrayInputStream(imagen);
		  BufferedImage originalImage = ImageIO.read(arrayinput);

		  originalImage= Scalr.resize(originalImage, Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT, 240,240);

		   ByteArrayOutputStream baos = new ByteArrayOutputStream();
		   ImageIO.write(originalImage, "jpg", baos);
		   baos.flush();
		   byte[] imageInByte = baos.toByteArray();
		   baos.close();
		
		rest.setIdRestaurant(idRestaurant);
		rest.setImagen(imageInByte);

		repositorio.save(rest);

		Optional<restaurante> obj = repositorioRestaurante.findById(idRestaurant);
		if (obj.isPresent()) {
			String uri = "/restaurantes/logo/imagen/".concat(idRestaurant.toString());

			restaurante resultadoRestaurante = obj.get();
			resultadoRestaurante.setLogo(uri);

			this.repositorioRestaurante.save(resultadoRestaurante);
		}

		Map<String, String> resultado = new HashMap<String, String>();
		resultado.put("resultado", "Imagen insertada al restaurante");

		return resultado;
	}

	@Override
	public byte[] getImagen(Long idRestaurant) {
		byte[] resultado = null;

		Optional<logoRestaurant> rest = this.repositorio.findById(idRestaurant);
		if (rest.isPresent()) {
			logoRestaurant objActal = rest.get();
			byte[] base64 = objActal.getImagen();
			resultado = base64;
		}
		return resultado;
	}

}
