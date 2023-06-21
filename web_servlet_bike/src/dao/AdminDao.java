package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.CommonUtil;
import common.DBConnection;
import dto.AdminDto;
import dto.MemberDto;

public class AdminDao {
	Connection con= null;
	PreparedStatement ps= null;
	ResultSet rs= null;
	
	//게시글 개수
	public int getTotalCount(String select, String search) {
		int count=0;
		String query=" select count(*) as count \r\n" + 
					 " from bike_이소민_member \r\n" + 
					 " where "+select+" like '%"+search+"%'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) count= rs.getInt("count");
		}catch(Exception e) {
			System.out.println("getTotalCount() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}	
	
	//회원 전체 조회
	public ArrayList<AdminDto> getMemberList(String select, String search, int start, int end){
		ArrayList<AdminDto> arr= new ArrayList<AdminDto>();
		String query="select * from\r\n" + 
					"    (select rownum as rnum, tbl.* from\r\n" + 
					"        (select id, name, area, mobile_1, mobile_2, mobile_3, \r\n" + 
					"        to_char(reg_date, 'yyyy-MM-dd') as reg_date,\r\n" + 
					"        to_char(login_time, 'yyyy-MM-dd hh24:mi:ss') as login_time,\r\n" + 
					"        to_char(exit_date, 'yyyy-MM-dd hh24:mi:ss') as exit_date\r\n" + 
					"        from bike_이소민_member\r\n" + 
					"        where "+select+" like '%"+search+"%'\r\n" + 
					"        order by reg_date desc\r\n" + 
					"    ) tbl\r\n" + 
					") where rnum >= "+start+" and rnum <= "+end+"";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String id= rs.getString("id");
				String name= rs.getString("name");
				String area= rs.getString("area");
				String mo1 = rs.getString("mobile_1");
				String mo2 = rs.getString("mobile_2");
				String mo3 = rs.getString("mobile_3");
				String mobile= mo1+"-"+mo2+"-"+mo3;
				String reg_date = rs.getString("reg_date");
				String login_time= rs.getString("login_time");
				String exit_date= rs.getString("exit_date");
				
				AdminDto dto = new AdminDto(id, name, area, mobile, reg_date, login_time, exit_date);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getMemberList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//상세조회
	public AdminDto getMemberView(String id) {
		AdminDto dto = null;
		String query="select id, name, pass_length, area, address, mobile_1, mobile_2, mobile_3, \r\n" + 
					"gender, hobby_travel, hobby_reading, hobby_sports, \r\n" + 
					"to_char(reg_date, 'yyyy-MM-dd hh24:mi:ss') as reg_date,\r\n" + 
					"to_char(login_time, 'yyyy-MM-dd hh24:mi:ss') as login_time,\r\n" + 
					"to_char(update_date, 'yyyy-MM-dd hh24:mi:ss') as update_date,\r\n" + 
					"to_char(exit_date, 'yyyy-MM-dd hh24:mi:ss') as exit_date\r\n" + 
					"from bike_이소민_member\r\n" + 
					"where id = '"+id+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String name= rs.getString("name");
				String area= rs.getString("area");
				int pass_length= rs.getInt("pass_length");
				String address = rs.getString("address");
				String mo1 = rs.getString("mobile_1");
				String mo2 = rs.getString("mobile_2");
				String mo3 = rs.getString("mobile_3");
				String mobile= mo1+"-"+mo2+"-"+mo3;
				String gender = rs.getString("gender");
				if(gender.equals("M")) {
					gender="남";
				}else gender="여";
				String h_travel = rs.getString("hobby_travel");
				String h_reading = rs.getString("hobby_reading");
				String h_sports = rs.getString("hobby_sports");
				String reg_date = rs.getString("reg_date");
				String login_time= rs.getString("login_time");
				String update_date = rs.getString("update_date");
				String exit_date= rs.getString("exit_date");
				
				dto = new AdminDto(id, name, area, address, mobile, gender, h_travel, h_reading, h_sports, 
						reg_date, login_time, update_date, exit_date, pass_length);
			}
		}catch(Exception e) {
			System.out.println("getMemberView() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}

	

	
	
	
	
	
	
	
	
	
	
	
}
