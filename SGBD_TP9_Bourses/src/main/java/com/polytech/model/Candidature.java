package com.polytech.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Candidature{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String numero;
	private double noteMoyenne;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "candidature")
	private List<Plan> plan;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "candidature2")
	private List<Demander> bourse;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "candidature1")
	private List<Score> enseignant;
	
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
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getNoteMoyenne() {
		return noteMoyenne;
	}
	public void setNoteMoyenne(double noteMoyenne) {
		this.noteMoyenne = noteMoyenne;
	}
	public List<Plan> getPlan() {
		return plan;
	}
	public void setPlan(List<Plan> plan) {
		this.plan = plan;
	}
	public List<Demander> getBourse() {
		return bourse;
	}
	public void setBourse(List<Demander> bourses) {
		this.bourse = bourses;
	}
	public List<Score> getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(List<Score> enseignants) {
		this.enseignant = enseignants;
	}

}
