package com.webappsecurity.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webappsecurity.security.entity.CuponEntity;
import com.webappsecurity.security.repository.CuponRepository;

@Service
@Transactional
public class CuponService {

	@Autowired
	private CuponRepository cuponRepository;
	
	public List<CuponEntity> getCuponEntities(){
		return cuponRepository.findAll();
	}
	
	public boolean save(CuponEntity cuponEntity) {
		return cuponRepository.existsById((long) cuponRepository.save(cuponEntity).getIdCupon());
	}
	
	public boolean delete(long id) {
		cuponRepository.deleteById(id);
		return !cuponRepository.existsById(id);
	}
	
}