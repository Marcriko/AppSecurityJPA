package com.webappsecurity.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webappsecurity.security.entity.PedidoEntity;



@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long>{

}
