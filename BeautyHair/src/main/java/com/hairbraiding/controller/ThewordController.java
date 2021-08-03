package com.hairbraiding.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hairbraiding.model.Theword;
import com.hairbraiding.service.ThewordService;


@RestController
@RequestMapping("/thewords")
public class ThewordController {

	
	@Autowired
	private ThewordService thewordservice;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/listword", produces = "application/json")
	public List<Theword> getAllWord () {

		List<Theword> allProf = null;
		
		allProf = thewordservice.loadAllPassword();
		
		return allProf;

	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/addpassword", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addEmployee(@RequestBody Theword theword) {

		Integer idpassword = thewordservice.loadAllPassword().size() + 1;

		theword.setIdpassword(idpassword);
		thewordservice.addTheword(theword);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(theword.getIdpassword())
				.toUri();

		return ResponseEntity.created(location).build();

	}
}
