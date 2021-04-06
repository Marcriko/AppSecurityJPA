package com.webappsecurity.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webappsecurity.security.entity.PersonaEntity;
import com.webappsecurity.security.service.PersonaService;


@RestController
@RequestMapping("/resto")
//@PreAuthorize("hasAuthority('ROLE_USER')")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")
public class PersonaController {
	
	@Autowired
	PersonaService personaService;
	
	@GetMapping("/persona/findOne")
	public PersonaEntity findOne(Long id) {
		return personaService.getPersonaEntity(id);
	}
	
	@PostMapping("/persona/save")
	public boolean save(@RequestBody PersonaEntity persona) {
		return personaService.save(persona);
	}

}
