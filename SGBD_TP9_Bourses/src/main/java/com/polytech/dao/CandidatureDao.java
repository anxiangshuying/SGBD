package com.polytech.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import com.polytech.model.Candidature;

public class CandidatureDao {
	private EntityManager em;

	
	public CandidatureDao(EntityManager em) {
		super();
		this.em = em;
	}


	public void insertCandidature(Candidature candidature){
		em.getTransaction().begin();
		em.persist(candidature);
		em.getTransaction().commit();
	}
	
	public List<Candidature> selectAll() {
		String sql = "select candidature from Candidature candidature";
		TypedQuery<Candidature> query = em.createQuery(sql, Candidature.class);
		List<Candidature> results = query.getResultList();
		return results;
	}
	
	public double getNoteMoyenne(int candidature_id){
		double noteMoyenne = 0d;
		String sql = "select candidature from  Candidature candidature where candidature.id = :candidature_id ";
		TypedQuery<Candidature> query = em.createQuery(sql, Candidature.class);
		query.setParameter("candidature_id", candidature_id);
		noteMoyenne = query.getSingleResult().getNoteMoyenne();
		return noteMoyenne;
	}
	
	public Candidature selectByNom(String nom){
		String sql = "select candidature from Candidature candidature where candidature.nom = :nom";
		Query query = em.createQuery(sql);
		query.setParameter("nom", nom);
		Candidature candidature = null;
		try{
			candidature = (Candidature) query.getSingleResult();
		} catch (NoResultException e){
			candidature = null;
		}
		return candidature;
	}
	
	public Candidature selectById(int id){
		String sql = "select candidature from Candidature candidature where candidature.id = :id";
		Query query = em.createQuery(sql);
		query.setParameter("id", id);
		Candidature candidature = null;
		try{
			candidature = (Candidature) query.getSingleResult();
		} catch (NoResultException e){
			candidature = null;
		}
		return candidature;
	}
}
