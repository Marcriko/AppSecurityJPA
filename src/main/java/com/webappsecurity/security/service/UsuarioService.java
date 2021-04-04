package com.webappsecurity.security.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webappsecurity.security.entity.Usuario;
import com.webappsecurity.security.repository.UsuarioRepository;


@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario getByNickname(String nickname) {
		return usuarioRepository.findByNickname(nickname);
	}
	
	public boolean existsByNickname(String nickname) {
		return usuarioRepository.existsByNickname(nickname);
	}
	
	public boolean existsByEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}
	
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
}
