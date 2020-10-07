package com.restaurants.menu.serviceimp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurants.menu.models.categoria;
import com.restaurants.menu.repository.categoriaRepository;
import com.restaurants.menu.service.categoriaService;

@Service
public class categoriaServImp implements categoriaService{
	
	@Autowired
	private categoriaRepository repositorio;

	@Override
	public List<categoria> getCategorias() {
		List<categoria> lista = new ArrayList<categoria>();
		this.repositorio.findAll().forEach(lista::add);
		return lista;
	}

	@Override
	public categoria getSoloCategoria(String id_categoria) {
		Optional<categoria>  esCategoria = this.repositorio.findById(id_categoria);
	    categoria categ;
		if(esCategoria.isPresent()) {
			categ = esCategoria.get();
		}else {
			categ = new categoria();
		}
		return categ;
	}

	@Override
	public categoria insert(categoria categ) {
		categoria objActual = this.repositorio.save(categ);
		return objActual;
	}

	@Override
	public Map<String, String> eliminar(String id_categoria) {
		Map<String,String> resultado = new HashMap<String, String>();
		this.repositorio.deleteById(id_categoria);
		
		resultado.put("resultado","Categoria eliminada");
		return null;
	}

	@Override
	public categoria actualizar(categoria categ) {
		categoria objActual = this.repositorio.save(categ);
		return objActual;
	}
	

}
