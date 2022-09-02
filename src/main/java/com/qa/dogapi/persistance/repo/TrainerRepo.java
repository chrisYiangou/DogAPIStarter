package com.qa.dogapi.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.dogapi.persistance.model.Trainer;

@Repository
public interface TrainerRepo extends JpaRepository<Trainer, Integer> {

	//Will add more complex queries later
	
	@Query(value = "SELECT * FROM trainers LIMIT 1",
			nativeQuery = true)
	public Trainer findLatest();
}
