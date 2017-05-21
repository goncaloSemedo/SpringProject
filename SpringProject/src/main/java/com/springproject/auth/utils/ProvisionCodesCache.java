package com.springproject.auth.utils;

import java.util.HashMap;

public class ProvisionCodesCache {
	
	private static HashMap<Long, String> provisonCodesCache = new HashMap<Long, String>();
	
	private ProvisionCodesCache() {}
	
	public synchronized static void addCode (Long deviceId, String code){
		provisonCodesCache.put(deviceId, code);
	}
	
	public synchronized static String getCode (Long deviceId){
		return provisonCodesCache.get(deviceId);
	}
	
	public synchronized static void removeCode (Long deviceId){
		provisonCodesCache.remove(deviceId);
	}
	
	
	
	

}
