package com.qa.dogapi.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.dogapi.model.Dog;

@Repository
public interface DogRepo extends JpaRepository<Dog, Integer>{

	//Custom quieres
	
	@Query(value = "SELECT name FROM dogs LIMIT 1", nativeQuery = true)
	public Dog findLatestDog();	
	
	@Query(value = "SELECT name FROM dogs WHERE name = ?1 AND age = ?2 LIMIT 1", nativeQuery = true)
	public Dog findSpecificDog(String name, float age);
	
	@Query(value = "UPDATE dogs SET trainer_id = ?1 WHERE dog_id = ?2;", nativeQuery = true)
	public Boolean insertTrainer(Integer trainerId, Integer dogId);

	
//	@Query(value = "Select * FROM Dog", nativeQuery = true)
//	public S save(Dog dog);
	
	
	
}
