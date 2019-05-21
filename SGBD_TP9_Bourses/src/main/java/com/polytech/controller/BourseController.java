package com.polytech.controller;

import java.util.List;

import javax.persistence.EntityManager;
import com.polytech.dao.BourseDao;
import com.polytech.model.Bourse;


public class BourseController {
	private EntityManager em;

	public BourseController(EntityManager em) {
		super();
		this.em = em;
	}

	public void insertBourse(String destination, int numbrePoste) {
		Bourse bourse = new Bourse();
		bourse.setDestination(destination);
		bourse.setNumbrePoste(numbrePoste);
		BourseDao bourseDao = new BourseDao(em);
		bourseDao.insertBourse(bourse);
	}
	
	public List<Bourse> selectAll(){
		BourseDao bourseDao = new BourseDao(em);
		List<Bourse> bourses = bourseDao.selectAll();
		return bourses;
	}
	
	public Bourse selectByDestination(String destination){
		BourseDao bourseDao = new BourseDao(em);
		Bourse bourse = bourseDao.selectByDestination(destination);
		return bourse;
	}


}
