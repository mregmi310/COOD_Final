package edu.northeastern.dao;

import java.sql.SQLException;

import edu.northeastern.dbObject.DBConnectionUtil;

public class TrainDAO {
	
	public void insertNewTrain(String trainNo) throws SQLException {
		String insertQuery = "Insert into Train values('"+trainNo+"')";
		DBConnectionUtil dbConnectionUtil =  new DBConnectionUtil();
		dbConnectionUtil.queryOperations(insertQuery);

}
