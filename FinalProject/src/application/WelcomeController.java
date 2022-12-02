package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import edu.northeastern.dao.LocationDAO;
import edu.northeastern.models.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;

public class WelcomeController implements Initializable{
	
	Customer customer;

    @FXML
    private Button button1;

    @FXML
    private Text fName;

    @FXML
    private Text lName;
    
    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<String> fromCombo;
    
    @FXML
    private Button search;

    @FXML
    private ComboBox<String> toCombo;

    @FXML
    void userLogIn(ActionEvent event) {

    }
    
    

    public WelcomeController(Customer customer) {
    	this.customer=customer;
    }
    
    private void updateTexts() {
    	fName.setText(customer.getFirstName());
		lName.setText(customer.getLastName());
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
	}

}


