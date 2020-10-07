package com.restaurants.menu.serviceimp;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurants.menu.models.categoria;
import com.restaurants.menu.models.imagenesProductos;
import com.restaurants.menu.models.producto;
import com.restaurants.menu.repository.categoriaRepository;
import com.restaurants.menu.repository.imagenesProductosRepository;
import com.restaurants.menu.repository.productoRepository;
import com.restaurants.menu.service.productosService;

@Service
public class productosServImp implements productosService{

	@Autowired
	private productoRepository repositorio;

	@Autowired
	private categoriaRepository repoCateg;
	
	
	@Autowired
	private imagenesProductosRepository repoImaProdu;
	

	@Override
	public Map<String, Object> eliminar(String codigo) {
		
		
	    Optional<producto> pro = repositorio.findById(codigo);
	   
		
		this.repositorio.deleteById(codigo);
		
		 if(pro.isPresent()) {
		    	producto producto = pro.get();
		    	String id_categoria = producto.getId_categoria();
		    	Optional<categoria> cate = repoCateg.findById(id_categoria);
		    	if(cate.isPresent()) {
		    		  categoria categoria = cate.get();
		    		  if(categoria.getListaProducto().isEmpty()) {
		    			   repoCateg.deleteById(id_categoria);
		    		  }
		    	}
		    	
		    	
		    	Optional<imagenesProductos> proImg = repoImaProdu.findById(producto.getCodigoProducto());
		    	if(proImg.isPresent()) {
		    		repoImaProdu.deleteById(producto.getCodigoProducto());
		    	}
		    }
		
		Map<String,Object> resultado = new HashMap<String,Object>();
		resultado.put("resultado","Producto eliminado correctamente!");
		
		
		
		
		return resultado;
	}

	@Override
	public producto guardarProducto(producto pro) {
		
		 return repositorio.save(pro);
	}
	
	
	
}
