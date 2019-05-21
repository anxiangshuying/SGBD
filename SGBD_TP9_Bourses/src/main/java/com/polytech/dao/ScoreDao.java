package com.polytech.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.polytech.model.Candidature;
import com.polytech.model.Score;


public class ScoreDao {
	
	private EntityManager em;

	public ScoreDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void insertScore(Score score){
		em.getTransaction().begin();
		em.persist(score);
		em.getTransaction().commit();
	}
	
	public void listNote(int candidature1_id){
		String sql = "select score from Score score "
				+ "where score.candidature1.id = :candidature1_id ";
		TypedQuery<Score> query = em.createQuery(sql, Score.class);
		query.setParameter("candidature1_id", candidature1_id);
		List<Score> scores = query.getResultList();
		for (Score score : scores) {
			String candidaturenom = score.getCandidature1().getNom();
			double note = score.getNote();
			String nomE = score.getEnseignant1().getNom();
			String prenomE = score.getEnseignant1().getPrenom();
			String isLocalOrEcole = score.getEnseignant1().getIsLocalOrEcole();
			System.out.println(candidaturenom +" "+nomE + " " +prenomE+" "+ isLocalOrEcole+ " "+note);
			}
	} 
	
	public List<Double> getNotes(int candidature1_id){
		String sql = "select score from Score score "
				+ "where score.candidature1.id = :candidature1_id ";
		TypedQuery<Score> query = em.createQuery(sql, Score.class);
		query.setParameter("candidature1_id", candidature1_id);
		List<Score> scores = query.getResultList();
		List<Double> notes = new ArrayList<Double>();
		double sumlocalecole = 0d;
		for (Score score : scores) {
			notes.add(score.getNote());
			}
		return notes;
	} 
	
	public double getSumLocalEcole(int candidature1_id){
		String sql = "select score from Score score "
				+ "where score.candidature1.id = :candidature1_id ";
		TypedQuery<Score> query = em.createQuery(sql, Score.class);
		query.setParameter("candidature1_id", candidature1_id);
		List<Score> scores = query.getResultList();
		List<Double> notes = new ArrayList<Double>();
		double sumlocalecole = 0d;
		for (Score score : scores) {
			notes.add(score.getNote());
			}
		for(double note:notes){
			sumlocalecole +=note;
		}
		return sumlocalecole;
	}
	
	public double getSumScore(int candidature1_id){
		String sql = "select score from Score score "
				+ "where score.candidature1.id = :candidature1_id ";
		TypedQuery<Score> query = em.createQuery(sql, Score.class);
		query.setParameter("candidature1_id", candidature1_id);
		List<Score> scores = query.getResultList();
		List<Double> notes = new ArrayList<Double>();
		
		double noteMoyenne = 0d;
		String sql1 = "select candidature from  Candidature candidature where candidature.id = :candidature1_id ";
		TypedQuery<Candidature> query1 = em.createQuery(sql1, Candidature.class);
		query1.setParameter("candidature1_id", candidature1_id);
		noteMoyenne = query1.getSingleResult().getNoteMoyenne();
		
		double sumlocalecole = 0d;
		for (Score score : scores) {
			notes.add(score.getNote());
			}
		for(double note:notes){
			sumlocalecole +=note;
		}
		double sumScore = 0d;
		sumScore = (sumlocalecole+noteMoyenne)/3;
		return sumScore;
	}

}
