package com.qa.dogapi.persistance.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "trainers")
public class Trainer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trainerId;
	
	@Column(nullable = false, length = 255)
	private String name;
	
	@Column(length = 255)
	private String favBreed;
	
	
	@OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL)
//	@JsonBackReference
	private Set<Dog> dogsOwned;
	

	public Trainer() {
		this.dogsOwned = new HashSet<>();
		
	}
	
	public Trainer(String name, String favBreed) {
		this.name = name;
		this.favBreed = favBreed;
		this.dogsOwned = new HashSet<>();
	}
	
	public Trainer(Integer trainerId, String name, String favBreed) {
		this.trainerId = trainerId;
		this.name = name;
		this.favBreed = favBreed;
		this.dogsOwned = new HashSet<>() ;
	}

	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFavBreed() {
		return favBreed;
	}

	public void setFavBreed(String favBreed) {
		this.favBreed = favBreed;
	}
	

	public Set<Dog> getDogsOwned() {
		return dogsOwned;
	}

	public void setDogsOwned(Set<Dog> dogsOwned) {
		this.dogsOwned = dogsOwned;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(favBreed, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainer other = (Trainer) obj;
		return Objects.equals(favBreed, other.favBreed) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", name=" + name + ", favBreed=" + favBreed + ", dogsOwned="
				+ this.getDogsOwned() + "]";
	}


	
	
	
	
	
	

}
