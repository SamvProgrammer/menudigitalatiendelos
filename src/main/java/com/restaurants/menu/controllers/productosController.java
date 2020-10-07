package com.restaurants.menu.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restaurants.menu.models.producto;
import com.restaurants.menu.service.productosService;

@Controller
@RequestMapping("/api")
public class productosController {

	
	@Autowired
	private productosService objProducto;
	
	
   @DeleteMapping("/productos/{identificador}")
   @ResponseBody
   public Map<String,Object> eliminadoProducto(@PathVariable("identificador")String codigo){
	    return this.objProducto.eliminar(codigo);
   }
   
   @PostMapping("/productos")
   @ResponseBody
   public producto guardarProducto(@RequestBody producto pro) {
	    return objProducto.guardarProducto(pro);
   }
}
