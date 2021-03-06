package com.webappsecurity.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webappsecurity.security.DTO.JwtDTO;
import com.webappsecurity.security.DTO.LoginUsuario;
import com.webappsecurity.security.entity.Usuario;
import com.webappsecurity.security.enums.RolNombre;
import com.webappsecurity.security.jwt.JwtProvider;
import com.webappsecurity.security.service.UsuarioService;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*",methods = {RequestMethod.POST})
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtProvider jwtProvider;
	@Autowired
	private UsuarioService usuarioService;
	@PostMapping("/login")
	public ResponseEntity<JwtDTO> responseEntity(@Valid @RequestBody LoginUsuario loginUsuario, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity("Datos incompletos",HttpStatus.BAD_REQUEST);
		}
		try {
				
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							loginUsuario.getNickname(),loginUsuario.getPassword())
					);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String token = jwtProvider.generateToken(authentication);
			UserDetails details = (UserDetails) authentication.getPrincipal();
			JwtDTO dto = new JwtDTO(token,details.getUsername(),details.getAuthorities());
			return new ResponseEntity(dto,HttpStatus.OK);
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			return new ResponseEntity("Usuario y/o contrase??a incorrectos",HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@Valid @RequestBody Usuario user){
		
		return ResponseEntity.ok(usuarioService.save(user, RolNombre.ROLE_CLIENT));
	}
	
}
