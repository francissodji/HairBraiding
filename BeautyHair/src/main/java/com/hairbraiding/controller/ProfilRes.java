package com.hairbraiding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profil")
public class ProfilRes {

	@RequestMapping(value ="/addprofil",method = RequestMethod.GET)
	 
	public String login() {
		return "/profil/addprofil";
	}
	
	
	
}
