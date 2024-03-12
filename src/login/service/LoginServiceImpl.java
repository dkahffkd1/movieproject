package login.service;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import login.dao.LoginDAO;
import login.dto.LoginDTO;
import member.dto.MemberDTO;
import member.main.MemberMain;

public class LoginServiceImpl implements LoginService{
	private LoginDAO dao;
	public LoginServiceImpl() {
		dao = new LoginDAO();
	}

	public void loginFunc(TextField fxId, TextField fxPwd, CheckBox chkId) {

		System.out.println("id : "+ fxId.getText());

		System.out.println("pwd : "+ fxPwd.getText());

		LoginDTO dto = dao.getUser(fxId.getText());

		System.out.println("dto : " + dto);

		String msg = null;

		if(dto != null) {

			if(dto.getPwd().equals(fxPwd.getText())) {

				msg = dto.getName() +"님이 로그인 하셨습니다.";

			}else {
				msg = "비밀번호 틀림";
			}
		}else {
			msg = "존재하지 않는 아이디입니다.";
		}
		CommonService.myAlert(msg);
	}

	public void registerFunc(Parent root) {
		MemberMain member = new MemberMain();
		member.viewFx(root);
	}
	public void registerFunc() {
		MemberMain member = new MemberMain();
		member.viewFx();
	}
	public void idfindFunc(Parent root) {

	}
	public void pwdfincFunc(Parent root) {

	}

}

