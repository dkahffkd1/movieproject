package member.service;

import javafx.scene.Parent;

public interface MemberService {
	public void setRoot(Parent root);
	public void btnEnterFunc(int result);
	public void btnCancelFunc();
	public void IdChk(String fxId);
	public int same();
	public void PwdChk(String pwd, String pwdchk);
	public int pwdsame();

}
