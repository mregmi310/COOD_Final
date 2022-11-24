package application;
	
import java.sql.SQLException;

import edu.northeastern.dao.CustomerDAO;
import edu.northeastern.dao.ManagerDAO;
import edu.northeastern.dbObject.DBConnectionUtil;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main {
//	@Override
//	public void start(Stage primaryStage) {
//		try {
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void main(String[] args) throws SQLException {
		
		ManagerDAO managerDAO = new ManagerDAO();
		managerDAO.insertNewManager("Sharma","Rayna","raynasharma","ray@123",25);
		
	}
}
