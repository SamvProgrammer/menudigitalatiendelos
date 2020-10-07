package com.restaurants.menu.controllers;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.restaurants.menu.service.imagenesRestauranteService;

@RestController()
public class imagenesRestauranteController {
	
	@Autowired
	private imagenesRestauranteService obj;

	@PostMapping("/api/restaurantesimagenes/subir")
	public Object subirImagen(@RequestParam("file") MultipartFile archivo, @RequestParam("id_restaurante") Long id)
			throws IOException {

		byte[] arrayBytesImagen = archivo.getBytes();
		String nombreArchivo = archivo.getOriginalFilename();
		

		Map<String, String> resultado = this.obj.insertarImagen(arrayBytesImagen, id,nombreArchivo);

		return resultado;
	}
	
	
	@GetMapping("/restaurantesimagenes/imagen/{id_restaurante}/{nombre_imagen}")
	public ResponseEntity<byte[]> getPhoto(@PathVariable("id_restaurante") Long idRestaurante,@PathVariable("nombre_imagen") String nombreImagen,@RequestParam(name = "resolucion",required = false) String resolucion) throws IOException {
	    
		
		byte[] image = obj.consultarImagen(idRestaurante,nombreImagen,resolucion);

	    return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
	}

}
