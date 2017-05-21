package com.springproject.auth.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springproject.auth.entities.DeviceAttribute;

@Repository
public interface DeviceAttributeDao extends CrudRepository<DeviceAttribute, Long>{
	
	public DeviceAttribute findByDeviceId(Long deviceId);

}
