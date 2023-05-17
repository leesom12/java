package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import common.CommonUtil;
import common.DBConnection;
import dto.MemberDto;

public class MemberDao {
	Connection con= null;
	PreparedStatement ps= null;
	ResultSet rs= null;
	
	//암호화
    public String encryptSHA256(String value) throws NoSuchAlgorithmException{
        String encryptData ="";
         
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        sha.update(value.getBytes());
 
        byte[] digest = sha.digest();
        for (int i=0; i<digest.length; i++) {
            encryptData += Integer.toHexString(digest[i] &0xFF).toUpperCase();
        }
         
        return encryptData;
    }
	
	//회원가입
	public int saveMember(MemberDto dto) {
		int result=0;
		String query=" insert into home_이소민_member\r\n" + 
					 " (id, name, password, pass_length ,job, tell_1, tell_2, tell_3, \r\n" + 
					 " mobile, email, reg_date)\r\n" + 
					 " values('"+dto.getId()+"', '"+dto.getName()+"', '"+dto.getPassword()+"', '"+dto.getPassLength()+"', '"+dto.getJob()+"',"+
					 "'"+dto.getTell_1()+"','"+dto.getTell_2()+"','"+dto.getTell_3()+"','"+dto.getMobile()+"',\r\n" + 
					 " '"+dto.getEmail()+"',to_date('"+dto.getReg_date()+"','yyyy-MM-dd hh24:mi:ss'))";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveMember() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//로그인
	public String checkLogin(String id, String password) {
		String name="";
		String query=" select name \r\n" + 
					 " from home_이소민_member\r\n" + 
					 " where id='"+id+"'\r\n" + 
					 " and password='"+password+"'";
		try {
			con=DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				name= rs.getString("name");
			}
		}catch(Exception e) {
			System.out.println("checkLogin() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return name;
	}
	
	//마이페이지 세부조회
	public MemberDto viewInfo(String id) {
		MemberDto dto= null;
		String query=" select id, name, job, tell_1, tell_2, tell_3, \r\n" + 
					 " mobile, email, to_char(reg_date, 'yyyy.MM.dd') as reg_date\r\n" + 
					 " from home_이소민_member\r\n" + 
					 " where id='"+id+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				id= rs.getString("id");
				String name= rs.getString("name");
				String job= rs.getString("job");
				String tell_1= rs.getString("tell_1");
				//if(tell_1==null) tell_1="";
				String tell_2= rs.getString("tell_2");
				//if(tell_2==null) tell_2="";
				String tell_3= rs.getString("tell_3");
				//if(tell_3==null) tell_3="";
				String mobile= rs.getString("mobile");
				String email= rs.getString("email");
				String reg_date= rs.getString("reg_date");
				
				dto= new MemberDto(id, name, "", job, tell_1, tell_2, tell_3, mobile, email, reg_date);
			}
		}catch(Exception e) {
			System.out.println("viewInfo() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	//정보 수정
	public int updateMember(MemberDto dto) {
		int result=0;
		String query=" update home_이소민_member\r\n" + 
					 " set name='"+dto.getName()+"', job='"+dto.getJob()+"',\r\n" + 
					 " tell_1='"+dto.getTell_1()+"', tell_2='"+dto.getTell_2()+"', tell_3='"+dto.getTell_3()+"',\r\n" + 
					 " mobile='"+dto.getMobile()+"', email='"+dto.getEmail()+"'\r\n" + 
					 " where id='"+dto.getId()+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("updateMember() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//패스워드 체크
	public int checkPassword(String id, String password) {
		int count=0;
		String query=" select count(*) as count from home_이소민_member\r\n" + 
					 " where id='"+id+"' \r\n" + 
					 " and password='"+password+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) count= rs.getInt("count");
		}catch(Exception e) {
			System.out.println("checkPassword() 오류: "+ query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return count;
	}
	
	//아이디 중복 검사
	public int checkID(String id) {
		int count=0;
		String query=" select count(*) as count from home_이소민_member\r\n" + 
					 " where id='"+id+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) count= rs.getInt("count");
		}catch(Exception e) {
			System.out.println("checkID() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}
	
	
	//회원탈퇴
	public void deleteMember(String id) {
		String query="update home_이소민_member\r\n" + 
					 "set account_yn='N'\r\n" + 
					 "where id='"+id+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			int result=0;
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("deleteMember() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}

	}
	
	//탈퇴체크
		public String checkDelte(String id, String password) {
			String yn="";
			String query=" select account_yn \r\n" + 
						 " from home_이소민_member\r\n" + 
						 " where id='"+id+"'\r\n" + 
						 " and password='"+password+"'";
			try {
				con=DBConnection.getConnection();
				ps= con.prepareStatement(query);
				rs= ps.executeQuery();
				if(rs.next()) {
					yn= rs.getString("account_yn");
				}
			}catch(Exception e) {
				System.out.println("checkLogin() 오류: "+query);
				e.printStackTrace();
			}finally {
				DBConnection.closeDB(con, ps, rs);
			}
			return yn;
		}
}




















