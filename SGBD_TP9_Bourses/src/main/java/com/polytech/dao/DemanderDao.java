package com.polytech.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.polytech.model.Demander;
import com.polytech.model.Enseignant;

public class DemanderDao {
	private EntityManager em;

	public DemanderDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void insertDemander(Demander demander){
		em.getTransaction().begin();
		em.persist(demander);
		em.getTransaction().commit();
	}
	
//	public List<Candidature> selectCandidature(){
//		String sql = "select message from Message message where message.user.id = :userId";
//		TypedQuery<Message> query = em.createQuery(sql, Message.class);
//		query.setParameter("userId", userId);
//		List<Message> results = query.getResultList();
//		return results;
//	}

}
