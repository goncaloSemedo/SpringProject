package com.springproject.auth.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEVICE_ATTRIBUTES")
public class DeviceAttribute implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	@Column(name="ID")
    private Long id;
	
    @Column(name="DEVICE_ID")
    private Long deviceId;
	
	@Column(name = "ATRIBUTE_ID")
    private Long atributeId;   
	
	@Column(name ="VALUE")
	private String value;
	
	public DeviceAttribute(){}


	public DeviceAttribute(Long deviceId, Long atributeId, String value) {
		this.deviceId = deviceId;
		this.atributeId = atributeId;
		this.value = value;
	}


	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public Long getAtributeId() {
		return atributeId;
	}

	public void setAtributeId(Long atributeId) {
		this.atributeId = atributeId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}