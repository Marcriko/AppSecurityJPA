package com.webappsecurity.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webappsecurity.security.entity.PedidoEntity;
import com.webappsecurity.security.entity.Usuario;



@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer>{
	PedidoEntity findByIdPedido(int idPedido);
	List<PedidoEntity> findByCliente(Usuario cliente);
}
