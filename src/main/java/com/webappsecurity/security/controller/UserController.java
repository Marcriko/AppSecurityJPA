package com.webappsecurity.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.webappsecurity.security.entity.Usuario;
import com.webappsecurity.security.service.UsuarioService;

@RestController
@RequestMapping("/resto")
//@PreAuthorize("hasAuthority('ROLE_USER')")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")
public class UserController {
	@Autowired 
	private UsuarioService usuarioService;
	
	@GetMapping("/usuario/findByNickname/{nickname}")
	public Usuario findOne(@PathVariable String nickname) {
		return usuarioService.getByNickname(nickname);
	}
	
	@DeleteMapping("/usuario/findByNickname/{id}")
	public boolean deleteUser(@PathVariable int id) {
		return usuarioService.deleteUser(id);
	}

}
