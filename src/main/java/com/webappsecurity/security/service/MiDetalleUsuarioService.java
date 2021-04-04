package com.webappsecurity.security.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webappsecurity.security.entity.MiDetalleUsuario;
import com.webappsecurity.security.entity.Usuario;

@Service
@Transactional
public class MiDetalleUsuarioService implements UserDetailsService {

	@Autowired
	UsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuarioX = usuarioService.getByNickname(username);
		if(usuarioX == null) {
			throw new UsernameNotFoundException("Usuario no Encontrado");
		}
		
		return MiDetalleUsuario.construir(usuarioX);
	}
	
}
