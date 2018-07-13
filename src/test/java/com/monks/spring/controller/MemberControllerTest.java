package com.monks.spring.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.monks.spring.SpringIntegrationTestsApplication;
import com.monks.spring.controller.requestmodel.Member;
import com.monks.spring.integrationtestconfig.IntegrationTestContext;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringIntegrationTestsApplication.class)
@ContextConfiguration(classes = IntegrationTestContext.class)
@WebAppConfiguration
public class MemberControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	@Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void test() throws Exception {
		Member member = new Member();
		member.setName("Rajinikanth");
		member.setDescription("No one can stop");
		
		MvcResult mvcResult = mockMvc.perform(post("/member")
												.contentType(MediaType.APPLICATION_JSON)
												.content(asJsonString(member)))
									.andExpect(status().isOk())
									.andReturn();
		Member member2 = asJavaObject(mvcResult.getResponse().getContentAsString(), Member.class);
		assertEquals("Rajinikanth", member2.getName());
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public static <T> T asJavaObject(String content, Class<T> cl) {
	    try {
	        return new ObjectMapper().readValue(content, cl);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

}
