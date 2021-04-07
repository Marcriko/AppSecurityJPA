package com.webappsecurity.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webappsecurity.security.entity.CuponEntity;



@Repository
public interface CuponRepository extends JpaRepository<CuponEntity, Integer>{

}
