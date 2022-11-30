package application;


import java.net.URL;
import java.util.ResourceBundle;

import edu.northeastern.models.Itinerary;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class ConfirmationPageController implements Initializable{
	@FXML
	private Text fromText, toText, toDate, fromDate;
	
	Itinerary itinerary;
	
	public ConfirmationPageController(Itinerary itinerary) {
		this.itinerary=itinerary;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fromText.setText(itinerary.getOrigin().getLocationName());
		toText.setText(itinerary.getDestination().getLocationName());
	}

}
