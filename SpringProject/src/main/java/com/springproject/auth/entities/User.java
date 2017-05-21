package com.springproject.auth.entities;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name="USER_ID")
    private Long userId;

	@Column(name = "USERNAME")
    private String username;   

	@Column(name = "PASSWORD")
    private String password;   

	@Column(name = "UNIQUE_USER_ID")
    private String uniqueUserId;
	
	@Column(name = "PROVISION_CODE")
    private String provisionCode;
    
	@Column(name="DEVICE_ID")
    private Long deviceId;
	
	@Column(name = "DEVICE_FINGERPRINT")
    private String deviceFingerprint;	
	
	public User(){
		
	}
	
	public User(User user) {
	        this.userId = user.userId;
	        this.username = user.username;
	        this.deviceId = user.deviceId;       
	        this.password = user.password;
	        this.uniqueUserId = user.uniqueUserId;
	        this.provisionCode = user.provisionCode;
	}
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUniqueUserId() {
		return uniqueUserId;
	}

	public void setUniqueUserId(String uniqueUserId) {
		this.uniqueUserId = uniqueUserId;
	}

	public String getProvisionCode() {
		return provisionCode;
	}

	public void setProvisionCode(String provisionCode) {
		this.provisionCode = provisionCode;
	}


	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceFingerprint() {
		return deviceFingerprint;
	}

	public void setDeviceFingerprint(String deviceFingerprint) {
		this.deviceFingerprint = deviceFingerprint;
	}
	
}