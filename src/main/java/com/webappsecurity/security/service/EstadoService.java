package com.webappsecurity.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webappsecurity.security.entity.EstadoEntity;
import com.webappsecurity.security.repository.EstadoRepository;


@Service
@Transactional
public class EstadoService {
	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<EstadoEntity> estadoEntities(){
		return estadoRepository.findAll();
	}
	
	public boolean saveEstado(EstadoEntity entity) {
		return estadoRepository.existsById((long) estadoRepository.save(entity).getIdEstado());
	}
	
	public boolean deleteEstado(long id) {
		estadoRepository.deleteById(id);
		return !estadoRepository.existsById(id);
	}
}
