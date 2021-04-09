package com.webappsecurity.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webappsecurity.security.entity.EstadoEntity;



@Repository
public interface EstadoRepository extends JpaRepository<EstadoEntity, Integer>{
	EstadoEntity findById(int id);

}
