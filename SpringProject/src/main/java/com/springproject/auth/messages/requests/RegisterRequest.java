package com.springproject.auth.messages.requests;

public class RegisterRequest {
	
	private String username;
	private String password;
	private String provisionCode;
	private DeviceData deviceData;
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
	public String getProvisionCode() {
		return provisionCode;
	}
	public void setProvisionCode(String provisionCode) {
		this.provisionCode = provisionCode;
	}
	public DeviceData getDeviceData() {
		return deviceData;
	}
	public void setDeviceData(DeviceData deviceData) {
		this.deviceData = deviceData;
	}
	
	

}
