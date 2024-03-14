package longin.idfind;

import java.util.ArrayList;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import login.dao.LoginDAO;
import login.dto.LoginDTO;
import login.service.LoginService;
import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class LoginIdfindImpl implements LoginService {
	Parent root;
	TextField idFind, pwdfind;
	MemberDAO dao;
	LoginDAO da;
	ArrayList<MemberDTO> arr;
	String idf;
	String idf1;
	String pwd;
	String pwd2;
	String idf0;

	public LoginIdfindImpl() {
		da = new LoginDAO();
		dao = new MemberDAO();
	}
	public void setRoot(Parent root) {
		this.root = root;
	}
	public void loginFunc(TextField fxId, TextField fxPwd, CheckBox chkId) {

	}
	public void registerFunc(Parent root) {

	}

	public void idfindFunc(Parent root) {

	}

	public void pwdfindFunc(Parent root) {

	}

	public void btnFind(String idf) {
		this.idf1 = idf;
	}
	public String idid() {
		int result;
		arr = dao.getMembers();
		for (int i = 0; i < arr.size(); i++) {
			if(idf1.equals(arr.get(i).getEmail())) {
				return arr.get(i).getId();
			}else {
			}
		}
		return "b";
	}

	public void btnPwd(String pwd) {
		this.pwd2 = pwd;

	}
	public String btnfind() {
		int result = 0;
		arr = dao.getMembers();
		System.out.println("asdf" + arr.size());

		for (int i = 0; i < arr.size(); i++) {

			if(pwd2.equals(arr.get(i).getId())) {

				return arr.get(i).getPwd();
			}else {

			}

		}
		return "a";
	}
}
