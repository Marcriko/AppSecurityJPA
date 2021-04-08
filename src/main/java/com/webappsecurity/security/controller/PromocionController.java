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

import com.webappsecurity.security.entity.PromocionEntity;
import com.webappsecurity.security.service.PromocionService;


@RestController
@RequestMapping("/resto")
//@PreAuthorize("hasAuthority('ROLE_USER')")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")
public class PromocionController {
	
	@Autowired
	PromocionService promocionService;
	
	@GetMapping("/promocion/findAll")
	public List<PromocionEntity> findAll(){
		return promocionService.promocionEntities();
	}
	
	@GetMapping("/promocion/findOne/{id}")
	public PromocionEntity findOne(@PathVariable int id) {
		return promocionService.findOne(id);
	}
	
	@PostMapping("/promocion/save")
	public boolean save(@RequestBody PromocionEntity promocion) {
		return promocionService.save(promocion);
	}
	
	@DeleteMapping("/promocion/delete/{id}")
	public boolean delete(@PathVariable int id) {
		return promocionService.delete(id);
	}

}
