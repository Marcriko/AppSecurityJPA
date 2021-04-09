package com.webappsecurity.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webappsecurity.security.entity.PromocionEntity;



@Repository
public interface PromocionRepository extends JpaRepository<PromocionEntity, Integer>{
	PromocionEntity findById(int id);
}
