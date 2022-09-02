package com.qa.dogapi.dto;

import java.util.Objects;

public class DogDTO {

	private Integer dogId;
	private String name;
	private String trainerName;

	public DogDTO(Integer dogId, String name, String trainerName) {
		this.dogId = dogId;
		this.name = name;
		this.trainerName = trainerName;
	}

	public DogDTO(String name, String trainerName) {
		this.name = name;
		this.trainerName = trainerName;
	}

	public DogDTO() {

		
	}
	
	public Integer getDogId() {
		return dogId;
	}

	public void setDogId(Integer dogId) {
		this.dogId = dogId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dogId, name, trainerName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DogDTO other = (DogDTO) obj;
		return Objects.equals(dogId, other.dogId) && Objects.equals(name, other.name)
				&& Objects.equals(trainerName, other.trainerName);
	}

	@Override
	public String toString() {
		return "DogDTO [dogId=" + dogId + ", name=" + name + ", trainerName=" + trainerName + "]";
	}
	
	

}
