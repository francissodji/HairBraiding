package com.hairbraiding.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hairbraiding.model.Braider;
import com.hairbraiding.service.BraiderService;

@RestController
@RequestMapping("/braiders")
public class BraiderController {
	
	@Autowired
	private BraiderService braiderService;

	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/addbraider", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addEmployee(@RequestBody Braider braider) {

		Integer idBraider = braiderService.loadAllBraider().size() + 1;

		braider.setIdbraider(idBraider);
		braiderService.addBraider(braider);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(braider.getIdbraider())
				.toUri();

		return ResponseEntity.created(location).build();

	}
}
