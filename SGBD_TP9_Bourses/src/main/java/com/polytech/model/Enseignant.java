package com.polytech.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Enseignant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String isLocalOrEcole;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "enseignant1")
	private List<Score> candidature;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getIsLocalOrEcole() {
		return isLocalOrEcole;
	}
	public void setIsLocalOrEcole(String isLocalOrEcole) {
		this.isLocalOrEcole = isLocalOrEcole;
	}
	public List<Score> getCandidature() {
		return candidature;
	}
	public void setCandidature(List<Score> candidature) {
		this.candidature = candidature;
	}
	

}
