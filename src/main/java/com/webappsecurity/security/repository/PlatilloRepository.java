package com.webappsecurity.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webappsecurity.security.entity.PlatilloEntity;



@Repository
public interface PlatilloRepository extends JpaRepository<PlatilloEntity, Integer>{
	PlatilloEntity findByIdPlatillo(int idPlatillo);
	PlatilloEntity findByNombre(String nombrePlatillo);
	List<PlatilloEntity> findByNombreContains(String parametro);
}
