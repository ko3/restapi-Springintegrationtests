package com.monks.spring.integrationtestconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"com.monks.spring"})
public class IntegrationTestContext {
	

}
