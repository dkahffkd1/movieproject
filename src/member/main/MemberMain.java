package member.main;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.url.URLService;
import member.controller.MemberController;

public class MemberMain{

	public void viewFx(Parent root) {
		Stage memberStage= (Stage)root.getScene().getWindow();
		try {
		URL url = new URL(URLService.fxPath+"member/fxml/memberFx.fxml");
		FXMLLoader loader = new FXMLLoader(url);
		root = loader.load();
			MemberController ctrl = loader.getController();
			
			ctrl.setRoot(root);

		} catch (Exception e) {
			e.printStackTrace();
		}	
		Scene scene = new Scene(root);
		memberStage.setScene(scene);
		memberStage.show();
	}
}
