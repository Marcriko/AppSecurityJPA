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

import com.webappsecurity.security.entity.PedidoEntity;
import com.webappsecurity.security.service.PedidoService;



@RestController
@RequestMapping("/resto")
//@PreAuthorize("hasAuthority('ROLE_USER')")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")
public class PedidoController {

	@Autowired
	PedidoService pedidoService;
	
	@GetMapping("/pedido/findAll")
	public List<PedidoEntity> findAll(){
		return pedidoService.pedidoEntities();
	}
	
	@GetMapping("/pedido/findOne/{id}")
	public PedidoEntity findOne(@PathVariable Long id) {
		return pedidoService.getPedidoEntity(id);
	}
	
	@PostMapping("/pedido/save")
	public boolean save(@RequestBody PedidoEntity pedido) {
		return pedidoService.save(pedido);
	}
	
	@DeleteMapping("/pedido/delete/{id}")
	public boolean delete(@PathVariable Long id) {
		return pedidoService.delete(id);
	}
	
}
