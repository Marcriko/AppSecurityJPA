package com.webappsecurity.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webappsecurity.security.entity.CategoriaEntity;
import com.webappsecurity.security.service.CategoriaService;

@RestController
@RequestMapping("/resto")
//@PreAuthorize("hasAuthority('ROLE_USER')")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/categoria/findById/{id}")
	public CategoriaEntity findById(@PathVariable int id){
		return categoriaService.getCategoriaEntity(id);
	}
	@GetMapping("/categoria/findAll")
	public List<CategoriaEntity> findAll(){
		return categoriaService.getCategoriaEntities();
	}
	@PostMapping("/categoria/save")
	public boolean save(@RequestBody CategoriaEntity categoriaEntity) {
		return categoriaService.save(categoriaEntity);
	}
}
