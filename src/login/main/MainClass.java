package login.main;


import java.net.URL;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.controller.LoginController;
import login.dao.LoginDAO;

public class MainClass extends Application{

	public void start(Stage arg0) throws Exception {

		URL url = new URL("file:/"+(Paths.get("").toAbsolutePath().toString())+"/bin/login/fxml/LoginFx.fxml");
		FXMLLoader loader = new FXMLLoader(url);
		
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		
		LoginController ctrl = loader.getController();
		
		ctrl.setRoot(root);
		
		arg0.setScene(scene);
		
		arg0.show();
	}
	public static void main(String[] args) {

		launch(args);
		
	}
}
