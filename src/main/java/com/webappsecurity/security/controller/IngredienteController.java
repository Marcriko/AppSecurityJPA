package com.webappsecurity.security.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.webappsecurity.security.entity.IngredienteEntity;
import com.webappsecurity.security.service.IngredienteService;


@RestController
@RequestMapping("/resto")
//@PreAuthorize("hasAuthority('ROLE_USER')")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")
public class IngredienteController {
	
	@Autowired
	IngredienteService ingredienteService;
	
	@GetMapping("/ingredientes/findAll")
	public List<IngredienteEntity> findAll(){
		return ingredienteService.ingredienteEntities();
	}
	
	@GetMapping("/ingredientes/findOne")
	public IngredienteEntity findOne(int id) {
		return ingredienteService.getIngredienteEntity(id);
	}
	
	@PostMapping("/ingredientes/save")
	public boolean save(@Valid @RequestBody IngredienteEntity ingrediente) {
		return ingredienteService.save(ingrediente);
	}
	
	@DeleteMapping("/ingredientes/delete/{id}")
	public boolean delete(@PathVariable int id) {
		return ingredienteService.deleteById(id);
	}
	
	

}
