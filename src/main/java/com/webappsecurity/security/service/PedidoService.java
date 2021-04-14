package com.webappsecurity.security.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webappsecurity.security.entity.DetallePedido;
import com.webappsecurity.security.entity.IngredienteEntity;
import com.webappsecurity.security.entity.PedidoEntity;
import com.webappsecurity.security.entity.Usuario;
import com.webappsecurity.security.repository.DetallePedidoRepository;
import com.webappsecurity.security.repository.PedidoRepository;
import com.webappsecurity.security.repository.UsuarioRepository;


@Service
@Transactional
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private DetallePedidoRepository detallePedidoRepository;
	
	
	public List<PedidoEntity> pedidoEntities() {
		return pedidoRepository.findAll();
	}
	
	public boolean save(PedidoEntity pedidoEntity) {
		
		List<DetallePedido> detallePedidos= new ArrayList<DetallePedido>();
		for (DetallePedido detallePedido : pedidoEntity.getDetalle()) {
			System.out.println(detallePedido.toString());
			detallePedidos.add(detallePedidoRepository.save(detallePedido)); 
		}
		pedidoEntity.setDetalle(detallePedidos);
		
		
		return pedidoRepository.existsById((int) pedidoRepository.save(pedidoEntity).getIdPedido());
	}
	
	public boolean delete(int id) {
		pedidoRepository.deleteById(id);
		return !pedidoRepository.existsById(id);
	}

	public PedidoEntity getPedidoEntity(int id) {
		return pedidoRepository.findByIdPedido(id);
	}
	public List<PedidoEntity> getPedidosByCliente(String username) {
		Usuario user = usuarioRepository.findByNickname(username);
		return pedidoRepository.findByCliente(user);
		
	}
}
