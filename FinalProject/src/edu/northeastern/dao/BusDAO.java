package edu.northeastern.dao;

import java.sql.SQLException;

import edu.northeastern.dbObject.DBConnectionUtil;

public class BusDAO {
	
	public void insertNewBus(String busNo) throws SQLException {
		String insertQuery = "Insert into Customer values('"+busNo+"')";
		DBConnectionUtil dbConnectionUtil =  new DBConnectionUtil();
		dbConnectionUtil.queryOperations(insertQuery);

}

}