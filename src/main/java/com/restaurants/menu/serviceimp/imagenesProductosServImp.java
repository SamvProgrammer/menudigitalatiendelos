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

import com.restaurants.menu.models.imagenesProductos;
import com.restaurants.menu.models.producto;
import com.restaurants.menu.repository.imagenesProductosRepository;
import com.restaurants.menu.repository.productoRepository;
import com.restaurants.menu.service.imagenesProductosService;


@Service
public class imagenesProductosServImp implements imagenesProductosService{
	@Autowired
	private imagenesProductosRepository repositorio;
	
	@Autowired
	private productoRepository repositorioProducto;

	@Override
	public Map<String, String> insertarImagen(byte[] base64, String id_producto) throws IOException  {


		Optional<imagenesProductos> rest = repositorio.findById(id_producto);
		Map<String, String> resultado = new HashMap<String, String>();

		if (rest.isPresent()) {
			imagenesProductos objActual = rest.get();
			
			ByteArrayInputStream  arrayinput = new ByteArrayInputStream(base64);
			  BufferedImage originalImage = ImageIO.read(arrayinput);

			  originalImage= Scalr.resize(originalImage, Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT, 1080,566);
			   ByteArrayOutputStream baos = new ByteArrayOutputStream();
			   ImageIO.write(originalImage, "jpg", baos);
			   baos.flush();
			   byte[] imageInByte = baos.toByteArray();
			   baos.close();
			
			
			objActual.setImagen(imageInByte);
			repositorio.save(objActual);
			
			resultado.put("resultado", "Logo de la empresa ingresado con exito");
		} else {
			
			imagenesProductos objActual = new imagenesProductos();
			ByteArrayInputStream  arrayinput = new ByteArrayInputStream(base64);
			  BufferedImage originalImage = ImageIO.read(arrayinput);
			
			  originalImage= Scalr.resize(originalImage, Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT, 1080,566);
			   ByteArrayOutputStream baos = new ByteArrayOutputStream();
			   ImageIO.write(originalImage, "jpg", baos);
			   baos.flush();
			   byte[] imageInByte = baos.toByteArray();
			   baos.close();
			
			objActual.setImagen(imageInByte);
			objActual.setIdProducto(id_producto);
			this.repositorio.save(objActual);
			resultado.put("resultado", "/productoimagenes/".concat(id_producto).concat(".jpg"));
		}
		
		Optional<producto> opcional = repositorioProducto.findById(id_producto);
		
		if(opcional.isPresent()) {
			producto productoActual = opcional.get();
			String rutaUri = "/productoimagenes/".concat(id_producto).concat(".jpg");
			
			productoActual.setRutaImagen(rutaUri);
			
			repositorioProducto.save(productoActual);
		}

		return resultado;
	}

	@Override
	public byte[] consultarImagen(String id_producto) {

		byte[] resultado = null;


		Optional<imagenesProductos> rest = this.repositorio.findById(id_producto);
		if (rest.isPresent()) {
			imagenesProductos objActal = rest.get();
			byte[] base64 = objActal.getImagen();
			resultado = base64;
		}
		return resultado;
	}

}
