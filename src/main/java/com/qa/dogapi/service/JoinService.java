package com.qa.dogapi.service;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.dogapi.persistance.model.Dog;
import com.qa.dogapi.persistance.model.Trainer;
import com.qa.dogapi.persistance.repo.DogRepo;
import com.qa.dogapi.persistance.repo.TrainerRepo;

@Service
public class JoinService {
	
	@Autowired
	DogRepo dogRepo;
	
	@Autowired
	TrainerRepo trainerRepo;
	
	public JoinService(DogRepo dogRepo, TrainerRepo trainerRepo) {
		this.dogRepo = dogRepo;
		this.trainerRepo = trainerRepo;
	}
	
	//I want to: use this service to put the  trainer Id into the dog
	public Dog assignTrainer (Integer dogId, Integer trainerId) {
		Trainer trainer = trainerRepo.findById(trainerId)
				.orElseThrow(() -> new ObjectNotFoundException(Trainer.class, "Trainer not found"));
		Dog dog = dogRepo.findById(dogId)
				.orElseThrow(() -> new ObjectNotFoundException(Dog.class,"Dog Not Found"));
		
		dog.setTrainer(trainer);
		dogRepo.save(dog);
		System.out.println(dog);
		
		trainer.getDogsOwned().add(dog);
		trainerRepo.save(trainer);
		System.out.println(trainer);
		
		System.out.println(trainer.getDogsOwned());
		
		return dog;	
	}

}
