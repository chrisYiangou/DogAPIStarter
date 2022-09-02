package com.qa.dogapi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.dogapi.persistance.model.Dog;
import com.qa.dogapi.service.DogService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class DogControllerUnitTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private DogService service;
	
	@Test
	public void testCreate() throws Exception {
		//Create the JSON
		Dog testDog = new Dog("John", 3);
		String testDogAsJson = this.mapper.writeValueAsString(testDog);
		
		Mockito.when(this.service.createDog(testDog)).thenReturn(testDog);
		
		mvc.perform(post("/home/createDog")
				.content(testDogAsJson)
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().isAccepted());
		
		
	}
	
	
	
	

	
}
