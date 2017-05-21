package com.springproject.auth.entities;

import javax.persistence.*;

@Entity
@Table(name="user_roles")
public class UserRole {
	
	
	public static final  String ROLE_USER = "ROLE_USER";
	public static final  String ROLE_ADMIN = "ROLE_ADMIN";
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name="user_role_id")
	private Long userRoleId;
	
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="role")
	private String role;	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getUserid() {
		return userId;
	}

	public void setUserid(Long userid) {
		this.userId = userid;
	}

	public Long getUserroleid() {
		return userRoleId;
	}

	public void setUserroleid(Long userroleid) {
		this.userRoleId = userroleid;
	}	
	
}
