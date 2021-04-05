package com.webappsecurity.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webappsecurity.security.entity.PromocionEntity;
import com.webappsecurity.security.repository.PromocionRepository;


@Service
@Transactional
public class PromocionService {
	@Autowired
	private PromocionRepository  promocionRepository;
	
	public List<PromocionEntity> promocionEntities() {
		return promocionRepository.findAll();
	}
	
	public boolean save (PromocionEntity promocionEntity) {
		return promocionRepository.existsById((long) promocionRepository.save(promocionEntity).getIdPromocion());
	}
	public boolean delete(long id) {
		promocionRepository.deleteById(id);
		return !promocionRepository.existsById(id);
	}
}
