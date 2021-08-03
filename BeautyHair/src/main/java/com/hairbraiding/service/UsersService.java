package com.hairbraiding.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hairbraiding.dao.UsersDao;
import com.hairbraiding.model.Users;

@Service
public class UsersService {

	@Autowired
	private UsersDao usersDao;
	
	public boolean addUsers(Users users)
	{
		boolean isadd = false;
		
		if(usersDao.save(users) != null)
		{
			isadd = true;
		}
		return isadd;
	}
	
	public List<Users> loadAllUsers()
	{
		List<Users> allUsers = null;
		
		allUsers = (List<Users>)usersDao.findAll();
		
		return allUsers;
	}
	
	@SuppressWarnings("null")
	public Users loadTheLatestAddedUser()
	{
		List<Users> allUsers = null;
		List<Users> allUsersSorted = null;
		Users aUser = null;
		int theSize = 0;
		allUsers = (List<Users>)usersDao.findAll();
		
		if(allUsers.isEmpty() == false)
		{
			System.out.println("Not empty - Inside");
			theSize = allUsers.size();
			
			System.out.println("Size = "+theSize);
			
			for(int i = theSize; i > 0; i-- )
			{
				
				if(i == theSize)
				{
					aUser = allUsers.get(theSize-1);
					System.out.println(aUser);
				}
					
				else
					i = 0;
			}

		}
		
		return aUser;
	}
	
	
	public Optional<Users> loadAUserById(Integer theIdUser)
	{
		Optional<Users> aUser = null;
		
		aUser = usersDao.findById(theIdUser);
		
		return aUser;
	}
	
	
	
	public Users loadAUserByUsername(String theUsername)
	{
		Users aUser = null;
		
		aUser = usersDao.findByUsername(theUsername);
		
		return aUser;
	}
	
	
	/*
	//all connected users
	public List<Users> loadAllConnectedUsers(boolean stateConnect)
	{
		List<Users> allConnUser = null;
		
		allConnUser = usersDao.findAllConnectedUsers(stateConnect);
		
		return allConnUser;
	}
	*/
	
	public boolean isUserExist(Integer theIdUser)
	{
		boolean itexist = false;
		
		Optional<Users> aUser = null;
		
		aUser = usersDao.findById(theIdUser);
		
		if(aUser.isPresent())
		{
			itexist = true;
		}
			
		return itexist;
	}
	
	
	public boolean deleleUsers(Integer theIdUser)
	{
		boolean isDeleted = false;
		
		Optional<Users> aUser = null;
		
		aUser = usersDao.findById(theIdUser);
		
		if(aUser.isPresent())
		{
			usersDao.deleteById(theIdUser);
			isDeleted = true;
		}
		
		return isDeleted;
	}
	
	
	/*
	public boolean UpdateUser(Users aUser)
	{
		boolean isUpdated = false;
		
		Optional<Users> aUser = null;
		
		aUser = usersDao.findById(theIdUser);
		return isUpdated;
	}
	*/
}
