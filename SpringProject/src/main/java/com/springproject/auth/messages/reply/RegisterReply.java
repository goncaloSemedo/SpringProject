package com.springproject.auth.messages.reply;

public class RegisterReply extends AbstractReply {

	
	private boolean regisetrSuccess;
	private String uniqueClientId;

	public boolean isRegisetrSuccess() {
		return regisetrSuccess;
	}

	public void setRegisetrSuccess(boolean regisetrSuccess) {
		this.regisetrSuccess = regisetrSuccess;
	}

	public String getUniqueClientId() {
		return uniqueClientId;
	}

	public void setUniqueClientId(String uniqueClientId) {
		this.uniqueClientId = uniqueClientId;
	}
		
}
