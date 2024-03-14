package idfind.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import login.dto.LoginDTO;
import login.main.MainClass2;
import login.service.LoginService;
import login.service.LoginServiceImpl;
import longin.idfind.LoginIdfindImpl;
import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class IdfindController implements Initializable {
	@FXML public TextField idFind,pwdfind;
	@FXML public TextField Findpwd;
	Parent root;
	LoginService ls;
	ArrayList<MemberDTO> arr;
	MemberDAO dao;
	MemberDTO dto;
	public void setRoot(Parent root) {
		this.root = root;
	}
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls = new LoginIdfindImpl();
	}
	public void btnFind() {
		ls.btnFind(idFind.getText());
		String result = ls.idid();
		if(result.equals("b")) {
			CommonService.myAlert("없는 이메일입니다.");
		}else {
			CommonService.myAlert("회원님의 아이디는" + result);
		}
		
	}
	public void btnPwd() {
		ls.btnPwd(pwdfind.getText());
		
		String result = ls.btnfind();
		
		if(result.equals("a")) {
			CommonService.myAlert("존재하지 않습니다");
		}else {
			CommonService.myAlert("회원님의 비밀번호는 "+result );
		}
	}
	public void btnBack() {
		MainClass2 ms = new MainClass2();
		ms.viewFx(root);
	}
	public void btnback() {
		MainClass2 ms = new MainClass2();
		ms.viewFx(root);
	}
}
