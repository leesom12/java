package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.SnackDto;

public class SnackDao {
	Connection con= null;
	PreparedStatement ps= null;
	ResultSet rs= null;
	
	//등록
	public int snackSave(SnackDto dto) {
		int result=0;
		String query="insert into h_이소민_snack\r\n" + 
					 "(p_code, p_name, m_code, price)\r\n" + 
					 "values \r\n" + 
					 "('"+dto.getP_code()+"', '"+dto.getP_name()+"', '"+dto.getM_code()+"', "+dto.getPrice()+")";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("snackSave(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//제조사 코드, 제조사 명 조회
	public ArrayList<SnackDto> getComapanyList() {
		ArrayList<SnackDto> arr = new ArrayList<SnackDto>();
		String query="select m_name, m_code\r\n" + 
					 "from commonsnack\r\n" + 
					 "order by m_name";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String m_code= rs.getString("m_code");
				String m_name= rs.getString("m_name");
				SnackDto dto= new SnackDto(m_code, m_name);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getCompanyList(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//전체 조회
	public ArrayList<SnackDto> getSnackList(String gubun, String search){
		ArrayList<SnackDto> arr = new ArrayList<SnackDto>();
		String query="select h.p_code, h.p_name, c.m_name, \r\n" + 
					 "to_char(h.price, '999,999') as price\r\n" + 
					 "from h_이소민_snack h, commonsnack c\r\n" + 
					 "where h.m_code = c.m_code\r\n" + 
					 "and "+gubun+" like '%"+search+"%'\r\n"+
					 "order by p_code asc";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String p_code= rs.getString("p_code");
				String p_name= rs.getString("p_name");
				String m_name= rs.getString("m_name");
				String price= rs.getString("price");
				
				SnackDto dto= new SnackDto(p_code, p_name, m_name, price);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getSnackList(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//상세 조회
	public SnackDto snackSearch(String p_code) {
		SnackDto dto= null;
		String query="select h.p_code, h.p_name, h.m_code ,c.m_name, to_char(h.price, '999,999') as price\r\n" + 
					 "from h_이소민_snack h, commonsnack c\r\n" + 
					 "where h.m_code = c.m_code\r\n" + 
					 "and p_code='"+p_code+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String p_name= rs.getString("p_name");
				String m_name= rs.getString("m_name");
				String price= rs.getString("price");
				
				dto= new SnackDto(p_code, p_name, m_name, price);
			}
		}catch(Exception e) {
			System.out.println("snackSearch(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	//수정
	public int updateSnack(SnackDto dto) {
		int result=0;
		String query="update h_이소민_snack\r\n" + 
					 "set p_name='"+dto.getP_name()+"', m_code='"+dto.getM_code()+"', price="+dto.getPrice()+"\r\n" + 
					 "where p_code='"+dto.getP_code()+"'";
		try {
			con= DBConnection.getConnection();
			ps=con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("updateSnack(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

	//삭제
	public int deleteSnack(String p_code) {
		int result=0;
		String query="delete from h_이소민_snack\r\n" + 
					 "where p_code='"+p_code+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("deleteSnack(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//제품코드 중복 검사
	public int checkPCode(String p_code) {
		int result=0;
		String query="select count(*) as count\r\n" + 
					 "from h_이소민_snack\r\n" + 
					 "where p_code='"+p_code+"'";
		try {
			con= DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) result= rs.getInt("count");
		}catch(Exception e) {
			System.out.println("checkPCode(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
}
