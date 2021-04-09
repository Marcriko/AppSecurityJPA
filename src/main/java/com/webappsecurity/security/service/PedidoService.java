package com.webappsecurity.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webappsecurity.security.entity.PedidoEntity;
import com.webappsecurity.security.repository.PedidoRepository;


@Service
@Transactional
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<PedidoEntity> pedidoEntities() {
		return pedidoRepository.findAll();
	}
	
	public boolean save(PedidoEntity pedidoEntity) {
		return pedidoRepository.existsById((int) pedidoRepository.save(pedidoEntity).getIdPedido());
	}
	
	public boolean delete(int id) {
		pedidoRepository.deleteById(id);
		return !pedidoRepository.existsById(id);
	}

	public PedidoEntity getPedidoEntity(int id) {
		return pedidoRepository.findById(id);
	}
}
