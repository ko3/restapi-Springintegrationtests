package com.monks.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monks.spring.controller.requestmodel.Member;
import com.monks.spring.services.MemberDetailsService;

@RestController
public class MemberController {
	
	private MemberDetailsService memberDetailsService;
	
	@Autowired
	public MemberController(MemberDetailsService memberDetailsService) {
		this.memberDetailsService = memberDetailsService;
	}
	
	@GetMapping(value="/member/{id}")
	public String getMemberDetails(@PathVariable Long memberId) throws Exception {
		
		return memberDetailsService.getMemberDetailsById(memberId);
	}
	
	@PostMapping(value="/member")
	public com.monks.spring.repository.entity.Member addMember(@RequestBody Member member) throws Exception {
		
		return memberDetailsService.saveMember(member);
	}
	
	@GetMapping(value="/members")
	public List<com.monks.spring.repository.entity.Member> getAllMembers() throws Exception {
		
		return memberDetailsService.getAllMembers();
	}


}
