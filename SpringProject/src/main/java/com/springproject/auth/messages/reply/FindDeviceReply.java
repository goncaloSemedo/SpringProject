package com.springproject.auth.messages.reply;


public class FindDeviceReply extends AbstractReply {
	
	private String provisionCode;
	private boolean deviceFound;

	public String getProvisionCode() {
		return provisionCode;
	}

	public void setProvisionCode(String provisionCode) {
		this.provisionCode = provisionCode;
	}

	public boolean isDeviceFound() {
		return deviceFound;
	}

	public void setDeviceFound(boolean deviceFound) {
		this.deviceFound = deviceFound;
	}
}
