package edu.northeastern.dao;

import java.sql.SQLException;

import edu.northeastern.dbObject.DBConnectionUtil;

public class PersonDAO {
	
	public void insertNewPerson(String lastName, String firstName, String username, String password, int age) throws SQLException {
		String insertQuery = "Insert into Person values('"+lastName+"','"+firstName+"','"+username+"','"+password+"','"+age+"')";
		DBConnectionUtil dbConnectionUtil =  new DBConnectionUtil();
		dbConnectionUtil.queryOperations(insertQuery);

}
}