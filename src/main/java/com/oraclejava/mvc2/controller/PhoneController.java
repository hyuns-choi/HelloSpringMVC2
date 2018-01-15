package com.oraclejava.mvc2.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oraclejava.mvc2.dao.PhoneDao;
import com.oraclejava.mvc2.model.Phone;

@Controller
@RequestMapping("/phone")
public class PhoneController {
	
	@Autowired
	private PhoneDao<Phone> dao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Map<String, Object>model) {
		List<Phone> pList = dao.getAllEntity();
		model.put("phoneList", pList);
		return "phone/index";
	}

}
