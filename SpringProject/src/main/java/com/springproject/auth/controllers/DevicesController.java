package com.springproject.auth.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springproject.auth.dao.AttributesDao;
import com.springproject.auth.entities.Attribute;

@RestController
public class DevicesController {
	
	@Autowired
	private AttributesDao dao;
	
	@RequestMapping(value="/devices", method = RequestMethod.GET)
	public ModelAndView  getDevices(Model model){
		
		List<Attribute> fingerprints = (List<Attribute>) dao.findAll();
		
		
		return new ModelAndView("devices", "fingerprints", fingerprints);
		
	}

}


