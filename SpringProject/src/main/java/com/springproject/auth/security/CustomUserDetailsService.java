package com.springproject.auth.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.springproject.auth.dao.UserDao;
import com.springproject.auth.dao.UserRolesDao;
import com.springproject.auth.entities.User;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRolesDao userRolesDao;
	
/*	@Autowired
    public CustomUserDetailsService(UserDao userDao,UserRolesDao userRolesDao) {
        this.userDao = userDao;
        this.userRolesDao=userRolesDao;
    }*/
	
        
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userDao.findByUsername(username);
		if(null == user){
			throw new UsernameNotFoundException("No user present with username: "+username);
		}else{
			List<String> userRoles=userRolesDao.findRoleByUsername(username);
			return new CustomUserDetails(user,userRoles);
		}
	}
		
}
