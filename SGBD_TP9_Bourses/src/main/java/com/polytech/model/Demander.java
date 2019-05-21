package com.polytech.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Demander {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double note;
	@ManyToOne(cascade = CascadeType.ALL)
	private Candidature candidature2;
	@ManyToOne(cascade = CascadeType.ALL)
	private Bourse bourse2;
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
	public Candidature getCandidature2() {
		return candidature2;
	}
	public void setCandidature2(Candidature candidature2) {
		this.candidature2 = candidature2;
	}
	public Bourse getBourse2() {
		return bourse2;
	}
	public void setBourse2(Bourse bourse2) {
		this.bourse2 = bourse2;
	}
	
	
}
