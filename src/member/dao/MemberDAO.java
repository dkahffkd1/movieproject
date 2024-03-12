package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import member.dto.MemberDTO;

public class MemberDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public MemberDAO(){
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "c##abcd", pwd="1234";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로드 성공");
			con = DriverManager.getConnection(url,id,pwd);
			System.out.println("디비 연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public int register(MemberDTO dto) {
		int result = 0;
		String sql = "insert into login_fx(id,pwd,name)"+"values(?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getName());
			
			result = ps.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<MemberDTO> getMembers(){
		String sql = "select * from login_fx";
		ArrayList<MemberDTO> mem = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("fxId"));
				dto.setPwd(rs.getString("fxPwd"));
				dto.setName(rs.getString("fxName"));
				mem.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mem;
	}
}
