package com.springproject.auth.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springproject.auth.entities.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	
	
    public User findByUsername(String username);
    
    public User findByUniqueUserId(String uniqueUserId);
    
}