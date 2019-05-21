package com.polytech.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.polytech.dao.PlanDao;
import com.polytech.model.Candidature;
import com.polytech.model.Plan;

public class PlanController {
	private EntityManager em;
	public PlanController(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void insertPlan(String nom,String credits,int volumeHoraire,Candidature candidature){
		Plan plan = new Plan();
		PlanDao planDao = new PlanDao(em);
		plan.setNom(nom);
		plan.setCredits(credits);
		plan.setVolumeHoraire(volumeHoraire);
		plan.setCandidature(candidature);
		planDao.insertPlan(plan);
	}
	
	public List<Plan> selectAll(){
		PlanDao planDao = new PlanDao(em);
		List<Plan> results= planDao.selectAll();
		return results;
	}
	

}
