package com.webappsecurity.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PruebaController {
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/prueba")
	public ResponseEntity<?> responseEntity() {
		return new ResponseEntity<>("Hola Service user", HttpStatus.OK);
	}
}
