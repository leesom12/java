package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.Sub1Dto;
import dto.Sub2Dto;
import dto.Sub3Dto;
import dto.Sub4Dto;
import dto.Sub5Dto;

public class SmartDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	//작업공정수정
	public int updateProcess(Sub4Dto dto) {
		int result = 0;
		String query="update e_09_이소민_process\r\n" + 
					 "set p_p1='"+dto.getP_p1()+"', p_p2='"+dto.getP_p2()+"', p_p3='"+dto.getP_p3()+"', w_lastdate='"+dto.getW_lastdate()+"', w_lasttime='"+dto.getW_lasttime()+"'\r\n" + 
					 "where w_workno='"+dto.getW_workno()+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("updateProcess() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	
	//작업공정등록
	public int saveProcessList(Sub4Dto dto) {
		int result = 0;
		String query="insert into e_09_이소민_process values ('"+dto.getW_workno()+"','"+dto.getP_p1()+"','"+dto.getP_p2()+"','"+dto.getP_p3()+"',"
				+ "'"+dto.getW_lastdate()+"','"+dto.getW_lasttime()+"')";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveProcessList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	
	//작업지시등록
	public int saveWorkList(Sub3Dto dto) {
		int result = 0;
		String query="insert into e_09_이소민_worklist values ('"+dto.getW_workno()+"','"+dto.getP_code()+"','"+dto.getW_quentity()+"','"+dto.getW_workdate()+"')";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveWorkList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	
	//작업지시등록 select box
	public ArrayList<Sub3Dto> getProductCode(){
		ArrayList<Sub3Dto> arr = new ArrayList<Sub3Dto>();
		String query="select p_code, p_name from  e_09_이소민_product p\r\n" + 
					 "order by p_code";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String p_code = rs.getNString("p_code");
				String p_name = rs.getNString("p_name");
				
				Sub3Dto dto = new Sub3Dto(p_code, p_name);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getProductCode() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	
	
	//작업공정조회
	public ArrayList<Sub5Dto> getProcessList(){
		ArrayList<Sub5Dto> arr = new ArrayList<Sub5Dto>();
		String query="select to_char(w.w_workno,'9999,9999') w_workno, p.p_code, p.p_name, \r\n" + 
					 "decode(r.p_p1, 'Y','완료','~') p_p1, decode(r.p_p2, 'Y','완료','~') p_p2, decode(r.p_p3, 'Y','완료','~') p_p3,\r\n" + 
					 "to_char(to_date(r.w_lastdate),'yyyy\"년\"MM\"월\"dd\"일\"') w_lastdate,\r\n" + 
					 "to_char(r.w_lasttime,'99,99') w_lasttime\r\n" + 
					 "from  e_09_이소민_product p, e_09_이소민_product_size s, \r\n" + 
					 "e_09_이소민_worklist w, e_09_이소민_process r\r\n" + 
					 "where p.p_size= s.p_size_code and p.p_code = w.p_code and w.w_workno = r.w_workno\r\n"+
					 "order by w.w_workno";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String w_workno = rs.getNString("w_workno");
				w_workno = w_workno.replaceAll(",", "-");
				String p_code = rs.getNString("p_code");
				String p_name = rs.getNString("p_name");
				String p_p1 = rs.getNString("p_p1");
				String p_p2 = rs.getNString("p_p2");
				String p_p3 = rs.getNString("p_p3");
				String w_lastdate = rs.getNString("w_lastdate");
				String w_lasttime = rs.getNString("w_lasttime");
				w_lasttime = w_lasttime.replaceAll(",", ":");
				
				Sub5Dto dto = new Sub5Dto(w_workno, p_code, p_name, p_p1, p_p2, p_p3, w_lastdate, w_lasttime);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getProcessList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	
	
	//작업지시조회
	public ArrayList<Sub2Dto> getWorkList(){
		ArrayList<Sub2Dto> arr = new ArrayList<Sub2Dto>();
		String query="select to_char(w.w_workno,'9999,9999') w_workno, p.p_code, p.p_name, s.p_size, p.p_type, w.w_quentity, to_char(w.w_workdate,'yyyy-MM-dd') w_workdate\r\n" + 
					 "from e_09_이소민_product p, e_09_이소민_product_size s, e_09_이소민_worklist w\r\n" + 
					 "where p.p_size= s.p_size_code and p.p_code = w.p_code\r\n" + 
					 "order by w.w_workno";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String w_workno = rs.getNString("w_workno");
				w_workno = w_workno.replaceAll(",", "-");
				String p_code = rs.getNString("p_code");
				String p_name = rs.getNString("p_name");
				String p_size = rs.getNString("p_size");
				String p_type = rs.getNString("p_type");
				String w_workdate = rs.getNString("w_workdate");
				int w_quentity = rs.getInt("w_quentity");
				
				Sub2Dto dto = new Sub2Dto(w_workno, p_code, p_name, p_size, p_type, w_workdate, w_quentity);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getWorkList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	
	
	
	//제품조회
	public ArrayList<Sub1Dto> getProductList(){
		ArrayList<Sub1Dto> arr = new ArrayList<Sub1Dto>();
		String query="select p.p_code, p.p_name, s.p_size, p.p_type, to_char(p.p_price,'l9,999,999') p_price\r\n" + 
					 "from e_09_이소민_product p, e_09_이소민_product_size s\r\n" + 
					 "where p.p_size= s.p_size_code\r\n" + 
					 "order by p.p_code";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String p_code = rs.getNString("p_code");
				String p_name = rs.getNString("p_name");
				String p_size = rs.getNString("p_size");
				String p_type = rs.getNString("p_type");
				String p_price = rs.getNString("p_price");
				
				Sub1Dto dto = new Sub1Dto(p_code, p_name, p_size, p_type, p_price);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getProductList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
}
