package com.qa.dogapi.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qa.dogapi.dto.DogDTO;
import com.qa.dogapi.persistance.model.Dog;


@Component
public class DogMapper {

	
	@Autowired
	private ModelMapper mapper = new ModelMapper();
	
	public DogMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	//Singular
	public DogDTO mapToDTO(Dog dog) {
		return this.mapper.map(dog, DogDTO.class);
	}
	
	public Dog mapTodog(DogDTO dogDTO) {
		return this.mapper.map(dogDTO, Dog.class);
	}
	
	//Multiple
	public List<DogDTO> mapToDTO(List<Dog> dogs) {
		
		List<DogDTO> dogDTOs = new ArrayList<>();
		
		dogs.forEach(t -> dogDTOs.add(mapToDTO(t)));
		
		return dogDTOs;
	}
	
	public List<Dog> mapTodog(List<DogDTO> dogDTOs) {
		
		List<Dog> dogs = new ArrayList<>();
		
		dogDTOs.forEach(t -> dogs.add(mapTodog(t)));
		
		return dogs;
		
	}
	
	
}
