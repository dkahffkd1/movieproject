package idfind.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import login.service.LoginService;
import login.service.LoginServiceImpl;
import longin.idfind.LoginIdfindImpl;

public class IdfindController implements Initializable {
	@FXML public TextField idFind;
	@FXML public TextField Findpwd;
	Parent root;
	LoginService ls;
	public void setRoot(Parent root) {
		this.root = root;
	}
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls = new LoginIdfindImpl();
	}
	public void btnFind() {
		ls.btnFind(root);
	}
	public void btnPwd() {
		ls.btnPwd(root);
		
	}

}
