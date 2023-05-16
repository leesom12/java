package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	    			"'"+dto.getTravel()+"', '"+dto.getReading()+"', '"+dto.getSports()+"', to_date('"+dto.getReg_date()+"', 'yyyy-MM-dd hh24:mi:ss'), 3)";
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
    		System.out.println("chechId() 오류: "+query);
    		e.printStackTrace();
    	}finally {
    		DBConnection.closeDB(con, ps, rs);
    	}
    	return count;
    }
    
    
}
