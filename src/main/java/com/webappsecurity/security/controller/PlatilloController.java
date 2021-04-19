package com.webappsecurity.security.controller;

<<<<<<< HEAD
import java.io.IOException;
=======
>>>>>>> parent of 0f711a2 (imagen)
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
<<<<<<< HEAD
import org.springframework.web.multipart.MultipartFile;
=======
>>>>>>> parent of 0f711a2 (imagen)

import com.webappsecurity.security.entity.PlatilloEntity;
import com.webappsecurity.security.jwt.JwtProvider;
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
	public List<PlatilloEntity> findByName(@PathVariable("param") String param){
		return platilloService.getLikeEntities(param);
	}
	
	
	@GetMapping("/platillo/findOne/{id}")
	public PlatilloEntity findOne(@PathVariable("id") int id) {
		return platilloService.getPlatilloEntity(id);
	}
	
	@PostMapping("/platillo/save")
<<<<<<< HEAD
	public boolean save(@RequestBody PlatilloEntity platillo, @RequestParam("file") MultipartFile file) throws IOException {
		System.out.println(file.getOriginalFilename());
=======
	public boolean save(@RequestBody PlatilloEntity platillo) {
		
>>>>>>> parent of 0f711a2 (imagen)
		return platilloService.save(platillo);
	}
	
	@DeleteMapping("/platillo/delete/{id}")
	public boolean delete(@PathVariable("id") int id) {
		
		return platilloService.delete(id);
	}
	
	
}
