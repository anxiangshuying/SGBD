package com.polytech.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.polytech.model.Plan;

public class PlanDao {
	private EntityManager em;

	public PlanDao(EntityManager em) {
		super();
		this.em = em;
	}
	public void insertPlan(Plan plan){
		em.getTransaction().begin();
		em.persist(plan);
		em.getTransaction().commit();
	}
	
	public List<Plan> selectAll() {
		String sql = "select plan from Plan plan";
		List<Plan> results = em.createQuery(sql, Plan.class).getResultList();; 
		return results;
	}
	
	public List<Plan> selectByNom(String nom) {
		String sql = "select plan from Plan plan where plan.nom like :nom";
		TypedQuery<Plan> query = em.createQuery(sql, Plan.class);
		query.setParameter("nom", "%" + nom + "%");
		List<Plan> results = query.getResultList();
		return results;
	}

}
