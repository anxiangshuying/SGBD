package com.polytech.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bourse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String destination;
	private int numbrePoste;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "bourse2")
	private List<Demander> candidature;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getNumbrePoste() {
		return numbrePoste;
	}
	public void setNumbrePoste(int numbrePoste) {
		this.numbrePoste = numbrePoste;
	}
	public List<Demander> getCandidature() {
		return candidature;
	}
	public void setCandidature(List<Demander> candidature) {
		this.candidature = candidature;
	}
	

}
