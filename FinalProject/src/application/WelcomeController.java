package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import edu.northeastern.dao.LocationDAO;
import edu.northeastern.models.Customer;
import edu.northeastern.models.Location;
import edu.northeastern.models.TravelTickets;
import edu.northeastern.service.BookingService;
import edu.northeastern.tableModels.UpcomingTrips;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class WelcomeController implements Initializable{
	
	Customer customer;

	 @FXML
    private TableColumn<UpcomingTrips, String> arrCol;

    @FXML
    private Button button11;

    @FXML
    private TableColumn<UpcomingTrips, String> depCol;

    @FXML
    private Text fName;

    @FXML
    private TableColumn<UpcomingTrips, String> fromCol;

    @FXML
    private ComboBox<String> fromCombo;

    @FXML
    private Text lName;
    
    @FXML
    private DatePicker dateSelector;

    @FXML
    private TableColumn<UpcomingTrips, String> statCol;

    @FXML
    private TableColumn<UpcomingTrips, String> toCol;

    @FXML
    private ComboBox<String> toCombo;

    @FXML
    private TableView<UpcomingTrips> upcomingTripsTable;

    @FXML
    void searchButton(ActionEvent event) throws IOException, SQLException {
    	Main main = new Main();
    	BookingService bs = new BookingService();
    	String to = toCombo.getValue();
    	String from = fromCombo.getValue();
    	LocalDate departDate = dateSelector.getValue();
    	LocationDAO locationDAO = new LocationDAO();
    	Location toLocation = locationDAO.getLocation(to);
    	Location fromLocation = locationDAO.getLocation(from);
    	ZoneId defaultZoneId = ZoneId.systemDefault();
    	ArrayList<ArrayList<TravelTickets>> routes=bs.findRoutes(toLocation, fromLocation, Date.from(departDate.atStartOfDay(defaultZoneId).toInstant()));
    	SearchResultsController serResultsController = new SearchResultsController(routes);
    	main.changeScene("SearchResult.fxml", serResultsController);
    }

    

    public WelcomeController(Customer customer) {
    	this.customer=customer;
    }
    
    private void updateTexts() {
    	fName.setText(customer.getFirstName());
		lName.setText(customer.getLastName());
    }
    
    private void updateTable() {
    	
    	arrCol.setCellValueFactory(new PropertyValueFactory<>("arrive"));
    	depCol.setCellValueFactory(new PropertyValueFactory<>("depart"));
    	fromCol.setCellValueFactory(new PropertyValueFactory<>("from"));
    	toCol.setCellValueFactory(new PropertyValueFactory<>("to"));
    	statCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    	upcomingTripsTable.getItems().add(null);
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		LocationDAO locationDAO = new LocationDAO();
		try {
			ArrayList<String> locations= locationDAO.getAllLocations();
			fromCombo.getItems().addAll(locations);
			toCombo.getItems().addAll(locations);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		updateTexts();
		updateTable();
	}

}


