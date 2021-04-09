package com.webappsecurity.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webappsecurity.security.entity.PlatilloEntity;
import com.webappsecurity.security.repository.PlatilloRepository;


@Service
 @Transactional
public class PlatilloService {
	@Autowired
	private PlatilloRepository platilloRepository;
	
	public List<PlatilloEntity> platilloEntities() {
		return platilloRepository.findAll();
	}
	
	public boolean save(PlatilloEntity platilloEntity) {
		return platilloRepository.existsById((int) platilloRepository.save(platilloEntity).getIdPlatillo());
	}
	
	public boolean delete(int id) {
		platilloRepository.deleteById(id);
		return !platilloRepository.existsById(id);
	}

	public PlatilloEntity getPlatilloEntity(int id) {
		return platilloRepository.findById(id);
	}
}
