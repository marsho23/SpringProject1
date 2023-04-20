package com.example.demo.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.domain.Cat;
import com.fasterxml.jackson.databind.ObjectMapper;;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:cat-schema.sql","classpath:cat-data.sql"})
public class CatIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		Cat newCat = new Cat("Chairman Meow",true,true,12);
		String newCatAsJson = this.mapper.writeValueAsString(newCat);
		RequestBuilder req = post("/create")
				.content(newCatAsJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		ResultMatcher checkStatus = MockMvcResultMatchers.status().isCreated();
		Cat created = new Cat(2L,"Chairman Meow",true,true,12);
		String createdAsJson = this.mapper.writeValueAsString(created);
		ResultMatcher checkBody = content().json(createdAsJson);
		
		this.mvc.perform(req)
		.andExpect(checkStatus)
		.andExpect(checkBody);
	}
	
//	@Test
//	void testUpdate() throws Exception{
//		Cat c= new Cat ("Chairman Meow",true,true,12);
//		Cat created = 
//	}
	
}
