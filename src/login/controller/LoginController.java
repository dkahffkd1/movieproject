package login.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import login.service.LoginService;
import login.service.LoginServiceImpl;
import login.url.URLService;

public class LoginController implements Initializable{
	@FXML public TextField fxId;
	@FXML public TextField fxPwd;
	@FXML public CheckBox chkId;
	@FXML public ImageView imageView;
	Parent root;
	LoginService ls;
	String path;
	public void setRoot(Parent root) {
		this.root = root;
	}
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls = new LoginServiceImpl();
		
	}
	public void loginFunc() {
		ls.loginFunc(fxId, fxPwd, chkId);
	}
	public void registerFunc() {
		ls.registerFunc(root);
	}
	public void idfindFunc() {
		
		ls.idfindFunc(root);
	}
	public void pwdfindFunc() {
		ls.pwdfindFunc(root);
	}
	public void imageView() {
		
	}
	
}
