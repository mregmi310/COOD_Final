package edu.northeastern.dao;

import java.sql.SQLException;
import java.util.Date;

import edu.northeastern.dbObject.DBConnectionUtil;
import edu.northeastern.models.Location;

public class TravelDAO {
	
	public void insertNewTravel(String reservation, Date reservationTime, double cost, Location toLocation, Location fromLocation,Date departureTime, Date arrivalTime, double flightNo, String airline, double busNo, double trainNo) throws SQLException {
		String insertQuery = "Insert into Travel values('"+reservation+"','"+reservationTime+"','"+flightNo+"','"+airline+"','"+busNo+"','"+trainNo+"','"+cost+"','"+fromLocation+"','"+toLocation+"' ,'"+ departureTime+"' ,'"+arrivalTime+"')";
		DBConnectionUtil dbConnectionUtil =  new DBConnectionUtil();
		dbConnectionUtil.queryOperations(insertQuery);
	}
}
