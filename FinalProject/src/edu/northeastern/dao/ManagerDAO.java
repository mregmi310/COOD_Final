package edu.northeastern.dao;

import java.sql.SQLException;

import edu.northeastern.dbObject.DBConnectionUtil;

public class ManagerDAO {
	
	public void insertNewManager(String lastName, String firstName, String username, String password, int age) throws SQLException {
		String insertQuery = "Insert into Manager values('"+lastName+"','"+firstName+"','"+username+"','"+password+"','"+age+"')";
		DBConnectionUtil dbConnectionUtil =  new DBConnectionUtil();
		dbConnectionUtil.queryOperations(insertQuery);
		// hello world
	}

}