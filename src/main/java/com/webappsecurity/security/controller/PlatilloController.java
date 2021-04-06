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

import com.webappsecurity.security.entity.PlatilloEntity;
import com.webappsecurity.security.service.PlatilloService;

@RestController
@RequestMapping("/resto")
//@PreAuthorize("hasAuthority('ROLE_USER')")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")
public class PlatilloController {

	@Autowired
	PlatilloService platilloService;
	
	@GetMapping("/platillo/findAll")
	public List<PlatilloEntity> findAll(){
		return platilloService.platilloEntities();
	}
	
	@GetMapping("/platillo/findOne/{id}")
	public PlatilloEntity findOne(@PathVariable Long id) {
		return platilloService.getPlatilloEntity(id);
	}
	
	@PostMapping("/platillo/save")
	public boolean save(@RequestBody PlatilloEntity platillo) {
		return platilloService.save(platillo);
	}
	
	@DeleteMapping("/platillo/delete/{id}")
	public boolean delete(@PathVariable Long id) {
		return platilloService.delete(id);
	}
	
}
