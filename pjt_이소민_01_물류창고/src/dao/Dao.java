package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.Dto;

public class Dao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs= null;
	
	//제품조회
	public ArrayList<Dto> getProductList(){
		ArrayList<Dto> arr = new ArrayList<Dto>();
		String query="select p_code, p_name, \r\n" + 
					 "to_char(p_size, '9999') as p_size, \r\n" + 
					 "to_char(p_incost, 'l9,999,999') as p_incost, \r\n" + 
					 "to_char(p_outcost, 'l9,999,999') as p_outcost\r\n" + 
					 "from e_01_이소민_product\r\n"+
					 "order by p_code";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String p_code = rs.getNString("p_code");
				String p_name = rs.getNString("p_name");
				String p_size = rs.getNString("p_size");
				p_size = p_size+"mm";
				String p_incost = rs.getNString("p_incost");
				String p_outcost = rs.getNString("p_outcost");
				
				Dto dto = new Dto(p_code, p_name, p_size, p_incost, p_outcost);
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
	
	//입출고번호 자동생성
	public String getMaxNo() {
		String num="";
		String query="select nvl(max(t_no),'20200000') as t_no\r\n" + 
					 "from e_01_이소민_inout";
		
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String t_no = rs.getNString("t_no");
				int i_no = Integer.parseInt(t_no);
				i_no = i_no+1;
				num = Integer.toString(i_no);
			}
		}catch(Exception e) {
			System.out.println("getMaxNo() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return num;
	}
	
	//입출고 등록
	public int incomingSave(Dto dto) {
		int result = 0;
		String query="insert into e_01_이소민_inout\r\n" + 
					 "(t_no, p_code, t_type, t_cnt, t_date, c_code)\r\n" + 
					 "values\r\n" + 
					 "('"+dto.getT_no()+"', '"+dto.getP_code()+"', '"+dto.getT_type()+"', "
					 		+ "'"+dto.getT_cnt()+"', to_date('"+dto.getT_date()+"','yyyyMMdd'), '"+dto.getC_code()+"')";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("incomingSave() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
	
	//입출고 내역 조회
	public ArrayList<Dto> getIncomingList(){
		ArrayList<Dto> arr = new ArrayList<Dto>();
		String query="select i.t_no, i.p_code, p.p_name, decode(i.t_type, 'I', '입고', 'O', '출고') as t_type,\r\n" + 
					 "i.t_cnt, c.c_name, to_char(i.t_date,'yyyy-MM-dd') as t_date\r\n" + 
					 "from e_01_이소민_inout i,\r\n" + 
					 "e_01_이소민_product p,\r\n" + 
					 "e_01_이소민_company c\r\n" + 
					 "where i.p_code = p.p_code\r\n" + 
					 "and i.c_code = c.c_code\r\n" + 
					 "order by i.t_no";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String t_no = rs.getNString("t_no");
				String p_code = rs.getNString("p_code");
				String p_name = rs.getNString("p_name");
				String t_type = rs.getNString("t_type");
				int t_cnt = rs.getInt("t_cnt");
				String c_name = rs.getNString("c_name");
				String t_date = rs.getNString("t_date");
				
				Dto dto = new Dto(p_code, p_name, c_name, t_no, t_type, t_date, t_cnt);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getIncomingList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//출고매출이익통계
	public ArrayList<Dto> getSalesProfit(){
		ArrayList<Dto> arr = new ArrayList<Dto>();
		String query="select i.p_code, p.p_name, sum(i.t_cnt) as t_cnt, "
				     + "to_char(sum(i.t_cnt*(p.p_outcost-p.p_incost)), 'l999,999,999') as t_profit\r\n" + 
					 "from e_01_이소민_inout i,\r\n" + 
					 "e_01_이소민_product p\r\n" + 
					 "where i.p_code = p.p_code\r\n" + 
					 "and i.t_type = 'O'\r\n" + 
					 "group by i.p_code, p.p_name\r\n" + 
					 "order by i.p_code asc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String p_code = rs.getNString("p_code");
				String p_name = rs.getNString("p_name");
				int t_cnt = rs.getInt("t_cnt");
				String t_profit = rs.getNString("t_profit");
				
				Dto dto = new Dto(p_code, p_name, t_profit, t_cnt);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getSalesProfit() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	
}


















