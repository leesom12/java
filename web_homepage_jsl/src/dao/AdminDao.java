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
					 " from home_이소민_member \r\n" + 
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
		
	
	//로그인 시간 갱신
	public void setLoginTime(String sessionId) {
		String TodayTime= CommonUtil.getTodayTime();
		String query="update home_이소민_member\r\n" + 
					 "set login_time= to_date('"+TodayTime+"','yyyy-MM-dd hh24:mi:ss')\r\n" + 
					 "where id='"+sessionId+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			int result= ps.executeUpdate();
			if(result == 0) {
				System.out.println("setLoginTime() 오류: "+query);
			}
		}catch(Exception e) {
			System.out.println("setLoginTime() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
	}
	
	//회원 전체 조회
	public ArrayList<AdminDto> getMemberList(String select, String search, int start, int end){
		ArrayList<AdminDto> arr= new ArrayList<AdminDto>();
		String query="select * from(\r\n" + 
					 "    select rownum as rnum , tbl.* from\r\n" + 
					 "        (select id, name, job, tell_1, tell_2, tell_3, mobile, email,\r\n" + 
					 "        to_char(reg_date, 'yyyy-MM-dd hh24:mi:ss')as reg_date,\r\n" + 
					 "        to_char(login_time, 'yyyy-MM-dd hh24:mi:ss')as login_time,\r\n" + 
					 "        pass_length, account_yn\r\n" + 
					 "        from home_이소민_member\r\n" + 
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
				String job= rs.getString("job");
				String tell_1= rs.getString("tell_1");
				String tell_2= rs.getString("tell_2");
				String tell_3= rs.getString("tell_3");
				String tell= tell_1+" - "+tell_2+" - "+tell_3;
				String mobile= rs.getString("mobile");
				String mobile1= mobile.substring(0, 3);
				String mobile2= mobile.substring(3, 7);
				String mobile3= mobile.substring(7);
				mobile= mobile1+" - "+mobile2+" - "+mobile3;
				String email= rs.getString("email");
				String reg_date= rs.getString("reg_date");
				String login_time= rs.getString("login_time");
				int pass_length= rs.getInt("pass_length");
				String delete= rs.getString("account_yn");
				
				AdminDto dto= new AdminDto(id, name, job, tell, mobile, email, reg_date, login_time, pass_length, delete);
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
	
	//회원 상세 조회
	public AdminDto getMemberView(String id){
		AdminDto dto= null;
		String query="select id, name, job, tell_1, tell_2, tell_3, mobile, email,\r\n" + 
					 "to_char(reg_date, 'yyyy-MM-dd hh24:mi:ss')as reg_date,\r\n" + 
					 "to_char(login_time, 'yyyy-MM-dd hh24:mi:ss')as login_time,\r\n" + 
					 "pass_length,\r\n"+
					 "account_yn\r\n"+
					 "from home_이소민_member\r\n" + 
					 "where id like '%"+id+"%'\r\n" + 
					 "order by reg_date desc";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String name= rs.getString("name");
				String job= rs.getString("job");
				String tell_1= rs.getString("tell_1");
				String tell_2= rs.getString("tell_2");
				String tell_3= rs.getString("tell_3");
				String tell= tell_1+" - "+tell_2+" - "+tell_3;
				if(tell_1 == null) tell="정보없음";
				String mobile= rs.getString("mobile");
				String mobile1= mobile.substring(0, 3);
				String mobile2= mobile.substring(3, 7);
				String mobile3= mobile.substring(7);
				mobile= mobile1+" - "+mobile2+" - "+mobile3;
				String email= rs.getString("email");
				String reg_date= rs.getString("reg_date");
				String login_time= rs.getString("login_time");
				if(login_time == null) login_time= "정보없음";
				int pass_length= rs.getInt("pass_length");
				String delete= rs.getString("account_yn");
				
				dto= new AdminDto(id, name, job, tell, mobile, email, reg_date, login_time, pass_length, delete);
			}
		}catch(Exception e) {
			System.out.println("getMemberList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	//비밀번호 문자열 수만큼
	public String getPasswordLength(String id, int passlength) {
		String pass="";
		String query="select pass_length from home_이소민_member\r\n" + 
					 "where id='"+id+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				for(int k=0; k<passlength; k++) {
					pass=pass+"*";
				}
			}
		}catch(Exception e) {
			System.out.println("getPasswordLength() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return pass;
	}
	
	
	
	
	
	
	
	
	
	
	
}
