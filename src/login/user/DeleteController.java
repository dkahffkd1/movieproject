package login.user;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class DeleteController implements Initializable{
	@FXML public TextField delId,delPwd,delEmail;
	Parent root;
	ModifyService ms;
	String path;
	public void setRoot(Parent root) {
		this.root = root;
	}
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new ModifyImpl();
	}
	public void btnDel(String id, String pwd, String email) {
		ms.delId(delId.getText(), delPwd.getText(), delEmail.getText());
		int result = 0;
		
		if(result ==0) {
			CommonService.myAlert("탈퇴 되었습니다.");
		}else {
			CommonService.myAlert("입력정보가 맞지 않습니다.");
		}
		ms.btnDel(result);
	}
	
}
