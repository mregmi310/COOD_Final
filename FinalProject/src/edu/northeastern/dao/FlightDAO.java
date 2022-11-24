package edu.northeastern.dao;

import java.sql.SQLException;

import edu.northeastern.dbObject.DBConnectionUtil;

public class FlightDAO {
	
	public void insertNewCustomer(String flightNo, String airline) throws SQLException {
		String insertQuery = "Insert into Customer values('"+flightNo+"','"+airline+"')";
		DBConnectionUtil dbConnectionUtil =  new DBConnectionUtil();
		dbConnectionUtil.queryOperations(insertQuery);

}
	
	}