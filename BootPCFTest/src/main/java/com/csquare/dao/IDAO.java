package com.csquare.dao;

import java.util.List;

import com.csquare.teo.User;

public interface IDAO {

	DAOImpl objDAOImpl = new DAOImpl();

	public static String validateUser(User user) {
		return objDAOImpl.validateUser(user);
	}

	public static String dropUsersTable() {
		return objDAOImpl.dropUsersTable();
	}

	public static List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return objDAOImpl.getAllUsers();
	}

	public static String addUser(User user) {
		// TODO Auto-generated method stub
		return objDAOImpl.addUser(user);
	}

	public static String addUsersTable() {
		// TODO Auto-generated method stub
		return objDAOImpl.addUsersTable();
	}

}
