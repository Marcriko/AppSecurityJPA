package com.webappsecurity.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webappsecurity.security.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Usuario findByNickname(String nickname);
	boolean existsByNickname(String nickname);
	boolean existsByEmail(String email);
}
