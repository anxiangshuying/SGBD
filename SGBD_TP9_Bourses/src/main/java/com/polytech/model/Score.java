package com.polytech.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Score {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double note;
	@ManyToOne(cascade = CascadeType.ALL)
	private Candidature candidature1;
	@ManyToOne(cascade = CascadeType.ALL)
	private Enseignant enseignant1;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	public Candidature getCandidature1() {
		return candidature1;
	}
	public void setCandidature1(Candidature candidature1) {
		this.candidature1 = candidature1;
	}
	public Enseignant getEnseignant1() {
		return enseignant1;
	}
	public void setEnseignant1(Enseignant enseignant1) {
		this.enseignant1 = enseignant1;
	}
	

}
