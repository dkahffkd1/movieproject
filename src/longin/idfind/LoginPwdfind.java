package longin.idfind;

import java.net.URL;

import idfind.controller.IdfindController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.url.URLService;

public class LoginPwdfind {
	public void findPwdFx(Parent root) {
		Stage pwdfxstage = (Stage)root.getScene().getWindow();
		try {
			URL url = new URL(URLService.fxPath+"idfind/fxml/pwdfindfx.fxml");
			FXMLLoader loader = new FXMLLoader(url);
			root = loader.load();
			IdfindController ctrl = loader.getController();
			ctrl.setRoot(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		pwdfxstage.setScene(scene);
		pwdfxstage.show();
	}
}
