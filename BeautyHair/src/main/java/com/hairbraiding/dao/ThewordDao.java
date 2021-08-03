package com.hairbraiding.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hairbraiding.model.Theword;
import com.hairbraiding.model.Users;

@Repository
public interface ThewordDao extends CrudRepository<Theword, Integer>{

	@Query("from Theword where iduser=:iduser")
	Theword findPasswordByUserId(Integer iduser);
	
	
	/*
	@Modifying
	@Query("update Theword t set t.password = ?1 where u.iduser = ?2")
	boolean updatePassword(String newPassword, Integer userId);
	*/
	
}
