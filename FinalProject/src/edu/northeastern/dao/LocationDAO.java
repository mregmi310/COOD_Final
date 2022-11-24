package edu.northeastern.dao;

import java.sql.SQLException;

import edu.northeastern.dbObject.DBConnectionUtil;

public class LocationDAO {
	
	public void insertNewLocation(String locationName) throws SQLException {
		String insertQuery = "Insert into Location values('"+locationName+"')";
		DBConnectionUtil dbConnectionUtil =  new DBConnectionUtil();
		dbConnectionUtil.queryOperations(insertQuery);

}

}