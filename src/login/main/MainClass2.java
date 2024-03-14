package login.main;

import java.net.URL;
import java.nio.file.Paths;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.controller.LoginController;

public class MainClass2 {
	public void viewFx(Parent root) {
		Stage stage = (Stage)root.getScene().getWindow();

		try {
			URL url;
			url = new URL("file:/"+(Paths.get("").toAbsolutePath().toString())+"/bin/login/fxml/LoginFx.fxml");
			FXMLLoader loader = new FXMLLoader(url);
			
			root = loader.load();
			LoginController ctrl = loader.getController();
			ctrl.setRoot(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		

	}
}
