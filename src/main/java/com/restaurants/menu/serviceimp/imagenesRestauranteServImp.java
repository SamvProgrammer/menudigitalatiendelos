package com.restaurants.menu.serviceimp;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurants.menu.models.imagenesRestaurante;
import com.restaurants.menu.models.llaveImagenesCompuesta;
import com.restaurants.menu.models.restaurante;
import com.restaurants.menu.repository.imagenesRestauranteRepository;
import com.restaurants.menu.repository.restauranteRepository;
import com.restaurants.menu.service.imagenesRestauranteService;

@Service
public class imagenesRestauranteServImp implements imagenesRestauranteService {

	@Autowired
	private imagenesRestauranteRepository repositorio;
	
	@Autowired
	private restauranteRepository repositorioRestaurante;

	@Override
	public Map<String, String> insertarImagen(byte[] base64, Long id_restaurante, String nombreArchivo) throws IOException {

		llaveImagenesCompuesta llave = new llaveImagenesCompuesta();
		llave.setIdRestaurante(id_restaurante);
		llave.setNombreImagen(nombreArchivo);

		Optional<imagenesRestaurante> rest = repositorio.findById(llave);
		Map<String, String> resultado = new HashMap<String, String>();

		if (rest.isPresent()) {
			imagenesRestaurante objActual = rest.get();
			objActual.setImagen(base64);
			repositorio.save(objActual);
			
			resultado.put("resultado", "Logo de la empresa ingresado con exito");
		} else {
			
			imagenesRestaurante objActual = new imagenesRestaurante();
			
			ByteArrayInputStream  arrayinput = new ByteArrayInputStream(base64);
			  BufferedImage originalImage = ImageIO.read(arrayinput);

			  originalImage= Scalr.resize(originalImage, Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT, 1080,566);
			  
			   ByteArrayOutputStream baos = new ByteArrayOutputStream();
			   ImageIO.write(originalImage, "jpg", baos);
			   baos.flush();
			   byte[] imageInByte = baos.toByteArray();
			   baos.close();
			
			objActual.setImagen(imageInByte);
			objActual.setLlave(llave);
			this.repositorio.save(objActual);
			resultado.put("resultado", "Error al agregar el logo de la empresa");
		}
		
		Optional<restaurante> opcional = repositorioRestaurante.findById(id_restaurante);
		
		if(opcional.isPresent()) {
			restaurante restauranteActual = opcional.get();
			String rutaUri = "/restaurantesimagenes/imagen/".concat(id_restaurante.toString()).concat("/").concat(nombreArchivo);
			
			ArrayList<String> listaActual = restauranteActual.getRuta_imagenes();
			if(listaActual != null) {
				listaActual.add(rutaUri);
			}else {
				listaActual = new ArrayList<String>();
				listaActual.add(rutaUri);
			}
			
			restauranteActual.setRuta_imagenes(listaActual);
			
			repositorioRestaurante.save(restauranteActual);
		}

		return resultado;
	}

	@Override
	public byte[] consultarImagen(Long id_restaurante, String nombreImagen,String resolucion) throws IOException {

		byte[] resultado = null;

		llaveImagenesCompuesta llave = new llaveImagenesCompuesta();
		llave.setIdRestaurante(id_restaurante);
		llave.setNombreImagen(nombreImagen);

		Optional<imagenesRestaurante> rest = this.repositorio.findById(llave);
		if (rest.isPresent()) {
			imagenesRestaurante objActal = rest.get();
			byte[] base64 = objActal.getImagen();
			
			if(resolucion != null) {
				if(resolucion.equals("baja")) {
					ByteArrayInputStream  arrayinput = new ByteArrayInputStream(base64);
					  BufferedImage originalImage = ImageIO.read(arrayinput);

					  originalImage= Scalr.resize(originalImage, Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT, 80, 120);
				
					   ByteArrayOutputStream baos = new ByteArrayOutputStream();
					   ImageIO.write(originalImage, "jpg", baos);
					   baos.flush();
					   byte[] imageInByte = baos.toByteArray();
					   baos.close();
					   resultado = imageInByte;
					
				}
			}else {
			   resultado = base64;
			}
		}
		return resultado;
	}

}
