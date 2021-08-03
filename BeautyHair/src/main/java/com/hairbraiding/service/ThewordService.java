package com.hairbraiding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hairbraiding.dao.ThewordDao;
import com.hairbraiding.model.Theword;

@Service
public class ThewordService {

	@Autowired
	private ThewordDao thewordDao;
	
	
	public boolean addTheword(Theword theword)
	{
		boolean itadded = false;
		
		if(thewordDao.save(theword) != null)
		{
			itadded = true;
		}
		
		return itadded;
	}
	
	
	public List<Theword> loadAllPassword()
	{
		List<Theword> allPassword = null;
		
		allPassword = (List<Theword>)thewordDao.findAll();
		
		return allPassword;
	}
	

}
