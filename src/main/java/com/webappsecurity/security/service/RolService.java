package com.webappsecurity.security.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webappsecurity.security.entity.Rol;
import com.webappsecurity.security.enums.RolNombre;
import com.webappsecurity.security.repository.RolRepository;


@Service
@Transactional
public class RolService {
	
	@Autowired
	RolRepository rolRepository;
	
	public Rol  getByRolNombre(RolNombre rolNombre) {
		return rolRepository.findByRolNombre(rolNombre);
	}
	
	public void save(Rol rol) {
		rolRepository.save(rol);
	}
	
	
	
}
