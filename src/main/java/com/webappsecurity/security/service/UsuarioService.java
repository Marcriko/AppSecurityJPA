package com.webappsecurity.security.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.webappsecurity.security.entity.Rol;
import com.webappsecurity.security.entity.Usuario;
import com.webappsecurity.security.enums.RolNombre;
import com.webappsecurity.security.repository.RolRepository;
import com.webappsecurity.security.repository.UsuarioRepository;



@Service
@Transactional
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	RolRepository rolRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	public Usuario getByNickname(String nickname) {
		return usuarioRepository.findByNickname(nickname);
	}

	public boolean existsByNickname(String nickname) {
		return usuarioRepository.existsByNickname(nickname);
	}

	public boolean existsByEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}

	public boolean save(Usuario usuario, RolNombre autoridad) {
		Usuario us = usuarioRepository.findByNickname(usuario.getNickname());
		if (us == null) {
			System.out.println(usuario);
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

			Rol rol = rolRepository.findByRolNombre(autoridad);
			List<Rol> roles = new ArrayList();
			roles.add(rol);
			usuario.setRoles(roles);
			return usuarioRepository.existsById(usuarioRepository.save(usuario).getIdUsuario());

		}
		return false;
	}
}
