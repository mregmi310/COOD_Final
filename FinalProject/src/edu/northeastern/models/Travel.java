package edu.northeastern.models;

import java.util.Date;

public class Travel {
	
	private String reservationId;
	private Date reservationTime;
	private double cost;
	private Location toLocation;
	private Location fromLocation;
	private Date departureTime;
	private Date arrivalTime;
	
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getReservationId() {
		return reservationId;
	}
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}
	public Date getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(Date reservationTime) {
		this.reservationTime = reservationTime;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Location getToLocation() {
		return toLocation;
	}
	public void setToLocation(Location toLocation) {
		this.toLocation = toLocation;
	}
	public Location getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(Location fromLocation) {
		this.fromLocation = fromLocation;
	}
	

}
