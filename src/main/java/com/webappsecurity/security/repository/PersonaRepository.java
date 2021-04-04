package com.webappsecurity.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webappsecurity.security.entity.PersonaEntity;



@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, String>{
}