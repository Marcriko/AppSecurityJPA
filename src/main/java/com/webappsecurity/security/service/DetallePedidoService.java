package com.webappsecurity.security.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webappsecurity.security.repository.DetallePedidoRepository;

@Service
@Transactional
public class DetallePedidoService {
	
	@Autowired
	private DetallePedidoRepository ordenRepository;
	
	
	
}
