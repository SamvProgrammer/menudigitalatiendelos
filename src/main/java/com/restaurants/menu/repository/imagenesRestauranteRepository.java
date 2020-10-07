package com.restaurants.menu.repository;

import org.springframework.data.repository.CrudRepository;

import com.restaurants.menu.models.imagenesRestaurante;
import com.restaurants.menu.models.llaveImagenesCompuesta;


public interface imagenesRestauranteRepository extends CrudRepository<imagenesRestaurante, llaveImagenesCompuesta>{

}
