package com.csquare.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.csquare.common.SQLQueries;
import com.csquare.teo.User;

public class DAOImpl implements IDAO {

	Connection con = null;
	PreparedStatement stmt = null;
	Logger log= Logger.getLogger(DAOImpl.class);

	public void getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://us-cdbr-iron-east-05.cleardb.net/ad_16b8a6b77b51ef8",
					"b42fa350b510c8", "ec2df209");
		} catch (InstantiationException e) {
			log.error(e.getMessage());
		} catch (IllegalAccessException e) {
			log.error(e.getMessage());
		} catch (ClassNotFoundException e) {
			log.error(e.getMessage());
		} catch (SQLException e) {
			log.error(e.getMessage());
		} 
	}
	
	private void closeConnection() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				log.error(e.getMessage());
			}
		}
	}

	public String validateUser(User user) {

		try {
			getConnection();
			stmt = con.prepareStatement(SQLQueries.getUserQ);
			stmt.setString(1, user.getEmail());
			ResultSet rs1 = stmt.executeQuery();
			if (rs1.next()) {// get first result
				if (rs1.getString("password").equals(user.getPassword())) {
					return rs1.getString("email") + " validated successfully.";
				} else
					return " Invalid Credentials.";
			}else {
				return " Invalid Credentials.";
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}

	public String dropUsersTable() {
		try {
			getConnection();
			stmt = con.prepareStatement(SQLQueries.dropUsersTable);
			stmt.execute();
			return "users Table is dropped.";
		} catch (SQLException e) {
			log.error(e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		try {
			getConnection();
			stmt = con.prepareStatement(SQLQueries.getAllUsersQ);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getString("id"), rs.getString("email"), null, rs.getString("firstname"),
						rs.getString("lastname"));
				users.add(user);
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			closeConnection();
		}
		return users;
	}

	public String addUser(User user) {
		try {
			getConnection();
			stmt = con.prepareStatement(SQLQueries.signUpUserQ);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstname());
			stmt.setString(4, user.getLastname());
			if (stmt.executeUpdate() == 1) {
				return "Hi " + user.getFirstname() + ", Your Registration is successful.";
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}

	public String addUsersTable() {
		try {
			getConnection();
			stmt = con.prepareStatement(SQLQueries.createUSERSTableQ);
			stmt.execute();
			return "users Table is created.";
		} catch (SQLException e) {
			log.error(e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}

}
