package com.qa.dogapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.dogapi.model.Trainer;
import com.qa.dogapi.repo.TrainerRepo;

@Service
public class TrainerService {

	@Autowired
	TrainerRepo repo;

	public TrainerService(TrainerRepo repo) {
		this.repo = repo;
	}

	// Single - Many addManyDogs
	public Trainer create(Trainer trainer) {
		return this.repo.save(trainer);
	}

	// Many
	public List<Trainer> createMany(List<Trainer> trainers) {
		return this.repo.saveAllAndFlush(trainers);
	}

	// Read
	public Trainer readTrainerByID(Integer id) {
		return this.repo.findById(id).get();
	}

	// Optionals ^^^ .get() -- Shrogingers Cat -- Box --> Cat ? =>
	// Optionals --> An Id may or may not exist -> If it does exist and we use the
	// .get() -> it returns to us a Cat
	// Otherwise it will be a Does not exist -> Null

	public Trainer readByLatest() {
		return this.repo.findLatest();
	}

	public List<Trainer> readAll() {
		return this.repo.findAll();
	}

	// Update
	// This isnt the same --> Challenging because we need to get -> then replace
	// variables -> then save
	// Controllers --> and trigger the Service Class methods

	public Trainer updateById(Trainer newTrainer, Integer id) {

		Optional<Trainer> oldTrainer = this.repo.findById(id);

		if (oldTrainer.isPresent()) {
			Trainer updatedTrainer = oldTrainer.get();
			updatedTrainer.setName(newTrainer.getName());
			updatedTrainer.setFavBreed(newTrainer.getFavBreed());
			return this.repo.saveAndFlush(updatedTrainer);
		}

		return null;
	}

	public boolean deleteById(Integer id) {

		Optional<Trainer> dogExists = this.repo.findById(id);

		if (dogExists.isPresent()) {
			this.repo.deleteById(id);
			return true;
		}

		return false;

	}

}
