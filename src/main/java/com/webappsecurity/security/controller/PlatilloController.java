package com.webappsecurity.security.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.webappsecurity.security.entity.PlatilloEntity;
import com.webappsecurity.security.service.PlatilloService;


@RestController
@RequestMapping("/resto")
//@PreAuthorize("hasAuthority('ROLE_USER')")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")
public class PlatilloController {

	@Autowired
	PlatilloService platilloService;
	
	@GetMapping("/platillo/findAll")
	public List<PlatilloEntity> findAll(){
		return platilloService.platilloEntities();
	}
	
	
	@GetMapping("/platillo/findByName/{param}")
	public List<PlatilloEntity> findByName(@PathVariable String param){
		return platilloService.getLikeEntities(param);
	}
	
	
	@GetMapping("/platillo/findOne/{id}")
	public PlatilloEntity findOne(@PathVariable("id") int id) {
		return platilloService.getPlatilloEntity(id);
	}
	
	@Value("${file.upload-dir}")
	 String DIRECTORY;
	@PostMapping("/platillo/uploadImage")
	public String uploadImage(@RequestParam("file") MultipartFile file) {
		try {
			//System.out.println(platilloEntity.toString());
			String uuid = UUID.randomUUID().toString();
			File myFile = new File(DIRECTORY+uuid+file.getOriginalFilename());
			myFile.createNewFile();
			String path = myFile.getAbsolutePath();
			System.out.println(path);
			FileOutputStream fos = new FileOutputStream(myFile);
			fos.write(file.getBytes());
			fos.close();
			return path.replace('\\','_');
			
		} catch (IOException e) {
			System.out.println("Exception at course create: "+e.getStackTrace());
		}
		return "";
	}
	
	@DeleteMapping("/platillo/delete/{id}")
	public boolean delete(@PathVariable("id") int id) {
		
		return platilloService.delete(id);
	}
	@PostMapping("/platillo/save")

	public boolean save(@RequestBody PlatilloEntity platillo)  {
		platillo.setImagen(platillo.getImagen().replace('_','\\'));
		return platilloService.save(platillo);
	}
}
