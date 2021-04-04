package com.webappsecurity.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webappsecurity.security.entity.Rol;
import com.webappsecurity.security.enums.RolNombre;
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
	
	Rol findByRolNombre(RolNombre rolNombre);
	
}
