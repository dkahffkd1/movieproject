package member.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import member.service.MemberService;
import member.service.MemberServiceImpl;

public class MemberController implements Initializable {
	@FXML public TextField fxName, fxId;
	@FXML public PasswordField fxPwd, fxPwdChk;
	Parent root;
	MemberService ms;
	
	

	public void setRoot(Parent root) {
		ms.setRoot(root);
		this.root = root;
	}
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new MemberServiceImpl();
	}

	public void btnEnterFunc() {
		ms.btnEnterFunc();
	}
	public void btnCancelFunc() {
		ms.btnCancelFunc();
	}
	public void IdChk() {
		
		ms.IdChk(fxId.getText());
	}

}

