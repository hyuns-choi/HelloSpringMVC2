package com.oraclejava.mvc2.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oraclejava.mvc2.dao.PhoneDao;
import com.oraclejava.mvc2.dao.PhoneDaoRepository;
import com.oraclejava.mvc2.model.Phone;

@Controller
@RequestMapping("/phone")
public class PhoneController {
	
	//@Autowired
	//private PhoneDao<Phone> dao;
	
	@Autowired
	private PhoneDaoRepository repository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Map<String, Object>model) {
		//List<Phone> pList = dao.getAllEntity();
		List<Phone> pList = repository.findAll();
		model.put("phoneList", pList);
		
		return "phone/index";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addPhone(@RequestParam String mode,
			@RequestParam int idx,
			@RequestParam String name,
			@RequestParam int price) {
		
		Phone phone;
		if(mode.equals("insert")) {
			phone = new Phone(name, price);
			//dao.addEntity(phone);
			repository.saveAndFlush(phone);
		}
		else if(mode.equals("edit")) {
			
			phone = new Phone(name, price);
			phone.setId(idx);
			
			//dao.updateEntity(phone);
			repository.saveAndFlush(phone);
		}
		else if(mode.equals("del")) {
			
			//dao.removeEntity(idx);
			phone = new Phone(name, price);
			phone.setId(idx);
			
			repository.delete(phone);
		}
				
		return "redirect:/phone";
	}
}
