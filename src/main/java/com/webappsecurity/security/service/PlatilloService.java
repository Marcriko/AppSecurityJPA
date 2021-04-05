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
		return platilloRepository.existsById((long) platilloRepository.save(platilloEntity).getIdPlatillo());
	}
	
	public boolean delete(long id) {
		platilloRepository.deleteById(id);
		return !platilloRepository.existsById(id);
	}
}
