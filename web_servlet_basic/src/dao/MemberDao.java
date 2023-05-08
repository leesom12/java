package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.MemberDto;


public class MemberDao {
	Connection con= null;
	PreparedStatement ps= null;
	ResultSet rs= null;
	
	//등록
	public int memberSave(MemberDto dto) {
		int result=0;
		String query="insert into h_이소민_member\r\n" + 
					 "(id, name, age, reg_date)\r\n" + 
					 "values\r\n" + 
					 "('"+dto.getId()+"', '"+dto.getName()+"',"+dto.getAge()+",'"+dto.getReg_Date()+"')";
		try {
			con= DBConnection.getConnection();
			ps=con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("memberSave(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//조회
	public ArrayList<MemberDto> memberList(String gubun, String search){
		ArrayList<MemberDto> dtos = new ArrayList<>();
		String query="select id, name, age,\r\n" + 
					 "to_char(reg_date, 'yyyy-mm-dd') as reg_date\r\n" + 
					 "from h_이소민_member\r\n"+
					 "where "+gubun+" like '%"+search+"%'"+
					 "order by reg_date desc";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				String id= rs.getString(1);
				String name= rs.getString(2);
				int age= rs.getInt(3);
				String reg_date= rs.getString(4);
				MemberDto dto= new MemberDto(id, name, age, reg_date);
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println("memberList(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	
	//상세조회
	public MemberDto memberView(String id){
		MemberDto dto = null;
		String query="select id, name, age,\r\n" + 
					 "to_char(reg_date, 'yyyy-mm-dd') as reg_date\r\n" + 
					 "from h_이소민_member\r\n"+
					 "where id = '"+id+"'"+
					 "order by reg_date desc";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()) {
				String name= rs.getString(2);
				int age= rs.getInt(3);
				String reg_date= rs.getString(4);
				dto= new MemberDto(id, name, age, reg_date);
			}
		}catch(Exception e) {
			System.out.println("memberList(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	//수정
	public int memberUpadate(MemberDto dto) {
		int result= 0;
		String query="update h_이소민_member\r\n" + 
					 "set name='"+dto.getName()+"', age="+dto.getAge()+", reg_date='"+dto.getReg_Date()+"'\r\n" + 
					 "where id='"+dto.getId()+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("memberUpdate(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//삭제
	public int memberDelete(String id) {
		int result=0;
		String query="delete from h_이소민_member\r\n" + 
					 "where id='"+id+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("memberDelete(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
}
