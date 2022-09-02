package com.qa.dogapi.dto;

public class DogDTO {

	private Integer dogId;
	private String name;
	private String trainerName;
	
	public DogDTO(Integer dogId, String name, String trainerName) {
		super();
		this.dogId = dogId;
		this.name = name;
		this.trainerName = trainerName;
	}
	
	public DogDTO(String name, String trainerName) {
		
		this.dogId = dogId;
		this.name = name;
		this.trainerName = trainerName;
	}

	
}
