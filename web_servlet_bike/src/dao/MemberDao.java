package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.CommonUtil;
import common.DBConnection;
import dto.MemberDto;

public class MemberDao {
	Connection con = null;
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
    	String query="insert into bike_이소민_member\r\n" + 
	    			"(id, name, password, area, address, mobile_1, mobile_2, mobile_3, gender,\r\n" + 
	    			"hobby_travel, hobby_reading, hobby_sports, reg_date, pass_length)\r\n" + 
	    			"values\r\n" + 
	    			"('"+dto.getId()+"', '"+dto.getName()+"', '"+dto.getPassword()+"', '"+dto.getArea()+"', '"+dto.getAddress()+"'"
	    			+ ", '"+dto.getMobile_1()+"', '"+dto.getMobile_2()+"', '"+dto.getMobile_3()+"', '"+dto.getGender()+"',\r\n" + 
	    			"'"+dto.getTravel()+"', '"+dto.getReading()+"', '"+dto.getSports()+"', to_date('"+dto.getReg_date()+"', 'yyyy-MM-dd hh24:mi:ss'), "+dto.getPass_len()+")";
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
    
    //아이디 중복 체크
    public int checkId(String id) {
    	int count=0;
    	String query="select count(*) as count from bike_이소민_member\r\n" + 
    				 "where id ='"+id+"'";
    	try {
    		con= DBConnection.getConnection();
    		ps= con.prepareStatement(query);
    		rs= ps.executeQuery();
    		if(rs.next()) count= rs.getInt("count");
    	}catch(Exception e) {
    		System.out.println("checkId() 오류: "+query);
    		e.printStackTrace();
    	}finally {
    		DBConnection.closeDB(con, ps, rs);
    	}
    	return count;
    }
    
    //로그인
    public MemberDto memberLogin(String id, String pw) {
    	MemberDto dto = null;
    	String query="select name, mem_level from bike_이소민_member\r\n" + 
    				 "where id ='"+id+"'\r\n" + 
    				 "and password = '"+pw+"'";
    	try {
    		con= DBConnection.getConnection();
    		ps= con.prepareStatement(query);
    		rs= ps.executeQuery();
    		if(rs.next()) {
    			String name=rs.getString("name");
    			String level = rs.getString("mem_level");
    			dto= new MemberDto(name, level);
    		}
    	}catch(Exception e) {
    		System.out.println("memberLogin() 오류: "+query);
    		e.printStackTrace();
    	}finally {
    		DBConnection.closeDB(con, ps, rs);
    	}
    	return dto;
    }
    
    //로그인 시간 업데이트
    public void updateLoginTime(String id) {
    	String loginTime = CommonUtil.getTodayTime();
    	String query="update bike_이소민_member\r\n" + 
    				 "set login_time= to_date('"+loginTime+"', 'yyyy-MM-dd hh24:mi:ss')\r\n" + 
    				 "where id='"+id+"'";
    	try {
    		con= DBConnection.getConnection();
    		ps= con.prepareStatement(query);
    		int result= ps.executeUpdate();
			if(result != 1) {
				System.out.println("updateLoginTime() 오류!: "+query);
			}
    	}catch(Exception e) {
    		System.out.println("updateLoginTime() 오류: "+query );
    		e.printStackTrace();
    	}finally {
    		DBConnection.closeDB(con, ps, rs);
    	}
    }
    
    //회원 정보 조회
    public MemberDto memberInfo(String id) {
    	MemberDto dto = null;
    	String query="select id, name, pass_length, area, address, mobile_1, mobile_2, mobile_3, \r\n" + 
    				 "gender, hobby_travel as travel, hobby_reading as reading, hobby_sports as sports, \r\n" + 
    				 "to_char(reg_date, 'yyyy-MM-dd hh24:mi:ss') as reg_date, \r\n" + 
    				 "to_char(update_date, 'yyyy-MM-dd hh24:mi:ss') as update_date, \r\n" + 
    				 "to_char(login_time, 'yyyy-MM-dd hh24:mi:ss') as login_time, \r\n" + 
    				 "to_char(exit_date, 'yyyy-MM-dd hh24:mi:ss') as exit_date, \r\n" + 
    				 "mem_level\r\n"+
    				 "from bike_이소민_member\r\n" + 
    				 "where id = '"+id+"'";
    	try {
    		con= DBConnection.getConnection();
    		ps= con.prepareStatement(query);
    		rs= ps.executeQuery();
    		if(rs.next()) {
    			String name= rs.getString("name");
    			int pass_length= rs.getInt("pass_length");
    			String area= rs.getString("area");
    			String address= rs.getString("address");
    			String mobile_1=rs.getString("mobile_1");
    			String mobile_2=rs.getString("mobile_2");
    			String mobile_3= rs.getString("mobile_3");
    			String gender=rs.getString("gender");
    			if(gender.equals("F")) {
    				gender="여성";
    			}else {
    				gender="남성";
    			}
    			String travel= rs.getString("travel");
    			String reading = rs.getString("reading");
    			String sports= rs.getString("sports");
    			String reg_date= rs.getString("reg_date");
    			String update_date= rs.getString("update_date");
    			String login_time= rs.getString("login_time");
    			String exit_date= rs.getString("exit_date");
    			String level= rs.getString("mem_level");
    			
    			dto= new MemberDto(id, name, area, address, mobile_1, mobile_2, mobile_3, gender, travel, reading, sports, reg_date, update_date,
    					login_time, exit_date, level, pass_length);
    		}
    	}catch(Exception e) {
    		System.out.println("memberInfo() 오류: "+query);
    		e.printStackTrace();
    	}finally {
    		DBConnection.closeDB(con, ps, rs);
    	}
    	return dto;
    }
    

    
    
    
    
    
    
    
    
    
    
    
    
}
