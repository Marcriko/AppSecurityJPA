package com.webappsecurity.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webappsecurity.security.entity.IngredienteEntity;
import com.webappsecurity.security.entity.PlatilloEntity;
import com.webappsecurity.security.repository.IngredienteRepository;
import com.webappsecurity.security.repository.PlatilloRepository;


@Service
 @Transactional
public class PlatilloService {
	@Autowired
	private PlatilloRepository platilloRepository;
	@Autowired
	private IngredienteRepository ingredienteRepository;
	public List<PlatilloEntity> platilloEntities() {
		return platilloRepository.findAll();
	}
	
	public boolean save(PlatilloEntity platilloEntity) {
		List<IngredienteEntity> ingredientes = new ArrayList<IngredienteEntity>();
		for (IngredienteEntity ingredienteEntity : platilloEntity.getIngredientes()) {
			System.out.println(ingredienteEntity.toString());
			ingredientes.add(ingredienteRepository.findByNombre(ingredienteEntity.getNombre()));
		}
		platilloEntity.setIngredientes(ingredientes);
		
		return platilloRepository.existsById((int) platilloRepository.save(platilloEntity).getIdPlatillo());
	}
	
	public boolean delete(int id) {
		platilloRepository.deleteById(id);
		return !platilloRepository.existsById(id);
	}

	public PlatilloEntity getPlatilloEntity(int id) {
		return platilloRepository.findByIdPlatillo(id);
	}
}
