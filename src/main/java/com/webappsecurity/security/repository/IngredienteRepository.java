package com.webappsecurity.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webappsecurity.security.entity.IngredienteEntity;



@Repository
public interface IngredienteRepository extends JpaRepository<IngredienteEntity, Long>{

}
