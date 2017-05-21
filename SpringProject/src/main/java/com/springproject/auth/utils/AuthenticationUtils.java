package com.springproject.auth.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

import com.springproject.auth.entities.DeviceAttribute;
import com.springproject.auth.messages.requests.DeviceData;

public class AuthenticationUtils {

	public static String generateProvisionCode() {
		// TODO Auto-generated method stub
		return RandomStringUtils.randomAlphanumeric(8).toUpperCase();
	}
	
	public static String generateUniqueId() {
		// TODO Auto-generated method stub
		return RandomStringUtils.randomNumeric(6);
	}
	
	public static String generateDeviceHash(final DeviceData deviceData) {
		
		final StringBuilder sb = new StringBuilder();
		ReflectionUtils.doWithFields(deviceData.getClass(), new FieldCallback(){

	        @Override
	        public void doWith(final Field field)
	            throws IllegalArgumentException, IllegalAccessException {
	            field.setAccessible(true);
            	sb.append(field.get(deviceData));
	        }
	    });
		
		String dataString = sb.toString().replaceAll(" ", "");
		String deviceHash = null;
		MessageDigest m;
		
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(dataString.getBytes("UTF-8"));
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			deviceHash = bigInt.toString(16);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return deviceHash;
	}
	
	public static String encode (String value){
		
		BCryptPasswordEncoder encoder = EncoderBean.getInstance();
		return encoder.encode(value);
		
	}
	
	public static boolean validateEncodedValue (String rawValue, String encodedValue){
		
		BCryptPasswordEncoder encoder = EncoderBean.getInstance();
		return encoder.matches(rawValue, encodedValue);
		
	}
	
}
