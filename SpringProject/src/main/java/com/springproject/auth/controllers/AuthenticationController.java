package com.springproject.auth.controllers;


import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.auth.dao.AttributesDao;
import com.springproject.auth.dao.DeviceAttributeDao;
import com.springproject.auth.dao.UserDao;
import com.springproject.auth.dao.UserRolesDao;
import com.springproject.auth.entities.Attribute;
import com.springproject.auth.entities.DeviceAttribute;
import com.springproject.auth.entities.User;
import com.springproject.auth.entities.UserRole;
import com.springproject.auth.messages.reply.AuthenticationReplyFactory;
import com.springproject.auth.messages.reply.FindDeviceReply;
import com.springproject.auth.messages.reply.RegisterReply;
import com.springproject.auth.messages.requests.RegisterRequest;
import com.springproject.auth.utils.AuthenticationUtils;
import com.springproject.auth.utils.DeviceAttributesFactory;
import com.springproject.auth.utils.ProvisionCodesCache;

@RestController
public class AuthenticationController {
	
	@Autowired
	private DeviceAttributeDao deviceDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRolesDao rolesDao;
	@Autowired
	private AttributesDao atributesDao;
	
	
	
	@RequestMapping(value="/findDevice", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public FindDeviceReply findDevice(@RequestParam("deviceId")Long deviceId){
		
		FindDeviceReply reply;
		
		List<DeviceAttribute> devices = (List<DeviceAttribute>) deviceDao.findByDeviceId(deviceId);
		
		if(devices == null || devices.isEmpty()) {
			String provisionCode = AuthenticationUtils.generateProvisionCode();
			ProvisionCodesCache.addCode(deviceId, provisionCode);
			reply = (FindDeviceReply) AuthenticationReplyFactory.createFindDeviceReply("Device not Found", provisionCode);
		} else {
			reply = (FindDeviceReply) AuthenticationReplyFactory.createFindDeviceReply("Device Found");
		}

		return reply;
		
	}

	
	@RequestMapping(value="/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public RegisterReply register(@RequestBody RegisterRequest request){
		
		RegisterReply reply;
		User user = userDao.findByUsername(request.getUsername());
		String cachedProvisionCode = ProvisionCodesCache.getCode(request.getDeviceData().getDeviceId());
		
		if (!request.getProvisionCode().equals(cachedProvisionCode)) {
			reply = (RegisterReply) AuthenticationReplyFactory.createRegisterReply("Invalid Provision Code");
		}
		
		else if (user != null) {
			reply = (RegisterReply) AuthenticationReplyFactory.createRegisterReply("Username already exists");
			
		} else {
			
			Long deviceId = request.getDeviceData().getDeviceId();
			
			String uniqueClientId = null;
			String encodedPassword = null;
			String encodedUniqueId = null;
			
			do{
				uniqueClientId = AuthenticationUtils.generateUniqueId();
				encodedUniqueId = AuthenticationUtils.encode(uniqueClientId);
				user = userDao.findByUniqueUserId(encodedUniqueId);
			} while ( user != null);

			encodedPassword = AuthenticationUtils.encode(request.getPassword());
			
			user = new User();
			user.setUsername(request.getUsername());
			user.setPassword(encodedPassword);
			user.setDeviceId(deviceId);
			user.setUniqueUserId(encodedUniqueId);
			user.setProvisionCode(request.getProvisionCode());
			user.setDeviceFingerprint(AuthenticationUtils.generateDeviceHash(request.getDeviceData()));
			user = userDao.save(user);
			
			UserRole role = new UserRole();
			role.setUserid(user.getUserId());
			role.setRole(UserRole.ROLE_USER);
			role = rolesDao.save(role);
			
			List<Attribute> attributes = (List<Attribute>) atributesDao.findAll();
			attributes.stream().forEach(atribute -> deviceDao.save(DeviceAttributesFactory.createDeviceAttribute(atribute, request.getDeviceData())));
			
			ProvisionCodesCache.removeCode(deviceId);
			
			reply = (RegisterReply) AuthenticationReplyFactory.createRegisterReply("Register Success", uniqueClientId);
				
		}
		
		return reply;
	}
}
