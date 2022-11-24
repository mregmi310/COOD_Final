package edu.northeastern.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import edu.northeastern.dbObject.DBConnectionUtil;
import edu.northeastern.models.Bus;
import edu.northeastern.models.Flight;
import edu.northeastern.models.Location;
import edu.northeastern.models.Train;
import edu.northeastern.models.TravelBooked;

public class TravelDAO {
	
	public void insertNewTravel(String reservation, Date reservationTime, double cost, Location toLocation, Location fromLocation,Date departureTime, Date arrivalTime, double flightNo, String airline, double busNo, double trainNo) throws SQLException {
		String insertQuery = "Insert into Travel values('"+reservation+"','"+reservationTime+"','"+flightNo+"','"+airline+"','"+busNo+"','"+trainNo+"','"+cost+"','"+fromLocation+"','"+toLocation+"' ,'"+ departureTime+"' ,'"+arrivalTime+"')";
		DBConnectionUtil dbConnectionUtil =  new DBConnectionUtil();
		dbConnectionUtil.queryOperations(insertQuery);
	}
	
	public TravelBooked getTravel(String travelID) throws SQLException {
		String getTravelQuery = "SELECT * from Travel where TravelID='"+travelID+"'";
		DBConnectionUtil dbConnectionUtil =  new DBConnectionUtil();
		ResultSet result=dbConnectionUtil.selectOperations(getTravelQuery);
		result.next();
		String reservationId = result.getString("ReservationID");
		Date reservationDate = result.getDate("ReservationTime");
		String flightNo = result.getString("FlightNo");
		String airline = result.getString("Airline");
		String busNo = result.getString("BusNo");
		String trainNo = result.getString("TrainNo");
		double cost = result.getDouble("TravelCost");
		String from = result.getString("FromLocation");
		String to = result.getString("ToLocation");
		Date departureTime = result.getDate("DepartureTime");
		Date arrivalTime = result.getDate("ArrivalTime");
		LocationDAO locationDAO = new LocationDAO();
		Location fromLocation = locationDAO.getLocation(from);
		Location toLocation = locationDAO.getLocation(to);
		TravelBooked travel = new TravelBooked(reservationId, reservationDate,cost,fromLocation,toLocation,departureTime,arrivalTime);
		if(flightNo!=null) {
			Flight flight = (Flight)travel;
			flight.setAirline(airline);
			flight.setFlightNo(flightNo);
			return flight;
		}
		else if(busNo!=null) {
			Bus bus = (Bus)travel;
			bus.setBusNo(busNo);
			return bus;
		}
		else if(trainNo!=null) {
			Train train = (Train)travel;
			train.setTrainNo(trainNo);
			return train;
		}
		return travel;
	}
}
