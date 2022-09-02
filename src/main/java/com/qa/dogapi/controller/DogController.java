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

import com.qa.dogapi.model.Dog;
import com.qa.dogapi.service.DogService;
import com.qa.dogapi.service.JoinService;

@RestController
@RequestMapping("/dogs")
public class DogController {

	@Autowired
	DogService service;
	
	@Autowired
	JoinService joinService;
	
	public DogController(DogService service, JoinService joinService) {
		this.service = service;
		this.joinService = joinService;
	}
	
	@GetMapping("/get")
	public String helloWorld() {
		return "<h1> Hello World </h1>";
	}
	
	//For the most part we just want to return an status code in the of 2XX
	
//	public Dog readDogByID(Float id) {
//		return this.repo.findById(id).get();
//	}
	@GetMapping("/get-by-id/{id}")
	public ResponseEntity<Dog> getDogById(@PathVariable Integer id) {
		return new ResponseEntity<Dog>(this.service.readDogByID(id), HttpStatus.ACCEPTED);
	}
	
	//To enable a body of text over JSON we use the @ResponseBody --
	//Task create the rest of this full CRUD
	
	@GetMapping("/get-all")
	public ResponseEntity<List<Dog>> getAllDogs() {
		return new ResponseEntity<List<Dog>>(this.service.readAllDogs(), HttpStatus.ACCEPTED);
	}
	
	// Get - Post - Patch/Put - Delete
	// R      C       U          D
	
	// Patch - This is a minor rework -- changing one variable in the object - Patch
	// Put - This is a major rework --- Complete change of the object
	
	@PostMapping("/createDog")
	public ResponseEntity<Dog> createDog(@RequestBody Dog dog) {
		return new ResponseEntity<Dog>(this.service.createDog(dog), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateDog/{id}")
	public ResponseEntity<Dog> updateDogById(@RequestBody Dog dog, @PathVariable Integer id) {
		return new ResponseEntity<Dog>(this.service.updateDogById(dog, id), HttpStatus.ACCEPTED);
	}
	
	
	
	@DeleteMapping("/deleteDog/{id}")
	public ResponseEntity<Boolean> deleteDogById(@PathVariable Integer id) {
		
		return (this.service.deleteById(id)) ?
				new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT) :
				new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}
	
}
