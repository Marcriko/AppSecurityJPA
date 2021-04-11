package com.webappsecurity.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webappsecurity.security.entity.CuponEntity;
import com.webappsecurity.security.entity.IngredienteEntity;



@Repository
public interface IngredienteRepository extends JpaRepository<IngredienteEntity, Integer>{
	IngredienteEntity findByIdIngrediente(int idIngrediente);
	IngredienteEntity findByNombre(String nombreIngrediente);
}
