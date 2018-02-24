package com.csquare.common;

public class SQLQueries {
	public static final String getUserQ = "SELECT email, password, firstname, lastname FROM users WHERE email=?;";

	public static final String getAllUsersQ = "SELECT id, firstname, lastname, email, password FROM users;";

	public static final String createUSERSTableQ = "CREATE TABLE IF NOT EXISTS users ("
			+ "id INT NOT NULL AUTO_INCREMENT," + "firstname VARCHAR(222) NOT NULL," + "lastname VARCHAR(222) NOT NULL,"
			+ "email VARCHAR(222) NOT NULL," + "password VARCHAR(222) NOT NULL,"
			+ "CONSTRAINT users_pk PRIMARY KEY (id)" + ");";

	public static final String signUpUserQ = "INSERT INTO " + "users(email, password, firstname, lastname) "
			+ "VALUES (?,?,?,?);";

	public static final String dropUsersTable = "DROP TABLE users;";

}
