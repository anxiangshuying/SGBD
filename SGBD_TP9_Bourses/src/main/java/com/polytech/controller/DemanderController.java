package com.polytech.controller;

import javax.persistence.EntityManager;

import com.polytech.dao.DemanderDao;
import com.polytech.model.Bourse;
import com.polytech.model.Candidature;
import com.polytech.model.Demander;

public class DemanderController {
	private EntityManager em;

	public DemanderController(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void insertDemander(double note,Bourse bourse,Candidature candidature){
		Demander demander = new Demander();
		demander.setNote(note);
		demander.setBourse2(bourse);
		demander.setCandidature2(candidature);
		DemanderDao demanderDao = new DemanderDao(em);
		demanderDao.insertDemander(demander);
	}

}
