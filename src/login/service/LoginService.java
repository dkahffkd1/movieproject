package login.service;

import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public interface LoginService {
	public void loginFunc(TextField fxId, TextField fxPwd, CheckBox chkId);
	public void registerFunc(Parent root);
	public void registerFunc();
	public void idfindFunc(Parent root);
	public void pwdfincFunc(Parent root);

}
