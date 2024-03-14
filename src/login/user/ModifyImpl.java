package login.user;

import java.util.ArrayList;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import login.dao.LoginDAO;
import login.dto.LoginDTO;
import member.dao.MemberDAO;
import member.dto.MemberDTO;
import member.service.MemberService;

public class ModifyImpl implements ModifyService {
	Parent root;
	TextField delId,delPwd,delEmail;
	MemberDAO dao;
	ArrayList<MemberDTO> arr;
	String id2;
	String pwd2;
	String email2;

	public ModifyImpl() {
		dao = new MemberDAO();
		arr = new ArrayList<>();
	}
	public void setRoot(Parent root) {
		this.root = root;
	}
	public void btnDel(int result1) {

		delId = (TextField)root.lookup("#fxId");
		delPwd = (PasswordField)root.lookup("#fxPwd");
		delEmail = (TextField)root.lookup("#fxEmail");


		if(delId.getText().isEmpty()) {
			delId.requestFocus();
			CommonService.myAlert("아이디를 입력하세요");

		}else if(delPwd.getText().isEmpty()) {
			delPwd.requestFocus();
			CommonService.myAlert("비밀번호를 입력하세요");
		}else if(delEmail.getText().isEmpty()) {
			delEmail.requestFocus();
			CommonService.myAlert("이메일을 입력하세요");
		}
		MemberDTO dto = new MemberDTO();
		
		dto.setId(delId.getText());
		dto.setPwd(delPwd.getText());
		dto.setEmail(delEmail.getText());

		int result = dao.delete(id2);
		
		String msg = null;

		if(result1 == 0) {
		if(result == 1) {
			CommonService.myAlert("탈퇴 완료");
			CommonService.cancelFunc(root);
			}
		}else {
			CommonService.myAlert("정보가 잘못 입력되었습니다");
		}
	}
	public void delId(String id, String pwd, String email) {
		this.id2 = id;
		this.pwd2 = pwd;
		this.email2= email;
	}
	public void del() {
		int result;
		arr = dao.getMembers();
		for(int i =0; i<arr.size(); i++) {
			if(id2.equals(arr.get(i).getId())) {
				if(pwd2.equals(arr.get(i).getPwd())) {
					if(email2.equals(arr.get(i).getEmail())) {
						result = 0;
					}
				}
			}else {
				result = 1;
			}
		}
	}


}