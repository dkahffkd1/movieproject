package member.service;


import java.util.ArrayList;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import login.dao.LoginDAO;
import login.dto.LoginDTO;
import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {
	Parent root;
	TextField fxId,fxName, fxEmail;
	PasswordField fxPwd, fxPwdChk;
	MemberDAO dao;
	ArrayList<MemberDTO> arr;
	String pwd2, pwdchk2;
	String fxid2;
	public MemberServiceImpl() {
		dao = new MemberDAO();
		arr = new ArrayList<>();
	}
	public void setRoot(Parent root) {
		this.root = root;
	}
	public void btnEnterFunc(int result1) {

		dao = new MemberDAO();

		fxId = (TextField)root.lookup("#fxId");
		fxName = (TextField)root.lookup("#fxName");
		fxPwd = (PasswordField)root.lookup("#fxPwd");
		fxPwdChk = (PasswordField)root.lookup("#fxPwdChk");
		fxEmail = (TextField)root.lookup("#fxEmail");

		String name = null;
		String id = null; 
		String pwd = null; 

		if(fxName.getText().isEmpty()) {
			name = "이름을 입력하세요";
			fxName.requestFocus();
			CommonService.myAlert(name);
		}else if(fxEmail.getText().isEmpty()) {
			fxEmail.requestFocus();
			CommonService.myAlert("이메일을 입력하세요");

		}else if(fxId.getText().isEmpty()) {
			id = "아이디를 입력하세요";
			fxId.requestFocus();
			CommonService.myAlert(id);
		}else if(fxPwd.getText().isEmpty()) {
			pwd = "비밀번호를 입력하세요";
			fxPwd.requestFocus();
			CommonService.myAlert(pwd);
		}
		MemberDTO dto = new MemberDTO();
		dto.setName(fxName.getText());
		dto.setEmail(fxEmail.getText());
		dto.setId(fxId.getText());
		dto.setPwd(fxPwd.getText());

		int result = dao.register(dto);
		String msg = null;

		if (result1 == 0) {
			if(result ==1) {
				msg = "아이디가 등록되었습니다";
				cancelFunc();
			}else {
				msg = "아이디 등록을 실패하였습니다.";
			}
		}else {
			System.out.println("aaaa");
			msg = "아이디 등록을 실패하였습니다.";
		}
		CommonService.myAlert(msg);
	}
	public void btnCancelFunc() {
		CommonService.cancelFunc(root);
	}
	public void cancelFunc() {
		CommonService.cancelFunc(root);
	}

	public void IdChk(String fxid) {
		this.fxid2 = fxid;
	}
	public int same() {
		int result;
		arr = dao.getMembers();
		for (int i = 0; i < arr.size(); i++) {
			if (fxid2.equals(arr.get(i).getId())) {
				System.out.println("중복");
				return 0;
			}else {
				System.out.println("중복아님");

			} 
		}
		return 1;
	}
	public void PwdChk(String pwd, String pwdchk) {
		this.pwd2 = pwd;
		this.pwdchk2 = pwdchk;

	}
	public int pwdsame() {
		int result = 0;
		if(pwd2.equals(pwdchk2)) {
			result =0;
		}else {
			result =1;
		}
		return result;
	}

}