package com.hairbraiding.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;

import com.hairbraiding.model.Profil;
import com.hairbraiding.service.ProfilService;

@RestController
@RequestMapping("/profils")
public class ProfilController {

	@Autowired
	private ProfilService profilService;
	
	//*******************RESTFULL API *** OK ****************
	@GetMapping(path = "/allprofils", produces = "application/json")
	public List<Profil> getProfil (

	) {

		List<Profil> allProf = null;
		
		allProf = profilService.loadAllProfil();
		
		return allProf;

	}
	//**********************************
	
	//***********************************************
	@PostMapping(path = "/addprofil", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addEmployee(

		@RequestBody Profil theprofil) {

		Integer idprof = profilService.loadAllProfil().size() + 1;
		System.out.println(idprof);

		theprofil.setIdprofil(idprof);
		profilService.AddProfil(theprofil);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(theprofil.getIdprofil())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	//***********************************************
	
	
	//Update 
	
	@PostMapping("/updateprofil/{idprofil}")
	public boolean updateProfil(@PathVariable("idprofil") Integer theIdProfil, @RequestParam("aTitleprofil") String theNewTitleProfil) {
		
		Profil existingProfil = profilService.loadAProfilById(theIdProfil);
		
		
		if(existingProfil != null)
		{
			Profil toModifProfil = new Profil(theNewTitleProfil);
			toModifProfil.setIdprofil(existingProfil.getIdprofil());
			
			if (profilService.UpdateProfil(toModifProfil)) {
				return true;
			}
			return false;
		}
		
		return false;
	}
	
	
	/*
	//Get list of all profil
	@RequestMapping("/listallprofil") 
	public ModelAndView listAllProfil()
	{
		  List<Profil> allProfil = profilService.loadAllProfil(); 
		  
		  return new ModelAndView("/profillist", "Profil", allProfil); 
	}
	
	
	@GetMapping("/listallprofil")
	public List<Profil> AllProfile(
	
		@RequestHeader(name="X-COM-PERSIT", required = true) String headerPersist,
		@RequestHeader(name="X-COM-LOCATION", defaultValue = "ASIA") String headerLocation
	)
	{
		
		List<Profil> allProf = null;
		
		allProf = profilService.loadAllProfil();
		
		return allProf;
	}
	
	*/
	
	
	
	//Get a profil from it Id
	@GetMapping("/getprofilbyid/{idprofil}")
	@ResponseBody
	public Profil getProfilById(@PathVariable("idprofil") Integer theIdProfil)
	{
		boolean isfound = false;
		Profil aProfil = null;
		
		aProfil = profilService.loadAProfilById(theIdProfil);
		
		if(aProfil!= null)
		{
			return aProfil;
		}
		
		return null;
	}
	
	
	@DeleteMapping("/deleteprofil/{idprofil}")
	public boolean deleteProfil(@PathVariable("idUser") Integer theIdProfil) {
		

		if (profilService.deleteProfil(theIdProfil)) {
			return true;
		}
		
		return false;
	}

}
