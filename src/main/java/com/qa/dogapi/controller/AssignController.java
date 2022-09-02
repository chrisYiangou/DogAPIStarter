package com.qa.dogapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dogapi.model.Dog;
import com.qa.dogapi.service.JoinService;

@RestController
@RequestMapping("/assign")
public class AssignController {
	
	@Autowired
	JoinService service;
	
	public AssignController(JoinService service) {
		this.service = service;
	}
	
	@PutMapping("/{dogId}/assignTrainer/{trainerId}")
	public ResponseEntity<Dog> assignTrainer(@PathVariable Integer dogId, @PathVariable Integer trainerId) {
		// return new ResponseEntity<Dog>(this.service.assignTrainer(dogId, trainerId), HttpStatus.CREATED);	
		
		return (this.service.assignTrainer(dogId, trainerId) instanceof Dog) 
				? new ResponseEntity<Dog>(this.service.assignTrainer(dogId, trainerId),HttpStatus.CREATED) 
				: new ResponseEntity<Dog>(HttpStatus.NOT_FOUND);
	}
	

}
