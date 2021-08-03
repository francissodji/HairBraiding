package com.hairbraiding.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hairbraiding.model.Braider;

@Repository
public interface BraiderDao extends CrudRepository<Braider, Integer> {
	
	
}
