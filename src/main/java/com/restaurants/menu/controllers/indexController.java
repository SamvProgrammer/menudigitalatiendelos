package com.restaurants.menu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.restaurants.menu.models.restaurante;
import com.restaurants.menu.serviceimp.restauranteServImp;

@Controller
public class indexController {

	@Autowired
	private restauranteServImp restauraanteObj;
	
	

	@GetMapping({ "", "/", "/index" })
	public String index() {
		return "index";
	}

	@GetMapping("/listarestaurantes")
	public String listaRestaurants(Model modelo) {

		List<restaurante> lista = restauraanteObj.getRestaurntes();

		modelo.addAttribute("lista_restaurantes", lista);

		return "listarestaurantes";
	}

	@GetMapping("/listarestaurantesdetail")
	public String listaRestaurants_detail(@RequestParam("id_restaurante") Long idRestaurante,Model modelo) {
        restaurante rest = this.restauraanteObj.getSoloRestaurante(idRestaurante);
        modelo.addAttribute("restaurante", rest);
		return "restaurantdetail";
	}
	
	@GetMapping("/{nombreRestaurante}")
	public String listaRestaurants_detailnombre(@PathVariable("nombreRestaurante") String nombreRestaurante,Model modelo) {
        restaurante rest = this.restauraanteObj.getSoloRestauranteRestaurante(nombreRestaurante);
        modelo.addAttribute("restaurante", rest);
		return "restaurantdetail";
	}

	@GetMapping("/perfilrestaurant")
	public String perfilRestaurant(Model modelo, @RequestParam("id_restaurante") Long idRestaurante) {
		restaurante objActual = this.restauraanteObj.getSoloRestaurante(idRestaurante);
		modelo.addAttribute("restaurante", objActual);
		return "perfilrestaurant";
	}
	
	@GetMapping("/{nombreRestaurante}/perfil")
	public String perfilRestaurantNombre(@PathVariable("nombreRestaurante") String nombreRestaurante,Model modelo) {
        restaurante rest = this.restauraanteObj.getSoloRestauranteRestaurante(nombreRestaurante);
        modelo.addAttribute("restaurante", rest);
		return "perfilrestaurant";
	}

	@GetMapping("/ordenpaso1")
	public String ordenPaso1(@RequestParam("id_restaurante") Long idRestaurante,Model modelo) {
		restaurante objActual = this.restauraanteObj.getSoloRestaurante(idRestaurante);
		modelo.addAttribute("restaurante", objActual);
		return "ordenpaso1";
	}
	
	@GetMapping("/{nombreRestaurante}/ordenpaso1")
	public String ordenPaso1Nombre(@PathVariable("nombreRestaurante") String nombreRestaurante,Model modelo) {
        restaurante rest = this.restauraanteObj.getSoloRestauranteRestaurante(nombreRestaurante);
        modelo.addAttribute("restaurante", rest);
		return "ordenpaso1";
	}

	@GetMapping("/ordenpaso2")
	public String ordenPaso2(@RequestParam("id_restaurante") Long idRestaurante,Model modelo) {
		restaurante objActual = this.restauraanteObj.getSoloRestaurante(idRestaurante);
		modelo.addAttribute("restaurante", objActual);
		return "ordenpaso2";
	}
	
	@GetMapping("/{nombreRestaurante}/ordenpaso2")
	public String ordenPaso2Nombre(@PathVariable("nombreRestaurante") String nombreRestaurante,Model modelo) {
        restaurante rest = this.restauraanteObj.getSoloRestauranteRestaurante(nombreRestaurante);
        modelo.addAttribute("restaurante", rest);
		return "ordenpaso2";
	}

	@GetMapping("/ordenpaso3")
	public String ordenPaso3(@RequestParam("id_restaurante") Long idRestaurante,Model modelo) {
		restaurante objActual = this.restauraanteObj.getSoloRestaurante(idRestaurante);
		modelo.addAttribute("restaurante", objActual);
		return "ordenpaso3";
	}
	
	@GetMapping("/{nombreRestaurante}/ordenpaso3")
	public String ordenPaso3Nombre(@PathVariable("nombreRestaurante") String nombreRestaurante,Model modelo) {
        restaurante rest = this.restauraanteObj.getSoloRestauranteRestaurante(nombreRestaurante);
        modelo.addAttribute("restaurante", rest);
		return "ordenpaso3";
	}


	@GetMapping("/administrativo/restaurantes")
	public String administracion(Model modelo) {
        List<restaurante> restaurantes = this.restauraanteObj.getRestaurntes();
        modelo.addAttribute("restaurantes", restaurantes);
		return "admin";
	}
	
	

}
