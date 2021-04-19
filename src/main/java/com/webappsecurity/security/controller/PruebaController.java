package com.webappsecurity.security.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.webappsecurity.security.entity.PlatilloEntity;

@RestController

public class PruebaController {
	//@PreAuthorize("hasRole('USER')")
	@PostMapping("/prueba")
	public ResponseEntity<?> responseEntity(@RequestParam("file") MultipartFile file, WebRequest request) throws IOException {
		//System.out.println(platilloEntity.toString());
		System.out.println(file.getOriginalFilename());
		byte [] bytes = file.getBytes();
		String path = "C:/Users/marco/uploads";
		Path pathUpload = Paths.get(path+file.getOriginalFilename());
		Files.write(pathUpload,bytes);
		//getLastInsertedPlatillo OBJETO
		
		return new ResponseEntity<>("Hola Service user", HttpStatus.OK);
	}
}
