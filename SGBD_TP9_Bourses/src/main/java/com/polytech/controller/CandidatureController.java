package com.polytech.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.polytech.dao.CandidatureDao;
import com.polytech.model.Candidature;
import com.polytech.model.Demander;
import com.polytech.model.Plan;
import com.polytech.model.Score;

public class CandidatureController {
	private EntityManager em;
	public CandidatureController(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void insertCandidature(String nom, String prenom, Double noteMoyenne, String numero) {
		Candidature candidature = new Candidature();
		candidature.setNom(nom);
		candidature.setPrenom(prenom);
		candidature.setNoteMoyenne(noteMoyenne);
		candidature.setNumero(numero);
		CandidatureDao candidatureDao = new CandidatureDao(em);
		candidatureDao.insertCandidature(candidature);
	}
	
	public void insertCandidature2(String nom, String prenom, Double noteMoyenne, String numero,List<Plan> plans,
			List<Demander> bourses,List<Score> enseignants) {
		Candidature candidature = new Candidature();
		candidature.setNom(nom);
		candidature.setPrenom(prenom);
		candidature.setNoteMoyenne(noteMoyenne);
		candidature.setNumero(numero);
		candidature.setPlan(plans);
		candidature.setBourse(bourses);
		candidature.setEnseignant(enseignants);
		CandidatureDao candidatureDao = new CandidatureDao(em);
		candidatureDao.insertCandidature(candidature);
	}
	
	public double getNoteMoyenne(int candidature_id){
		CandidatureDao candidatureDao = new CandidatureDao(em);
		double noteMoyenne = candidatureDao.getNoteMoyenne(candidature_id);
		return noteMoyenne;
	}
	
	public List<Candidature> selectAll(){
		CandidatureDao candidatureDao = new CandidatureDao(em);
		List<Candidature> list = candidatureDao.selectAll();
		return list;
	}
	
	public boolean verifyCandidature(String nom, String prenom) {
		Candidature candidature = this.selectByNom(nom);
		if (candidature != null && candidature.getNom().equals(nom) && candidature.getPrenom().equals(prenom)) {
			candidature.setId(candidature.getId());
			return true;

		} else {
			return false;
		}
	}
	
	public Candidature selectByNom(String nom){
		CandidatureDao candidatureDao = new CandidatureDao(em);
		Candidature candidature = candidatureDao.selectByNom(nom);
		return candidature;
	}
	
	public Candidature selectById(int id){
		CandidatureDao candidatureDao = new CandidatureDao(em);
		Candidature candidature = candidatureDao.selectById(id);
		return candidature;
	}

	

}
