package application;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import edu.northeastern.models.BusTicket;
import edu.northeastern.models.Itinerary;
import edu.northeastern.models.TrainTickets;
import edu.northeastern.models.TravelTickets;
import edu.northeastern.tableModels.ItineraryTable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class ConfirmationPageController implements Initializable{
    @FXML
    private TableColumn<ItineraryTable, String> arrivCol;

    @FXML
    private TableColumn<ItineraryTable, Double> costCol;

    @FXML
    private TableColumn<ItineraryTable, String> departCol;

    @FXML
    private TableColumn<ItineraryTable, String> fromCol;

    @FXML
    private Text fromDate;

    @FXML
    private Text fromText;

    @FXML
    private TableView<ItineraryTable> itineraryTable;

    @FXML
    private TableColumn<ItineraryTable, String> toCol;

    @FXML
    private Text toDate;

    @FXML
    private Text toText;

    @FXML
    private Text totalCost;

    @FXML
    private TableColumn<ItineraryTable, String> typeCol;
	
	Itinerary itinerary;
	ArrayList<TravelTickets> routes;
	
	public ConfirmationPageController(Itinerary itinerary, ArrayList<TravelTickets> routes) {
		this.routes=routes;
		this.itinerary=itinerary;
	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fromText.setText(itinerary.getOrigin().getLocationName());
		toText.setText(itinerary.getDestination().getLocationName());
		fromDate.setText(this.routes.get(0).getDepartureTime().toString());
		toDate.setText(this.routes.get(this.routes.size()-1).getArrivalTime().toString());
		
		arrivCol.setCellValueFactory(new PropertyValueFactory<>("arrival"));
		costCol.setCellValueFactory(new PropertyValueFactory<>("cost"));
		departCol.setCellValueFactory(new PropertyValueFactory<>("departure"));
		arrivCol.setCellValueFactory(new PropertyValueFactory<>("arrival"));
		fromCol.setCellValueFactory(new PropertyValueFactory<>("from"));
		toCol.setCellValueFactory(new PropertyValueFactory<>("to"));
		typeCol.setCellValueFactory(new PropertyValueFactory<>("travelType"));
			
		for(TravelTickets ticket:this.routes) {
			ItineraryTable itinerary = new ItineraryTable();
			itinerary.setFrom(ticket.getFromLocation().getLocationName());
			itinerary.setTo(ticket.getToLocation().getLocationName());
			itinerary.setDeparture(ticket.getDepartureTime().toString());
			itinerary.setArrival(ticket.getArrivalTime().toString());
			itinerary.setCost(ticket.getCost());
			if(ticket instanceof BusTicket)
				itinerary.setType("Bus");
			else if(ticket instanceof TrainTickets)
				itinerary.setType("Train");
			else
				itinerary.setType("Flight");
			itineraryTable.getItems().add(itinerary);
		}
		
	}

}
