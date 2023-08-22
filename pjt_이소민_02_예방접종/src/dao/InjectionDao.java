package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.InjectionDto;

public class InjectionDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs= null;
	
	//백신접종건수 조회
	public ArrayList<InjectionDto> getInjectionCount(){
		ArrayList<InjectionDto> arr = new ArrayList<InjectionDto>();
		String query="select i.i_code, i.i_name, count(o.i_code) count\r\n" + 
					 "from e_02_이소민_order o,\r\n" + 
					 "e_02_이소민_injection i\r\n" + 
					 "where i.i_code = o.i_code(+) \r\n" + 
					 "group by i.i_code, i.i_name\r\n" + 
					 "order by i.i_code";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String i_code = rs.getNString("i_code");
				String i_name = rs.getNString("i_name");
				int count = rs.getInt("count");
				InjectionDto dto = new InjectionDto(i_code, i_name, count);
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
	
	//접종이력조회
	public ArrayList<InjectionDto> getOrderList(){
		ArrayList<InjectionDto> arr = new ArrayList<InjectionDto>();
		String query="select to_char(o.p_seno) p_seno, c.p_no, c.p_name, o.i_code, i.i_name, to_char(o.p_date,'yyyy-MM-dd') p_date\r\n" + 
					 "from e_02_이소민_order o,\r\n" + 
					 "e_02_이소민_cust c,\r\n" + 
					 "e_02_이소민_injection i\r\n" + 
					 "where o.p_no = c.p_no and o.i_code=i.i_code\r\n"+
					 "order by o.p_seno";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String seno= rs.getNString("p_seno");
				String p_seno = seno.substring(0, 4)+"-"+seno.substring(4);
				String p_no = rs.getNString("p_no");
				String p_name = rs.getNString("p_name");
				String i_code = rs.getNString("i_code");
				String i_name = rs.getNString("i_name");
				String p_date = rs.getNString("p_date");
				
				InjectionDto dto = new InjectionDto(p_no, p_name, p_seno, i_code, p_date, i_name);
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
	
	
	//예방접종등록
	public int saveOrderList(InjectionDto dto) {
		int result = 0;
		String query="insert into e_02_이소민_order values ('"+dto.getP_seno()+"', '"+dto.getP_no()+"', '"+dto.getI_code()+"', to_date('"+dto.getP_date()+"', 'yyyyMMdd'))";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveOrderList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	//고객조회
	public ArrayList<InjectionDto> getMemberList(){
		ArrayList<InjectionDto> arr = new ArrayList<InjectionDto>();
		String query="select  p_no, p_name, to_char(to_date(p_birth),'yyyy\"년\"MM\"월\"dd\"일\"') p_birth, \r\n" + 
					 "decode(p_gender, 'M', '남', '여') p_gender, p_tel1, p_tel2, p_tel3, decode(p_city, '10','서울', '20','경기', '30','강원', '40','대구') p_city,\r\n" + 
					 "trunc(months_between(trunc(sysdate), to_date(p_birth,'YYYYMMDD')) / 12) p_age\r\n" + 
					 "from e_02_이소민_cust\r\n"+
					 "order by p_no";;
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String p_no = rs.getNString("p_no");
				String p_name = rs.getNString("p_name");
				String p_birth = rs.getNString("p_birth");
				String p_gender  = rs.getNString("p_gender");
				String p_tel1 = rs.getNString("p_tel1");
				String p_tel2 = rs.getNString("p_tel2");
				String p_tel3 = rs.getNString("p_tel3");
				String p_tel = p_tel1+"-"+p_tel2+"-"+p_tel3;
				String p_city = rs.getNString("p_city");
				String p_age = rs.getNString("p_age");
				
				InjectionDto dto = new InjectionDto(p_no, p_name, p_birth, p_gender, p_tel, p_city, p_age);
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
}
