package com.polytech.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.polytech.dao.EnseignantDao;
import com.polytech.model.Enseignant;

public class EnseignantController {
	private EntityManager em;

	public EnseignantController(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void insertEnseignant(String nom,String prenom,String isLocalOrEcole){
		Enseignant enseignant = new Enseignant();
		enseignant.setNom(nom);
		enseignant.setPrenom(prenom);
		enseignant.setIsLocalOrEcole(isLocalOrEcole);
		EnseignantDao enseignantDao = new EnseignantDao(em);
		enseignantDao.insertEnseignant(enseignant);
	}
	
	public List<Enseignant> selectAll(){
		EnseignantDao enseignantDao = new EnseignantDao(em);
		List<Enseignant> results = enseignantDao.selectAll();
		return results;
	}
	
	public Enseignant selectByNom(String nom){
		EnseignantDao enseignantDao = new EnseignantDao(em);
		Enseignant result = enseignantDao.selectByNom(nom);
		return result;
	}
	

}
