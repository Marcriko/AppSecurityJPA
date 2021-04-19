package com.webappsecurity.security.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webappsecurity.security.entity.IngredienteEntity;
import com.webappsecurity.security.entity.PlatilloEntity;
import com.webappsecurity.security.repository.IngredienteRepository;
import com.webappsecurity.security.repository.PlatilloRepository;


@Service
 @Transactional
public class PlatilloService {
	@Autowired
	private PlatilloRepository platilloRepository;
	@Autowired
	private IngredienteRepository ingredienteRepository;
	public List<PlatilloEntity> platilloEntities() {
		return platilloRepository.findAll();
	}
	
	public boolean save(PlatilloEntity platilloEntity) throws IOException {
		System.out.println("prubea " + platilloEntity.getImagen());
		byte [] baits = Base64.getDecoder().decode(platilloEntity.getImagen());
		
		File saveFile = new File("C:/Users/marco/uploads"+File.separator);
		File scanFile = new File(saveFile.getAbsoluteFile()+File.separator+"Scanfile.png");
		BufferedOutputStream bStream = new BufferedOutputStream(new FileOutputStream(scanFile));
		bStream.write(baits);
		bStream.close();
		
		//platilloEntity.getImagen()
		List<IngredienteEntity> ingredientes = new ArrayList<IngredienteEntity>();
		for (IngredienteEntity ingredienteEntity : platilloEntity.getIngredientes()) {
			System.out.println(ingredienteEntity.toString());
			ingredientes.add(ingredienteRepository.findByNombre(ingredienteEntity.getNombre()));
		}
		platilloEntity.setIngredientes(ingredientes);
		
		return platilloRepository.existsById((int) platilloRepository.save(platilloEntity).getIdPlatillo());
	}
	
	public boolean delete(int id) {
		platilloRepository.deleteById(id);
		return !platilloRepository.existsById(id);
	}

	public PlatilloEntity getPlatilloEntity(int id) {
		return platilloRepository.findByIdPlatillo(id);
	}
	
	public List<PlatilloEntity> getLikeEntities(String comparando) {
		return platilloRepository.findByNombreContains(comparando);
	}
}
