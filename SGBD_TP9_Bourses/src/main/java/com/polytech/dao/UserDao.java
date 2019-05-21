package com.polytech.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.polytech.model.User;


public class UserDao {
	private EntityManager em;

	public UserDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void insert(User user){
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
	
	public User selectByUsername(String username){
		String sql = "select user from User user where user.username = :username";
		Query query = em.createQuery(sql);
		query.setParameter("username", username);
		User user = null;
		try{
			user = (User) query.getSingleResult();
		} catch (NoResultException e){
			user = null;
		}
		
		return user;
	}
	
	public User selectById(int id){
		String sql = "select user from User user where user.id = :id";
		Query query = em.createQuery(sql);
		query.setParameter("id", id);
		User user = null;
		try{
			user = (User) query.getSingleResult();
		} catch (NoResultException e){
			user = null;
		}
		
		return user;
	}


}
