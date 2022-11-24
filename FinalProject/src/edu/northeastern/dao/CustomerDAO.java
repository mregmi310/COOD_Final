package edu.northeastern.dao;

import java.sql.SQLException;

import edu.northeastern.dbObject.DBConnectionUtil;

public class CustomerDAO {
	
	public void insertNewCustomer(String lastName, String firstName, String username, String password, double balance, int age) throws SQLException {
		String insertQuery = "Insert into Customer values('"+lastName+"','"+firstName+"','"+username+"','"+password+"','"+age+"','"+balance+"')";
		DBConnectionUtil dbConnectionUtil =  new DBConnectionUtil();
		dbConnectionUtil.queryOperations(insertQuery);
	}

}


