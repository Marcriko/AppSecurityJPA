package com.webappsecurity.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webappsecurity.security.entity.IngredienteEntity;
import com.webappsecurity.security.repository.IngredienteRepository;


@Service
@Transactional
public class IngredienteService {
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	public List<IngredienteEntity> ingredienteEntities() {
		return ingredienteRepository.findAll();
	}
	
	public boolean save(IngredienteEntity entity) {
		return ingredienteRepository.existsById((long) ingredienteRepository.save(entity).getIdIngrediente());
	}
	
	public boolean deleteById (long id) {
		ingredienteRepository.deleteById(id);
		return !ingredienteRepository.existsById(id);
	}
}
