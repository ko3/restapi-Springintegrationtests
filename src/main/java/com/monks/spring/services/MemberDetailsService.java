package com.monks.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monks.spring.repository.MemberRepository;

@Service
public class MemberDetailsService {
	
	private MemberRepository memberRepository;
	
	@Autowired
	public MemberDetailsService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public String getMemberDetails() {
		
		return memberRepository.findByName("hello").getDescription();
	}

}
