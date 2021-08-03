package com.hairbraiding.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hairbraiding.model.Profil;

@Repository
public interface ProfilDao extends CrudRepository<Profil, Integer> {

	@Transactional
	@Modifying
	@Query("update Profil set titleprofil = :aTitleprofil where idprofil = :aIdprofil")
	public boolean UpdateProfil(Integer aIdprofil, String aTitleprofil);
	
	
	@Query("from Profil where idprofil = :aIdprofil")
	public Profil getAProfilById(Integer aIdprofil);
}

