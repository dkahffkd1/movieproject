package longin.idfind;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import login.dao.LoginDAO;
import login.dto.LoginDTO;
import login.service.LoginService;

public class LoginIdfindImpl implements LoginService {
	Parent root;
	TextField idFind;
	LoginDAO dao;
	public LoginIdfindImpl() {
		dao = new LoginDAO();
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

	public void btnFind(Parent root) {
		
		String msg = "검색할 아이디 입력";
		CommonService.myAlert(msg);
		LoginDTO dto = dao.getUser(msg);
		if(dto ==null) {
			String msg2 = "존재하지 않는 아이디 입니다.";
			CommonService.myAlert(msg2);
		}else {
			CommonService.myAlert("검색한 아이디 :" + dto.getId());
		} return;
	
	}

	public void btnPwd(Parent root) {
		
	}



}
