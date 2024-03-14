package login.user;

import java.net.URI;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.url.URLService;

public class LoginDeleteMain {
	public void delFx(Parent root) {
		Stage delStage =(Stage)root.getScene().getWindow();
		try {
		URL url = new URL(URLService.fxPath + "modify/fxml/deleteFx.fxml");
		FXMLLoader loader = new FXMLLoader(url);
		root = loader.load();
		DeleteController ctrl = loader.getController();
		ctrl.setRoot(root);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		delStage.setScene(scene);
		delStage.show();
	}

}
