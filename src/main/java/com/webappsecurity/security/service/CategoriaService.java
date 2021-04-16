package com.webappsecurity.security.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webappsecurity.security.entity.CategoriaEntity;
import com.webappsecurity.security.repository.CategoriaRepository;

@Service
@Transactional
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<CategoriaEntity> getCategoriaEntities() {
		return categoriaRepository.findAll();
	}
	
	public Optional<CategoriaEntity> getCategoriaEntity(int id) {
		return categoriaRepository.findByIdCategoria(id);
	}
	
	public boolean save (CategoriaEntity categoriaEntity) {
		return categoriaRepository.existsById(categoriaRepository.save(categoriaEntity).getIdCategoria());
	}
	
}
