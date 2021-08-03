package com.hairbraiding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hairbraiding.dao.BraiderDao;
import com.hairbraiding.model.Braider;

@Service
public class BraiderService {
	
	@Autowired
	private BraiderDao braiderDao;
	
	
	public boolean addBraider(Braider braider)
	{
		boolean isadd = false;
		
		if(braiderDao.save(braider) != null)
			isadd = true;
		
		return isadd;
	}

	
	public List<Braider> loadAllBraider()
	{
		List<Braider> listbraiders = null;
		
		listbraiders = (List<Braider>)braiderDao.findAll();
		
		return listbraiders;
	}
}
