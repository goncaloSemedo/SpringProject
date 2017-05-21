package com.springproject.auth.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springproject.auth.entities.UserRole;

@Repository
public interface UserRolesDao extends CrudRepository<UserRole, Long> {
	
	@Query("select a.role from UserRole a, User b where b.username=?1 and a.userId=b.userId")
    public List<String> findRoleByUsername(String username);
	
}