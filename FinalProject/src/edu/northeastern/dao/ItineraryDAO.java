package edu.northeastern.dao;

import java.sql.SQLException;

import edu.northeastern.dbObject.DBConnectionUtil;
import edu.northeastern.models.Location;

public class ItineraryDAO {
	
	public void insertNewItinerary(Location origin, Location destination,double totalCost) throws SQLException {
		String insertQuery = "Insert into Travel values('"+origin+"','"+destination+"','"+totalCost+"')";
		DBConnectionUtil dbConnectionUtil =  new DBConnectionUtil();
		dbConnectionUtil.queryOperations(insertQuery);

}

}