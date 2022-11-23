package edu.northeastern.models;

public class Flight extends Travel {
	
	  private String flightNo;
	  private String airline;
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	  
}
