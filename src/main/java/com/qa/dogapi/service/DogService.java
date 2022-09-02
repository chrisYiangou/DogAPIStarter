package com.qa.dogapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.dogapi.model.Dog;
import com.qa.dogapi.repo.DogRepo;

@Service
public class DogService {
	
	@Autowired
	DogRepo repo;
	
	public DogService(DogRepo repo) {
		this.repo = repo; 
	}
	
	//Single - Many addManyDogs
	public Dog createDog(Dog dog) {
		return this.repo.save(dog);
	}
	
	//Many 
	public List<Dog> createManyDogs(List<Dog> dogs) {
		return this.repo.saveAllAndFlush(dogs);
	}
	
	//Read
	public Dog readDogByID(Integer id) {
		return this.repo.findById(id).get();
	}
	
	//Optionals ^^^ .get() -- Shrogingers Cat -- Box --> Cat ? =>
	// Optionals --> An Id may or may not exist -> If it does exist and we use the .get() -> it returns to us a Cat 
	// Otherwise it will be a Does not exist -> Null
	
	public Dog readByLatestDog() {
		return this.repo.findLatestDog();
	}
	
	public List<Dog> readAllDogs() {
		return this.repo.findAll();
	}
	
	//Update
	//This isnt the same --> Challenging because we need to get -> then replace variables -> then save
	//	Controllers --> and trigger the Service Class methods 
	
	public Dog updateDogById(Dog newDog, Integer id) {
		
		
		Optional<Dog> oldDog = this.repo.findById(id);
		
		if (oldDog.isPresent()) {
			Dog updatedDog = oldDog.get();
			updatedDog.setAge(newDog.getAge());
			updatedDog.setName(newDog.getName());
			updatedDog.setTrainer(newDog.getTrainer());
			return this.repo.saveAndFlush(updatedDog);
		}
		
		return null;
	}
	
	public boolean deleteById(Integer id) {
		
		Optional<Dog> dogExists = this.repo.findById(id);
		
		if (dogExists.isPresent()) {
			this.repo.deleteById(id);
			return true;
		}
		
		return false;
		
		
	}
	
	//CRUD Application -- The next part of this would be the Controllers
	
	
	
	
	
	
	
	
	
	
	
	//I want you guys to create for me 
	//CRUD functionality for single Dogs and many Dogs
	
	//
	
	
	

}
