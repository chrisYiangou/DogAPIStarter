package com.qa.dogapi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.dogapi.model.Dog;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = 
{"classpath:dog-schema.sql", "classpath:dog-data.sql"},
executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class DogControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;	
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void testCreate() throws Exception {
		Dog testDog = new Dog("Fanta", 4);
		Dog expectedDog = new Dog(3, "Fanta", 4);
		
		String testDogAsJson = mapper.writeValueAsString(testDog);
		String expectedDogAsJson = mapper.writeValueAsString(expectedDog);
		
		mvc.perform(post("/home/createDog")
				.content(testDogAsJson)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted());
//				.andExpect(content().json(expectedDogAsJson));
	}
	
	
	
}
