package com.webappsecurity.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
import com.webappsecurity.security.entity.CuponEntity;
import com.webappsecurity.security.entity.DetallePedido;
import com.webappsecurity.security.entity.IngredienteEntity;
=======
>>>>>>> parent of 0f711a2 (imagen)
import com.webappsecurity.security.entity.PedidoEntity;
import com.webappsecurity.security.entity.PlatilloEntity;
import com.webappsecurity.security.entity.Usuario;
<<<<<<< HEAD
import com.webappsecurity.security.repository.CuponRepository;
import com.webappsecurity.security.repository.DetallePedidoRepository;
=======
>>>>>>> parent of 0f711a2 (imagen)
import com.webappsecurity.security.repository.PedidoRepository;
import com.webappsecurity.security.repository.PlatilloRepository;
import com.webappsecurity.security.repository.UsuarioRepository;


@Service
@Transactional
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
<<<<<<< HEAD
	@Autowired
	private DetallePedidoRepository detallePedidoRepository;
	@Autowired
	private PlatilloRepository platilloRepository;
	@Autowired
	private CuponRepository cuponRepository;
=======
	
>>>>>>> parent of 0f711a2 (imagen)
	public List<PedidoEntity> pedidoEntities() {
		return pedidoRepository.findAll();
	}
	
	public boolean save(PedidoEntity pedidoEntity) {
<<<<<<< HEAD
		pedidoEntity.setCliente(usuarioRepository.findByNickname(pedidoEntity.getCliente().getNickname()));
		List<DetallePedido> detallePedidos= new ArrayList<DetallePedido>();
		for (DetallePedido detallePedido : pedidoEntity.getDetalle()) {
			System.out.println(detallePedido.toString());
			detallePedido.setPlatillo(platilloRepository.findByNombre(detallePedido.getPlatillo().getNombre()));
			detallePedidos.add(detallePedidoRepository.save(detallePedido)); 
		}
		Optional<CuponEntity> cuponEntity = cuponRepository.findByCodigo(pedidoEntity.getCupon().getCodigo());
		cuponEntity.get().setLimiteUsos(cuponEntity.get().getLimiteUsos()-1);
		pedidoEntity.setCupon(cuponRepository.save(cuponEntity.get()));
		
		pedidoEntity.setDetalle(detallePedidos);
		
		
=======
>>>>>>> parent of 0f711a2 (imagen)
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
