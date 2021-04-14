package com.webappsecurity.security.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
	
	@GetMapping("/platillo/findOne/{id}")
	public PlatilloEntity findOne(@PathVariable("id") int id) {
		return platilloService.getPlatilloEntity(id);
	}
	@Value("${file.upload-dir}")
	 String DIRECTORY;
	@PostMapping("/platillo/save")
	public boolean save(@RequestBody PlatilloEntity platillo,@RequestParam("file") MultipartFile file) {
		try {
			File myFile = new File(DIRECTORY+file.getOriginalFilename());
			myFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(myFile);
			fos.write(file.getBytes());
			fos.close();
			
		} catch (IOException e) {
			System.out.println("Exception at course create: "+e.getStackTrace());
		}
		return platilloService.save(platillo);
	}
	
	@DeleteMapping("/platillo/delete/{id}")
	public boolean delete(@PathVariable("id") int id) {
		return platilloService.delete(id);
	}
	
}
