package com.springproject.auth.messages.reply;

import com.springproject.auth.messages.reply.AbstractReply.StatusCode;

public abstract class AuthenticationReplyFactory {
	
	
	public static FindDeviceReply createFindDeviceReply(String message) {

		FindDeviceReply reply = new FindDeviceReply();

		reply.setDeviceFound(true);
		reply.setResponse(message);
		reply.setStatusCode(StatusCode.OK);

		return reply;

	}
	
	public static FindDeviceReply createFindDeviceReply(String message, String provisionCode) {

		FindDeviceReply reply = new FindDeviceReply();

		reply.setDeviceFound(false);
		reply.setResponse(message);
		reply.setProvisionCode(provisionCode);
		reply.setStatusCode(StatusCode.OK);

		return reply;

	}

	public static RegisterReply createRegisterReply(String message) {

		RegisterReply reply = new RegisterReply();

		reply.setRegisetrSuccess(false);
		reply.setErrorMessage(message);
		reply.setStatusCode(StatusCode.OK);

		return reply;

	}

	public static RegisterReply createRegisterReply(String message, String uniqueUserId) {

		RegisterReply reply = new RegisterReply();

		reply.setRegisetrSuccess(true);
		reply.setResponse(message);
		reply.setUniqueClientId(uniqueUserId);
		reply.setStatusCode(StatusCode.OK);

		return reply;

	}

}
