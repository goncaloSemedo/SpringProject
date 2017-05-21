package com.springproject.auth.utils;

import com.springproject.auth.entities.Attribute;
import com.springproject.auth.entities.DeviceAttribute;
import com.springproject.auth.messages.requests.DeviceData;

public abstract class DeviceAttributesFactory {
	
	
	public static DeviceAttribute createDeviceAttribute(Attribute atribute, DeviceData deviceData){
		
		DeviceAttribute device = new DeviceAttribute();
		device.setDeviceId(deviceData.getDeviceId());
		device.setAtributeId(atribute.getAtributeId());
		
		
		switch(atribute.getAtributeName()){
		
		case Attribute.OPERATING_SYSTEM: 
			device.setValue(deviceData.getOs());
			break;
			
		case Attribute.MODEL: 
			device.setValue(deviceData.getModel());
			break;
		default:
			return null;
			
		}
		return device;
		
	}

}
