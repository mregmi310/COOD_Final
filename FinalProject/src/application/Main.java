package application;
	

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
	
	public static void main(String[] args) throws Exception {
//		ManagerService ms = new ManagerService();
//		Manager manager = ms.login("rayna", "dallu@123");
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a", Locale.ENGLISH);
//		String dateInString1 = "11-Dec-2022 08:30:00 AM";
//		String dateInString2 = "12-Dec-2022 09:30:00 AM";
//		String dateInString3 = "13-Dec-2022 10:30:00 AM";
//		String dateInString4 = "14-Dec-2022 09:30:00 AM";
//		Date date1 = (Date) formatter.parse(dateInString1);
//		Date date2 = (Date) formatter.parse(dateInString2);
//		Date date3 = (Date) formatter.parse(dateInString3);
//		Date date4 = (Date) formatter.parse(dateInString4);
////		ms.createTicket(manager, "Boston", "Mumbai", 20, "NY-200","Blue" , 500, date1, date2, "Blue123");
//		ms.createTicket(manager, "Mumbai", "Seattle", 20, "NY-200","Blue" , 500, date1, date2, "Blue12345");
//		ms.createTicket(manager, "Seattle", "Hyderabad", 20, "NY-200","Blue" , 500, date3, date4, "Blue12346");
		
//		CustomerService cs = new CustomerService();
//		Customer c = cs.login("mridulregmi","dallu@123");
//		BookingService bs = new BookingService();
//		LocationDAO locationDAO = new LocationDAO();
//		Location l1 = locationDAO.getLocation("Boston");
//		Location l2 = locationDAO.getLocation("Hyderabad");
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a", Locale.ENGLISH);
//		String dateInString1 = "6-Dec-2022 03:30:00 AM";
//		Date date1 = (Date) formatter.parse(dateInString1);
//		ArrayList<ArrayList<TravelTickets>> routes = bs.findRoutes(l1, l2, date1);
//		for(ArrayList<TravelTickets> route:routes) {
//			for(TravelTickets ticket: route) {
//				System.out.println(ticket.getFromLocation().getLocationName()+" "+ticket.getToLocation().getLocationName());
//			}
//			System.out.println();
//		}
		
		CustomerService cs = new CustomerService();
		Customer c = cs.login("mridulregmi","dallu@123");
		BookingService bs = new BookingService();
		LocationDAO locationDAO = new LocationDAO();
		Location l1 = locationDAO.getLocation("Boston");
		Location l2 = locationDAO.getLocation("Hyderabad");
		Itinerary itinerary = new Itinerary("1234", l1, l2);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a", Locale.ENGLISH);
		String dateInString1 = "6-Dec-2022 03:30:00 AM";
		Date date1 = (Date) formatter.parse(dateInString1);
		ArrayList<ArrayList<TravelTickets>> routes = bs.findRoutes(l1, l2, date1);
		for(ArrayList<TravelTickets> tickets: routes) {
			System.out.println("Route 1:");
			for(TravelTickets ticket: tickets) {
				System.out.println(ticket.getFromLocation().getLocationName()+" "+ticket.getToLocation().getLocationName());
			}
		}
//		bs.bookTickets(routes.get(0), c, itinerary);
		
		
		
		
		
		
		
		
		
		
	}
}
