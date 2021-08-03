package com.hairbraiding.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hairbraiding.model.Users;

@Repository
public interface UsersDao extends JpaRepository<Users, Integer> {
	
	/*
	@Transactional
	@Modifying
	@Query("UPDATE Users u set passWord =:aUsername where u.userName = :aPassword")
	int changePassword(String aUsername, String aPassword);
	*/
	
	@Query("from Users where userName=:aUsername")
	Users findByUsername(String aUsername);
	
	
	
	/*
	@Query(value = "select u.iduser, username, password from users u, theword w where u.iduser = w.iduser "
			+ "and username = :aUsername")
	String findUserPassword(@Param("username") String aUsername);
	*/
	
	
	/*
	@Query("select * from Users u where u.connectstate = :stateconnect")
	List<Users> findAllConnectedUsers(boolean stateconnect);
	*/
	

	
}
