package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SplashController {

    @FXML
    private Button button;

    @FXML
    private Label wrongLogIn;

    @FXML
    void goToLogin(ActionEvent event) throws IOException {
    	Main m= new Main();
    	LoginController loginController = new LoginController();
    	m.changeScene("Login.fxml",loginController);
//    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
//		fxmlLoader.setController(fxmlLoader);
//		Parent root = fxmlLoader.load();
//		Scene scene = new Scene(root,600,400);
//		Stage window = (Stage) button.getScene().getWindow();
//		window.setScene(new Scene(root, 750, 500));
		
    }

}
