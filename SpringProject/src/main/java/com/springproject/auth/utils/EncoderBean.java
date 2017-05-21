package com.springproject.auth.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncoderBean {
	
	private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	private EncoderBean(){};
	
	public static BCryptPasswordEncoder getInstance(){
		return encoder;
	}

}
