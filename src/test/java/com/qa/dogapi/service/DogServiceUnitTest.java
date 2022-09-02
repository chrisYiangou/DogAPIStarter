package com.qa.dogapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.dogapi.persistance.model.Dog;
import com.qa.dogapi.persistance.repo.DogRepo;

@SpringBootTest()
public class DogServiceUnitTest {
	
	//Mockito is an automation 
	//Similar to Selenium -> Its webdriver and its used within testing 
	//mimics user interaction -> login to a website
	//add Dogs into a System 
	
	//Mockito --> You define behaviour and how the test will be run 
	//@MockBean 
	
	@Autowired
	private DogService service;
	
	@MockBean
	private DogRepo repo;
	
	@Test
	public void dogCreate_ValidDog_SavedDog() {
		
		//1 the dog Im going to input into my repo
		//2 the dog that Im expecting
		
		Dog saveThisDog = new Dog("Saliba", 12);
		Dog expectedDog = new Dog(1,"Saliba", 12);
		
		Mockito.when(this.repo.save(saveThisDog)).thenReturn(expectedDog);
		
		assertEquals(expectedDog, this.service.createDog(saveThisDog));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(saveThisDog);
	}
	
	@Test
	public void readById_ValidNumber_ValidDog() {
		
		// First off I need a valid dog in the database
		Integer validId = 1;
		Dog saveThisDog = new Dog("Saliba", 12);
		
		Optional<Dog> mockValidOutput =
					Optional.ofNullable(new Dog(1,"Saliba", 12));
		
		Mockito.when(this.repo.findById(validId))
		.thenReturn(mockValidOutput);
		
		assertEquals(mockValidOutput.get(), this.service.readDogByID(validId));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(validId);
		
	}
	
	//Create the rest of the CRUD service tests
	

}
