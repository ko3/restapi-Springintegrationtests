package com.monks.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monks.spring.services.MemberDetailsService;

@RestController
public class HomeController {
	
	private MemberDetailsService memberDetailsService;
	
	@Autowired
	public HomeController(MemberDetailsService memberDetailsService) {
		this.memberDetailsService = memberDetailsService;
	}
	
	@RequestMapping(value="/hello")
	public String getDetails() {
		
		return memberDetailsService.getMemberDetails();
	}

}
