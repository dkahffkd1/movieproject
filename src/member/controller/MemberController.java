package member.controller;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import login.main.MainClass2;
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
		ms.PwdChk(fxPwd.getText(),fxPwdChk.getText());
		int result = ms.pwdsame();
		if(result == 0) {
			CommonService.myAlert("비밀번호가 일치합니다.");
		
		}else {
			CommonService.myAlert("비밀번호가 일치하지 않습니다.");
		}
		ms.btnEnterFunc(result);
	}	
	public void btnCancelFunc() {
		ms.btnCancelFunc();
	}
	public void IdChk() {
		ms.IdChk(fxId.getText());
		int result = ms.same();
		if (result == 0) {
			CommonService.myAlert("중복");
		}else {
			CommonService.myAlert("가능");
		}
	}
	public void back() {
		MainClass2 mc = new MainClass2();
		mc.viewFx(root);
	}
}

