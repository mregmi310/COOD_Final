package application;
	

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import edu.northeastern.dao.CustomerDAO;
import edu.northeastern.dao.LocationDAO;
import edu.northeastern.dao.ManagerDAO;
import edu.northeastern.dbObject.DBConnectionUtil;
import edu.northeastern.models.Customer;
import edu.northeastern.models.Itinerary;
import edu.northeastern.models.Location;
import edu.northeastern.models.Manager;
import edu.northeastern.models.TravelTickets;
import edu.northeastern.service.BookingService;
import edu.northeastern.service.CustomerService;
import edu.northeastern.service.ManagerService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application{
	private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception{
    	stg=primaryStage;
    	SplashController splashController = new SplashController();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SplashPage.fxml"));
		fxmlLoader.setController(splashController);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    public void changeScene(String fxml, Object controller) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
		fxmlLoader.setController(controller);
		Parent root = fxmlLoader.load();
        stg.getScene().setRoot(root);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
