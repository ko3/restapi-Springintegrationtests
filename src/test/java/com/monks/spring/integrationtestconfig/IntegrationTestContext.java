package com.monks.spring.integrationtestconfig;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.repository.NoRepositoryBean;

import com.monks.spring.repository.MemberRepository;

@Configuration
@ComponentScan(basePackages = {"com.monks.spring"},
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = NoRepositoryBean.class))
public class IntegrationTestContext {
	
	@Bean
	public MemberRepository mockMemberRepository() {
		return mock(MemberRepository.class);
	}
	

}
