package com.hairbraiding.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hairbraiding.dao.ProfilDao;
import com.hairbraiding.model.Profil;

@Service
public class ProfilService {

	@Autowired
	private ProfilDao profilDao;
	
	

	public boolean AddProfil(Profil aProfil) {
		
		boolean isAdded = false;
		//statConn = false;
		if (profilDao.save(aProfil) != null)
		{
			isAdded = true;
		}
		
		return isAdded;
	}
	

	
	public List<Profil> loadAllProfil(){
		
		List<Profil> allProfil = null;
		allProfil = (List<Profil>) profilDao.findAll();
		
		return allProfil;
	}
	
	
	//load one profil by Id
	public Profil loadAProfilById(Integer idProfil){
		
		Profil aProfil = null;
		aProfil = profilDao.getAProfilById(idProfil);
		
		return aProfil;
	}
	
	//Is profil exist
	public boolean isProfilExist(Integer idProfil) {
		
		Optional<Profil> find = profilDao.findById(idProfil);
		
		if(find.isPresent()) {
			return true;
		}
		
		return false;
	}
	
	//delete profil
	public boolean deleteProfil(Integer idProfil) {
		
		Optional<Profil> find = profilDao.findById(idProfil);
		
		if(find.isPresent()) {
			profilDao.deleteById(idProfil);
			return true;
		}
		
		return false;
	}
	
	//Update profil
	public boolean UpdateProfil(Profil aProfil)
	{
		boolean isUpdate = false;
		
		if(profilDao.existsById(aProfil.getIdprofil()))
		{
			isUpdate = profilDao.UpdateProfil(aProfil.getIdprofil(), aProfil.getTitleprofil());
			return isUpdate;
			
		}
		
		return false;
	}

}
