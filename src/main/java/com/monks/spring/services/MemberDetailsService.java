package com.monks.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monks.spring.repository.MemberRepository;
import com.monks.spring.repository.entity.Member;

@Service
public class MemberDetailsService {
	
	private MemberRepository memberRepository;
	
	@Autowired
	public MemberDetailsService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public String getMemberDetailsById(Long memberId) throws Exception {
		
		Optional<Member> optionalMember = memberRepository.findById(memberId);
		if(optionalMember.isPresent()) {
			return optionalMember.get().getDescription();
		}
		throw new Exception();
	}
	
	public String getMemberDetailsByName(String firstName) {
		
		return memberRepository.findByName(firstName).getDescription();
	}
	
	public Member saveMember(com.monks.spring.controller.requestmodel.Member member) {
		Member memberEntity = new Member();
		memberEntity.setName(member.getName());
		memberEntity.setDescription(member.getDescription());
		return memberRepository.save(memberEntity);
	}
	
	public List<Member> getAllMembers(){
		return (List<Member>) memberRepository.findAll();
	}

}
