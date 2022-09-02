package com.qa.dogapi.persistance.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "dogs")
public class Dog implements Serializable{
	
	//So at this point in time - this is no different to normal object
	//Beans -- functions that are managed by the Framework 
	//Components --{

	//Javax - Java Extension -- java 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dogId;
	
	@NotNull
	@Size(min = 2, max = 20)
	private String name;
	
	@Min(0)
	@Max(28)
	private float age;
	
	private String trainerName;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "trainerId")
	private Trainer trainer;

	//One to retrive data
	
	
	

	public Dog() {
		
	}
	
	public Dog(Integer dogId,  String name, float age,String trainerName, Trainer trainer) {
		this.dogId = dogId;
		this.name = name;
		this.age = age;
		this.trainerName = trainer.getName();
		this.trainer = trainer;
	}
	
	public Dog(String name,float age,String trainerName, Trainer trainer) {
		this.name = name;
		this.age = age;
		this.trainerName = trainer.getName();
		this.trainer = trainer;
	}
	
	// So when passing in JSON -- must be in above format
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

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}
	

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
		this.trainerName = trainer.getName();
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name, trainerName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		return Float.floatToIntBits(age) == Float.floatToIntBits(other.age) && Objects.equals(name, other.name)
				&& Objects.equals(trainerName, other.trainerName);
	}

	@Override
	public String toString() {
		return "Dog [dogId=" + dogId + ", name=" + name + ", age=" + age + ", trainerName=" + trainerName + "]";
	}



	
	
	
//	String colour;
//	int noOfLegs;
//	boolean hasTail;
	
	
	
	
	

}
