package com.polytech.controller;

import javax.persistence.EntityManager;

import com.polytech.dao.UserDao;
import com.polytech.model.User;


public class UserController {
	private EntityManager em;

	public UserController(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void insert(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		UserDao userDao = new UserDao(em);
		userDao.insert(user);
	}
	
	public boolean verifyUserPsd(String username, String psd) {
		User user = this.getUserByUsername(username);
		if (user != null && user.getPassword().equals(psd)) {
			SessionController.setActuelUserId(user.getId());
			System.out.println(SessionController.getActuelUserId());
			return true;

		} else {
			return false;
		}
	}
	
	public User getUserByUsername(String userName) {
		UserDao userDao = new UserDao(em);
		return userDao.selectByUsername(userName);
	}
	
	public User getUserById(int id) {
		UserDao userDao = new UserDao(em);
		return userDao.selectById(id);
	}

}
