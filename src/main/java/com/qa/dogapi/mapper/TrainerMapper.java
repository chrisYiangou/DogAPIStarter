package com.qa.dogapi.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qa.dogapi.dto.TrainerDTO;
import com.qa.dogapi.persistance.model.Trainer;

@Component
public class TrainerMapper {

	@Autowired
	private ModelMapper mapper = new ModelMapper();
	
	public TrainerMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	//Singular
	public TrainerDTO mapToDTO(Trainer trainer) {
		return this.mapper.map(trainer, TrainerDTO.class);
	}
	
	public Trainer mapToTrainer(TrainerDTO trainerDTO) {
		return this.mapper.map(trainerDTO, Trainer.class);
	}
	
	//Multiple
	public List<TrainerDTO> mapToDTO(List<Trainer> trainers) {
		
		List<TrainerDTO> trainerDTOs = new ArrayList<>();
		
		trainers.forEach(t -> trainerDTOs.add(mapToDTO(t)));
		
		return trainerDTOs;
	}
	
	public List<Trainer> mapToTrainer(List<TrainerDTO> trainerDTOs) {
		
		List<Trainer> trainers = new ArrayList<>();
		
		trainerDTOs.forEach(t -> trainers.add(mapToTrainer(t)));
		
		return trainers;
		
	}
	
	
}
