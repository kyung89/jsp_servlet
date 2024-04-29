package membership;

import java.util.ArrayList;

import common.JDBConnect;
import jakarta.servlet.ServletContext;

public class MemberDAO extends JDBConnect {

	public MemberDAO(ServletContext application) {
		super(application);
	}
	
	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO();
		String query = "SELECT * FROM MEMBER WHERE id=? AND pass=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	// member table 다 들고오기
	public ArrayList<MemberDTO> getMembers() {
		ArrayList<MemberDTO> members = new ArrayList<>();
		String query = "SELECT * FROM MEMBER";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
				
				members.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return members;
	}
}
