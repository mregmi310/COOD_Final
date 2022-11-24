package edu.northeastern.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.northeastern.dbObject.DBConnectionUtil;
import edu.northeastern.models.Itinerary;
import edu.northeastern.models.Location;

public class ItineraryDAO {
	
	public void insertNewItinerary(String origin, String destination,double totalCost) throws SQLException {
		String insertQuery = "Insert into Travel values('"+origin+"','"+destination+"','"+totalCost+"')";
		DBConnectionUtil dbConnectionUtil =  new DBConnectionUtil();
		dbConnectionUtil.queryOperations(insertQuery);
	}
	
	public Itinerary getItinerary(String itinearyID) throws SQLException {
		String getItineraryQuery = "Select * from Itinerary where ItinearyID = '"+itinearyID+"'";
		DBConnectionUtil dbConnectionUtil = new DBConnectionUtil();
		ResultSet results = dbConnectionUtil.selectOperations(getItineraryQuery);
		results.next();
		String origin = results.getString("Origin");
		String destination = results.getString("Destination");
		LocationDAO locationDAO = new LocationDAO();
		Location originLocation = locationDAO.getLocation(origin);
		Location destLocation = locationDAO.getLocation(destination);
		Itinerary itinerary = new Itinerary(itinearyID, originLocation, destLocation);
		return itinerary;
	}
	
	public ArrayList<String> getRoutes(String itinearyID)throws SQLException{
		String routesQuery = "Select * from ItinerartTravelRel where ItineraryID ='"+ itinearyID+"'";
		DBConnectionUtil dbConnectionUtil =  new DBConnectionUtil();	
		ResultSet resultSet = dbConnectionUtil.selectOperations(routesQuery);
		ArrayList<String> routesList = new ArrayList<>();
		while(resultSet.next()) {
			routesList.add(resultSet.getString("TravelID"));
		}
		return routesList;
	}

}