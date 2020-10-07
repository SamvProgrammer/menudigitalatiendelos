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

import com.restaurants.menu.models.categoria;
import com.restaurants.menu.service.categoriaService;
import com.restaurants.menu.service.imagenesProductosService;

@RestController
public class categoriasController {

	@Autowired
	private categoriaService categ;
	
	
	@Autowired
	private imagenesProductosService imagenesProductos;
	
	
	@GetMapping("/api/categorias")
	public List<categoria> getCategorias() {
		return this.categ.getCategorias();
	}
	
	
	@GetMapping("/api/categorias/{identificador}")
	public categoria getEspecifico(@PathVariable("identificador") String id_categoria) {
		
		return this.getEspecifico(id_categoria);
		
	}
	
	
	@PostMapping("/api/categorias")
	public categoria  insertar(@RequestBody categoria categ) {
		return this.categ.insert(categ);
	}
	
	@PutMapping("/api/categorias")
	public categoria  actualizar(@RequestBody categoria categ) {
		return this.categ.actualizar(categ);
	}
	
	
	@DeleteMapping("/api/categorias/imagenes/{identificador}")
	public Map<String,String> eliminar(@PathVariable("identificado") String id_categoria){
	  return this.categ.eliminar(id_categoria);	
	}
	
	
	@PostMapping("/api/categorias/productos/imagen/subir")
	public Object subirImagen(@RequestParam("file") MultipartFile archivo,@RequestParam("id_producto") String idProducto) throws IOException {
		
		byte[] arrayBytesImagen = archivo.getBytes();
		
		Map<String,String> resultado = this.imagenesProductos.insertarImagen(arrayBytesImagen, idProducto);
		
		  
		
		return resultado;
	}
	
	
	

	
	@GetMapping("/productoimagenes/{id_producto}.jpg")
	public ResponseEntity<byte[]> getPhoto(@PathVariable("id_producto") String  idProducto) {
	    
		
		byte[] image = imagenesProductos.consultarImagen(idProducto);

	    return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
	}

	
	
	
}
