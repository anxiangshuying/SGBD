package com.polytech.app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.polytech.controller.BourseController;
import com.polytech.controller.CandidatureController;
import com.polytech.controller.DemanderController;
import com.polytech.controller.EnseignantController;
import com.polytech.controller.PlanController;
import com.polytech.controller.ScoreController;
import com.polytech.controller.SessionController;
import com.polytech.controller.UserController;
import com.polytech.dao.PlanDao;
import com.polytech.model.Bourse;
import com.polytech.model.Candidature;
import com.polytech.model.Enseignant;
import com.polytech.model.Plan;

public class DataInit {
	
	public static void init(){
		EntityManager em = SessionController.getEm();
		
		Plan plan = new Plan();
		plan.setNom("JAVA");
		plan.setCredits("nice");
		plan.setVolumeHoraire(40);
		Plan plan2 = new Plan();
		plan2.setNom("c++");
		plan2.setCredits("nice");
		plan2.setVolumeHoraire(60);
		Candidature candidature = new Candidature();
		CandidatureController  candidatureController = new CandidatureController(em);
		candidatureController.insertCandidature("li", "huajuan", 12.14, "231875");
		candidature.setNom("xu");
		candidature.setPrenom("tianjiao");
		candidature.setNumero("123238");
		candidature.setNoteMoyenne(12.5);
		plan2.setCandidature(candidature);
		
		em.getTransaction().begin();
		em.persist(candidature);
		em.persist(plan);
		em.persist(plan2);
		em.getTransaction().commit();
		List<Plan> plans = new ArrayList<Plan>();
		plans.add(plan);
		plans.add(plan2);
		candidature.setPlan(plans);
	      for(Plan plan3 : candidature.getPlan()){
	            Plan value=plan3;
	            System.out.print(value.getNom() + " ");
	        }
		PlanDao planDao = new PlanDao(em);
		List<Plan> results = planDao.selectAll();
		for(Plan plan3 : results){
            Plan value=plan3;
            System.out.println(value.getNom() + " " +value.getCredits() + " ");
        }
		
		List<Plan> plans3 = planDao.selectByNom("c++");
		for(Plan plan3 : plans3){
            Plan value=plan3;
            System.out.println(value.getNom() + " " +value.getCredits() + " ");
        }
		
//		CandidatureDao candida = new CandidatureDao(em);
//		List<Candidature> cans = candida.selectAll();
//		for(Candidature can : cans ){
//			System.out.println(can.getNom() + " " + can.getPrenom() +" " +can.getNoteMoyenne()+ " ");
//			
//		}
//		
		PlanController planController = new PlanController(em);
		planController.insertPlan("BaseDeDonnee", "perfect", 40, candidature);
		System.out.println("insert success!");
		List<Plan> planc = planController.selectAll();
		
//		List<Candidature> candidatures = new ArrayList<Candidature>();
//		candidatures.add(candidature);
//		candidatures.add(candidature2);
		BourseController bourseController = new BourseController(em);
		bourseController.insertBourse("France", 24);
		bourseController.insertBourse("Espagne", 16);
		bourseController.insertBourse("Finlande", 8);
		List<Bourse> bourses = bourseController.selectAll();
		
		Bourse bourse = bourseController.selectByDestination("France");
		
		DemanderController demanderController = new DemanderController(em);
		demanderController.insertDemander(13.5, bourse, candidature);
		
		EnseignantController enseignantController = new EnseignantController(em);
		enseignantController.insertEnseignant("ANNA", "ANNA", "LOCAL");
		enseignantController.insertEnseignant("nana", "lee", "Ecole");
		List<Enseignant> enseignants = enseignantController.selectAll();
		for(Enseignant ensei:enseignants){
			System.out.println(ensei.getNom()+" "+ensei.getPrenom()+" "+ensei.getIsLocalOrEcole());
		}
		
		Enseignant enseignant= enseignantController.selectByNom("nana");
		Enseignant enseignant1= enseignantController.selectByNom("ANNA");
		ScoreController scoreController = new ScoreController(em);
		scoreController.insertScore(17, candidature, enseignant);
		scoreController.insertScore(14, candidature, enseignant1);
		scoreController.listNote(2);
		
		double sumlocalecole = scoreController.getSumLocalEcole(2);
		System.out.println(sumlocalecole);
		
		double noteMoyenne = candidatureController.getNoteMoyenne(2);
		System.out.println("noteMoyenne :"+noteMoyenne);
		
		double noteFinale = (sumlocalecole + noteMoyenne)/3;
		System.out.println("sumnote :"+noteFinale);
		
		double sumNotes = scoreController.getSumScore(2);
		System.out.println("sumScore :"+sumNotes);
		
		UserController userController = new UserController(em);
		userController.insert("lihuajuan", "123");
		userController.insert("xutianjiao", "123");
		userController.insert("erasmus", "123456");
		
	}
	
	

}
