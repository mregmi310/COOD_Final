package application;

import java.util.ArrayList;

import edu.northeastern.models.TravelTickets;

public class SearchResultsController {
	

	private ArrayList<ArrayList<TravelTickets>> routes;

	public SearchResultsController(ArrayList<ArrayList<TravelTickets>> routes) {
		this.routes = routes;
	}

}
