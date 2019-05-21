package com.polytech.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.polytech.model.Bourse;
import com.polytech.model.Plan;

public class BourseDao {
	private EntityManager em;
	
	
	
	public BourseDao(EntityManager em) {
		super();
		this.em = em;
	}

	public void insertBourse(Bourse bourse) {
		em.getTransaction().begin();
		em.persist(bourse);
		em.getTransaction().commit();
	}
	
	public List<Bourse> selectAll() {
		String sql = "select bourse from Bourse bourse";
		List<Bourse> results = em.createQuery(sql, Bourse.class).getResultList();; 
		return results;
	}
	
	public Bourse selectByDestination(String destination){
		String sql = "select bourse from Bourse bourse where bourse.destination like :destination";
		TypedQuery<Bourse> query = em.createQuery(sql, Bourse.class);
		query.setParameter("destination", "%" + destination + "%");
		Bourse bourse = query.getSingleResult();
		return bourse;
	}

}
