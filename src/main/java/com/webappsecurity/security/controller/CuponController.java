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

import com.webappsecurity.security.entity.CuponEntity;
import com.webappsecurity.security.service.CuponService;


@RestController
@RequestMapping("/resto")
//@PreAuthorize("hasAuthority('ROLE_USER')")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")
public class CuponController {
	
	@Autowired
	CuponService cuponService;
	
	@GetMapping("/findAll")
	public List<CuponEntity> findAll(){
		return cuponService.getCuponEntities();
	}
	
	@GetMapping("/findOne/{id}")
	public CuponEntity findOne(@PathVariable Long id) {
		return cuponService.getCuponEntity(id);
	}
	
	@PostMapping("/save")
	public boolean save(@RequestBody CuponEntity cupon) {
		return cuponService.save(cupon);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable Long id) {
		return cuponService.delete(id);
	}
}
