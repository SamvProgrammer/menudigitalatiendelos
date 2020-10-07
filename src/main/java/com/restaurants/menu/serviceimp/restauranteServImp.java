package com.restaurants.menu.serviceimp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.restaurants.menu.models.categoria;
import com.restaurants.menu.models.producto;
import com.restaurants.menu.models.restaurante;
import com.restaurants.menu.repository.imagenesProductosRepository;
import com.restaurants.menu.repository.logoRestaurantRepository;
import com.restaurants.menu.repository.restauranteRepository;
import com.restaurants.menu.service.restauranteService;

@Service
public class restauranteServImp implements restauranteService {

	@Autowired
	private restauranteRepository repositorio;

	@Autowired
	private logoRestaurantRepository logoRepo;
	
	
	
	@Autowired
	private imagenesProductosRepository repoimagenesProdu;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public restaurante insert(restaurante rest) {
		restaurante insertado = repositorio.save(rest);
		return insertado;
	}

	@Override
	public Map<String, String> eliminar(Long id) {

		Optional<restaurante> rest = repositorio.findById(id);
		if (rest.isPresent()) {
			restaurante restaurante = rest.get();
			if(logoRepo.findById(restaurante.getId()).isPresent()) {
				logoRepo.deleteById(restaurante.getId());
			}

			String query = "delete from imagenes_restaurante where id_restaurante = ".concat(id.toString());
			jdbcTemplate.update(query);

			for (categoria c : restaurante.getCategorias()) {
				for (producto p : c.getListaProducto()) {
					if(repoimagenesProdu.findById(p.getCodigoProducto()).isPresent()) {
						repoimagenesProdu.deleteById(p.getCodigoProducto());
					}
				}
			}
		}

		repositorio.deleteById(id);
		Map<String, String> resultado = new HashMap<String, String>();
		resultado.put("resultado", "Restaurante eliminado correctamente");
		return resultado;
	}

	@Override
	public restaurante actualizar(restaurante rest) {
		return repositorio.save(rest);
	}

	@Override
	public List<restaurante> getRestaurntes() {
		List<restaurante> restaurantes = new ArrayList<restaurante>();
		repositorio.findAll().forEach(restaurantes::add);

		return restaurantes;
	}

	@Override
	public restaurante getSoloRestaurante(Long id_restaurante) {
		Optional<restaurante> restt = repositorio.findById(id_restaurante);

		if (restt.isPresent()) {
			return restt.get();
		} else {
			return new restaurante();
		}
	}

	public restaurante getSoloRestauranteRestaurante(String nombreRestaurante) {
		
		String query = "select id_restaurante from restaurante where nombre='"+nombreRestaurante.replace("_", " ")+"'";
		Map<String,Object> mapa = jdbcTemplate.queryForMap(query);
		Long id_restauraante = Long.parseLong(String.valueOf(mapa.get("id_restaurante")));
		
		Optional<restaurante> restaoptional = this.repositorio.findById(id_restauraante);
		if(restaoptional.isPresent()) {
			 return restaoptional.get();
		}else {
			return new restaurante();
		}
	}

}
