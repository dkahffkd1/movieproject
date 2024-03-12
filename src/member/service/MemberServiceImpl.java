package member.service;

import java.util.ArrayList;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {
	Parent root;
	TextField fxId,fxName,fxEmail;
	PasswordField fxPwd, fxPwdChk;
	MemberDAO dao;
	ArrayList<MemberDTO> arr1; 

	public MemberServiceImpl() {
		dao = new MemberDAO();
		arr1 = new ArrayList<>();
	}
	public void setRoot(Parent root) {
		System.out.println();
		this.root = root;
	}
	public void btnEnterFunc() {

		fxId = (TextField)root.lookup("#fxId");
		fxName = (TextField)root.lookup("#fxName");
		fxPwd = (PasswordField)root.lookup("#fxPwd");
		fxPwdChk = (PasswordField)root.lookup("#fxPwdChk");

		String name = null;
		String id = null; 
		String pwd = null; 


		if(fxName.getText().isEmpty()) {
			name = "이름을 입력하세요";
			fxName.requestFocus();
			CommonService.myAlert(name);
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
		dto.setId(fxId.getText());
		dto.setPwd(fxPwd.getText());
		if(dto.getId()!=null) {
			String msg = "아이디가 중복되었습니다.";
			CommonService.myAlert(msg);
		}
		if(dto.getPwd().equals(fxPwdChk.getText())) {
		}else {
			String msg = "비밀번호가 다릅니다.";
			CommonService.myAlert(msg);
		}

		int result = dao.register(dto);
		String msg = null;
		if(result ==1) {
			msg = "아이디가 등록되었습니다";
			cancelFunc();
		}else {
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

	public ArrayList<MemberDTO> arr(){

		return arr1;
	}
	public void IdChk(String fxId) {
		MemberDTO dto = new MemberDTO();
		ArrayList<MemberDTO> member = dao.getMembers();

	}
}