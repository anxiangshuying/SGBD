package com.polytech.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.polytech.dao.ScoreDao;
import com.polytech.model.Candidature;
import com.polytech.model.Enseignant;
import com.polytech.model.Score;

public class ScoreController {
	private EntityManager em;

	public ScoreController(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void insertScore(double note,Candidature candidature,Enseignant enseignant){
		Score score = new Score();
		score.setNote(note);
		score.setCandidature1(candidature);
		score.setEnseignant1(enseignant);
		ScoreDao scoreDao = new ScoreDao(em);
		scoreDao.insertScore(score);
	}
	
	public void listNote(int candidature1_id){
		ScoreDao scoreDao = new ScoreDao(em);
		scoreDao.listNote(candidature1_id);
	}
	
	public List<Double> getNotes(int candidature1_id){
		ScoreDao scoreDao = new ScoreDao(em);
		List<Double> notes = scoreDao.getNotes(candidature1_id);
		return notes;
	}
	
	public double getSumLocalEcole(int candidature1_id){
		ScoreDao scoreDao = new ScoreDao(em);
		double sumLocalEcole = scoreDao.getSumLocalEcole(candidature1_id);
		return sumLocalEcole;
		
	}
	
	public double getSumScore(int candidature1_id){
		ScoreDao scoreDao = new ScoreDao(em);
		double sum = scoreDao.getSumScore(candidature1_id);
		return sum;
	}


}
