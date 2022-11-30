package application;
	

import java.io.IOException;
import java.sql.SQLException;


import edu.northeastern.dao.LocationDAO;
import edu.northeastern.models.Itinerary;
import edu.northeastern.models.Location;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application{
	@Override
	public void start(Stage primaryStage) throws IOException, SQLException {
		LocationDAO locationDAO = new LocationDAO();
		Location l1 = locationDAO.getLocation("Boston");
		Location l2 = locationDAO.getLocation("Hyderabad");
		Itinerary itinerary = new Itinerary("1234", l1, l2);
		ConfirmationPageController confirmationPageController = new ConfirmationPageController(itinerary);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ConfirmationPage.fxml"));
		fxmlLoader.setController(confirmationPageController);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World");
		launch(args);
	}
}
