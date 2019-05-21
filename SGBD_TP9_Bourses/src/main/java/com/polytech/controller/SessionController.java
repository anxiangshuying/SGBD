package com.polytech.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionController {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("erasmus");
	private static EntityManager em = emf.createEntityManager();
	private static UserController userController = new UserController(em);
	private static BourseController  bourseController= new BourseController(em); 
	private static CandidatureController  candidatureController= new CandidatureController(em); 
	private static EnseignantController  enseignantController= new EnseignantController(em); 
	private static PlanController  planController= new PlanController(em); 
	private static ScoreController  scoreController= new ScoreController(em); 

	private static int actuelUserId;
	
	public static EntityManager getEm() {
		return em;
	}

	public static int getActuelUserId() {
		return actuelUserId;
	}

	public static void setActuelUserId(int actuelUserId) {
		SessionController.actuelUserId = actuelUserId;
	}

	public static UserController getUserController() {
		return userController;
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}
  
	public static void setEmf(EntityManagerFactory emf) {
		SessionController.emf = emf;
	}

	public static BourseController getBourseController() {
		return bourseController;
	}

	public static CandidatureController getCandidatureController() {
		return candidatureController;
	}

	public static EnseignantController getEnseignantController() {
		return enseignantController;
	}

	public static PlanController getPlanController() {
		return planController;
	}

	public static ScoreController getScoreController() {
		return scoreController;
	}

	public static void setEm(EntityManager em) {
		SessionController.em = em;
	}

	
}
