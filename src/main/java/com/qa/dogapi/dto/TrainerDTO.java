package com.qa.dogapi.dto;

import java.util.Objects;
import java.util.Set;

import com.qa.dogapi.persistance.model.Dog;

public class TrainerDTO {
	
	private Integer trainerId;
	private String trainerName;
	private String favBreed;
	private Set<DogDTO> dogsOwned;
	
	public TrainerDTO () {
		
	}

	public TrainerDTO(Integer trainerId, String trainerName, String favBreed, Set<DogDTO> dogsOwned) {
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.favBreed = favBreed;
		this.dogsOwned = dogsOwned;
	}

	public TrainerDTO(String trainerName, String favBreed, Set<DogDTO> dogsOwned) {
		super();
		this.trainerName = trainerName;
		this.favBreed = favBreed;
		this.dogsOwned = dogsOwned;
	}

	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getFavBreed() {
		return favBreed;
	}

	public void setFavBreed(String favBreed) {
		this.favBreed = favBreed;
	}

	public Set<DogDTO> getDogsOwned() {
		return dogsOwned;
	}

	public void setDogsOwned(Set<DogDTO> dogsOwned) {
		this.dogsOwned = dogsOwned;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(dogsOwned, favBreed, trainerId, trainerName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainerDTO other = (TrainerDTO) obj;
		return Objects.equals(dogsOwned, other.dogsOwned) && Objects.equals(favBreed, other.favBreed)
				&& Objects.equals(trainerId, other.trainerId) && Objects.equals(trainerName, other.trainerName);
	}

	@Override
	public String toString() {
		return "TrainerDTO [trainerId=" + trainerId + ", trainerName=" + trainerName + ", favBreed=" + favBreed
				+ ", dogsOwned=" + dogsOwned + "]";
	}
	
	
	
	
	

}
