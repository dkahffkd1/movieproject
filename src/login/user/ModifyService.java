package login.user;

import javafx.scene.Parent;

public interface ModifyService {
	public void setRoot(Parent root);
	public void btnDel(int result1);
	public void delId(String id, String pwd, String email);
	public void del();
}
