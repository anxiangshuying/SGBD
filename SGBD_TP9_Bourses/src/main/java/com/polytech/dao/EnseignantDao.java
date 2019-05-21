package com.polytech.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.polytech.model.Enseignant;

public class EnseignantDao {
	private EntityManager em;

	public EnseignantDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void insertEnseignant(Enseignant enseignant){
		em.getTransaction().begin();
		em.persist(enseignant);
		em.getTransaction().commit();
	}
	
	public List<Enseignant> selectAll() {
		String sql = "select enseignant from Enseignant enseignant";
		List<Enseignant> results = em.createQuery(sql, Enseignant.class).getResultList();; 
		return results;
	}
	
	public Enseignant selectByNom(String nom){
		String sql = "select enseignant from Enseignant enseignant where enseignant.nom = :nom";
		TypedQuery<Enseignant> query = em.createQuery(sql, Enseignant.class);
		query.setParameter("nom", nom);
		Enseignant enseignant = query.getSingleResult();
		return enseignant;
	}

}
