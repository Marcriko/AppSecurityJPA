package com.webappsecurity.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webappsecurity.security.entity.EstadoEntity;
import com.webappsecurity.security.service.EstadoService;


@RestController
@RequestMapping("/resto")
//@PreAuthorize("hasAuthority('ROLE_USER')")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")
public class EstadoController {
	
	@Autowired
	EstadoService estadoService;
	
	@GetMapping("/findAll")
	public List<EstadoEntity> findAll(){
		return estadoService.estadoEntities();
	}
	
	@GetMapping("/findOne/{id}")
	public EstadoEntity findOne(@PathVariable Long id) {
		return estadoService.getEstadoEntity(id);
	}
	
	@PostMapping("/save")
	public boolean save(@RequestBody EstadoEntity estado) {
		return estadoService.saveEstado(estado);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable Long id) {
		return estadoService.deleteEstado(id);
	}

}
