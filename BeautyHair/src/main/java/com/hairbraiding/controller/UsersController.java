package com.hairbraiding.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hairbraiding.model.Users;
import com.hairbraiding.service.UsersService;

//@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/users")

public class UsersController {
	
	@Autowired
	private UsersService userService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/allusers", produces = "application/json")
	public List<Users> getAllUsers () 
	{

		List<Users> allUsers = null;
		
		allUsers = userService.loadAllUsers();
		
		return allUsers;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/latestuser", produces = "application/json")
	public Users getLatestAddedUser () 
	{

		Users aUser = null;
		
		aUser = userService.loadTheLatestAddedUser();
		
		return aUser;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/oneuser/{iduser}", produces = "application/json")
	public Optional<Users> getOneUsers (@PathVariable("iduser") Integer theidUser) 
	{

		Optional<Users> aUsers = null;
		
		aUsers = userService.loadAUserById(theidUser);
		
		return aUsers;

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/oneuserbyusername/{username}")
	public Users getOneUsers (@PathVariable("username") String theUsername)
	{

		Users aUsers = null;
		
		aUsers = userService.loadAUserByUsername(theUsername);
		
		return aUsers;

	}
	

	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/adduser", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addUsers(@RequestBody Users theUser) {

		Integer idUser = userService.loadAllUsers().size() + 1;

		theUser.setIduser(idUser);
		userService.addUsers(theUser);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(theUser.getIduser())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	
}
