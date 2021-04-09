package com.webappsecurity.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webappsecurity.security.entity.PersonaEntity;
import com.webappsecurity.security.repository.PersonaRepository;


@Service
@Transactional
public class PersonaService {
	@Autowired
	private PersonaRepository personaRepository;
	
	public List<PersonaEntity> personaEntities() {
		return personaRepository.findAll();
	}
	public boolean save(PersonaEntity personaEntity) {
		return personaRepository.existsById((int) personaRepository.save(personaEntity).getIdPersona());
	}
	public boolean delete(int id) {
		personaRepository.deleteById(id);
		return !personaRepository.existsById(id);
	}
	public PersonaEntity getPersonaEntity(int id) {
		return personaRepository.findById(id);
	}
	
}
