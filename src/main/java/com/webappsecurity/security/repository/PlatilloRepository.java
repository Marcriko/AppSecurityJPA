package com.webappsecurity.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webappsecurity.security.entity.PlatilloEntity;



@Repository
public interface PlatilloRepository extends JpaRepository<PlatilloEntity, Long>{

}
