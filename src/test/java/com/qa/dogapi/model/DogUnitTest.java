package com.qa.dogapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.dogapi.persistance.model.Dog;

import nl.jqno.equalsverifier.EqualsVerifier;

public class DogUnitTest {
	
	Dog testDog;
	
	@BeforeEach
	public void constructDog() {
		testDog = new Dog(1, "Bob",10);
	}
	
	
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Dog.class).verify();
	}
	
	//All Tests need a @Test annotation 
	//They will also be void 
	
	
	// We should be testing the methods in seldom
	// Ideally only one method is trigger
	
	@Test 
	public void constructors_Dog_Instance() {
		
		//Construct something and then verify it exists
		//For a constructor to work 
		// I need to create a dog		
		Dog dogOne = new Dog();
		
		//I need to see if it truly is of Type Dog
		assertTrue(dogOne instanceof Dog);
		
		Dog dogTwo = new Dog(1, "Bob", 10);		
		assertTrue(dogTwo instanceof Dog);
		assertEquals("Bob", dogTwo.getName());
		
	}
	
	
	@Test
	public void gettersTest() {
		
		// Need to get the test dogs name
		//	testDog = new Dog(1, "Bob",10);
		
		Integer expectedId = 1;
		String expectedName = "Bob";
		float expectedAge = 10F;
		
		assertEquals(expectedId, testDog.getDogId());
		assertEquals(expectedName, testDog.getName());
		assertEquals(expectedAge, testDog.getAge());
		
		assertTrue(testDog.getName() instanceof String);
		
		//Int 32 bits -- Double 64
		
	}
	
}
