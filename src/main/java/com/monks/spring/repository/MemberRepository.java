package com.monks.spring.repository;


import org.springframework.data.repository.CrudRepository;

import com.monks.spring.repository.entity.Member;


public interface MemberRepository extends CrudRepository<Member, Long>{
	
	
	Member findByName(String name);

}
