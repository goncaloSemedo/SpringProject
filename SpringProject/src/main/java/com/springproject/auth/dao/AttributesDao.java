package com.springproject.auth.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springproject.auth.entities.Attribute;

@Repository
public interface AttributesDao  extends CrudRepository<Attribute, Long>{
	
	
	public Attribute findByAtributeName(String atributeName);

}