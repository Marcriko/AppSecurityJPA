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

import com.webappsecurity.security.entity.CuponEntity;
import com.webappsecurity.security.exception.ResourceNotFoundException;
import com.webappsecurity.security.service.CuponService;
import com.webappsecurity.security.service.PlatilloService;


@RestController
@RequestMapping("/resto")
//@PreAuthorize("hasAuthority('ROLE_USER')")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")
public class CuponController {
	
	@Autowired
	private CuponService cuponService;
	@Autowired
	private PlatilloService platilloService;
	
	@GetMapping("/cupon/findAll")
	public List<CuponEntity> findAll(){
		return cuponService.getCuponEntities();
	}
	
	@GetMapping("/cupon/findOne/{id}")
	public CuponEntity findOne(@PathVariable("id") int id) {
		return cuponService.getCuponEntity(id);
	}
	@GetMapping("/cupon/findByCode/{code}")
	public CuponEntity findByCodigo(@PathVariable("code") String id) {
		return cuponService.getByCodigo(id).orElseThrow(()-> new ResourceNotFoundException("Cupón no encontrado"));
	}
	@PostMapping("/cupon/save")
	public boolean save(@Valid @RequestBody CuponEntity cupon) {
		return cuponService.save(cupon);
	}
	
	@DeleteMapping("/cupon/delete/{id}")
	public boolean delete(@PathVariable("id") int id) {
		return cuponService.delete(id);
	}
}
