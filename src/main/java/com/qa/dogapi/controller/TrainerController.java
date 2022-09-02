package com.qa.dogapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dogapi.model.Trainer;
import com.qa.dogapi.service.TrainerService;


@RestController
@RequestMapping("/trainer")
public class TrainerController {
	
	@Autowired
	TrainerService service;
	
	public TrainerController(TrainerService service) {
		this.service = service;
	}
	
	@GetMapping("/get-by-id/{id}")
	public ResponseEntity<Trainer> gettrainerById(@PathVariable Integer id) {
		return new ResponseEntity<Trainer>(this.service.readTrainerByID(id), HttpStatus.ACCEPTED);
	}
	
	//To enable a body of text over JSON we use the @ResponseBody --
	//Task create the rest of this full CRUD
	
	@GetMapping("/get-all")
	public ResponseEntity<List<Trainer>> getAlltrainers() {
		return new ResponseEntity<List<Trainer>>(this.service.readAll(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Trainer> createtrainer(@RequestBody Trainer trainer) {
		return new ResponseEntity<Trainer>(this.service.create(trainer), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Trainer> updatetrainerById(@RequestBody Trainer trainer, @PathVariable Integer id) {
		return new ResponseEntity<Trainer>(this.service.updateById(trainer, id), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deletetrainerById(@PathVariable Integer id) {
		
		return (this.service.deleteById(id)) ?
				new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT) :
				new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

}
