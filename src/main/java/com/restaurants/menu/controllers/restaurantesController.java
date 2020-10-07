package com.restaurants.menu.controllers;

import java.io.IOException;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.restaurants.menu.models.restaurante;
import com.restaurants.menu.service.logoRestaurantService;
import com.restaurants.menu.service.restauranteService;


@RestController
public class restaurantesController {

	@Autowired
	private restauranteService restaurante;
	
	
	@Autowired
	private logoRestaurantService servicioLogo;
	
	@GetMapping("/api/restaurantes")
	public List<restaurante> getAllRestaurantes() {
		return restaurante.getRestaurntes();
	}
	
	@DeleteMapping("/api/restaurantes/{identificador}")
	public Map<String,String> eliminar(@PathVariable("identificador") Long id){
		return this.restaurante.eliminar(id);
	}
	
	
	@PutMapping("/api/restaurantes")
	public restaurante update(restaurante rest) {
		return this.restaurante.actualizar(rest);
	}
	
	
	@GetMapping("/api/restaurantes/{id}")
	public restaurante getRestaurante(@PathVariable("id") Long id) {
		return this.restaurante.getSoloRestaurante(id);
		
	}
	
	
	@PostMapping("/api/restaurantes")
	public restaurante insertarRestaurante(@RequestBody restaurante rest) {
		return this.restaurante.insert(rest);
	}
	
	
	@PostMapping("/api/restaurantes/logo")
	public Object subirImagen(@RequestParam("file") MultipartFile archivo,@RequestParam("id_restaurante") Long id) throws IOException {
		
		byte[] arrayBytesImagen = archivo.getBytes();
		
		Map<String,String> resultado = this.servicioLogo.subirImagen(id,arrayBytesImagen);
		
		  
		
		return resultado;
	}
	
	
	

	
	@GetMapping("/restaurantes/logo/imagen/{id_restaurante}")
	public ResponseEntity<byte[]> getPhoto(@PathVariable("id_restaurante") Long idRestaurante) {
	    
		
		byte[] image = servicioLogo.getImagen(idRestaurante);

	    return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
	}
	
	
	
	
}

