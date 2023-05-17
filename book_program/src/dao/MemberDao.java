package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.MemberDto;


public class MemberDao {
	Connection con = null;
	PreparedStatement ps= null;
	ResultSet rs= null;
	
	//회원조회
	public ArrayList<MemberDto> memberList(){
		ArrayList<MemberDto> arr= new ArrayList<MemberDto>();
		String query="select p_no, p_name, p_birth, p_gender, p_tel1, p_tel2, p_tel3, p_reg_date\r\n" + 
					 "from e_이소민_client\r\n" + 
					 "order by p_no asc";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String no= rs.getString("p_no");
				String name= rs.getString("p_name");
				String p_birth= rs.getString("p_birth");
				String b_1= p_birth.substring(0, 4);
				String b_2= p_birth.substring(4, 6);
				String b_3= p_birth.substring(6);
				String birth=b_1+"년 "+b_2+"월 "+b_3+"일";
				String gender= rs.getString("p_gender");
				if(gender.equals("M")) {
					gender="남자";
				}else if(gender.equals("F")) {
					gender="여자";
				}else gender="오류!";
				String tel1= rs.getString("p_tel1");
				String tel2= rs.getString("p_tel2");
				String tel3= rs.getString("p_tel3");
				String tell= tel1+"-"+tel2+"-"+tel3;
				String p_reg_date= rs.getString("p_reg_date");
				String d_1= p_reg_date.substring(0, 4);
				String d_2= p_reg_date.substring(4, 6);
				String d_3= p_reg_date.substring(6);
				String reg_date= d_1+"-"+d_2+"-"+d_3;
				
				MemberDto dto= new MemberDto(no, name, birth, gender, tell, reg_date);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("memberList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}

	
	
	
	
	
	
	
	
	
	
}
