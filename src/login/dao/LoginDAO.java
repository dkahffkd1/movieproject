package login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import login.dto.LoginDTO;

public class LoginDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public LoginDAO() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "c##abcd", pwd = "1234";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이브 로드 성공");
			con = DriverManager.getConnection(url,id,pwd);
			System.out.println("디비 연결 성공" + con );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public LoginDTO getUser(String id) {
		LoginDTO dto = null;
		System.out.println("id : " +id);
		String sql = "select * from login_fx where id = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				dto = new LoginDTO(rs.getString("id"), rs.getString("pwd"), rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
