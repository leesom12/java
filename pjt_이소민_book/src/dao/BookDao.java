package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.BookDto;

public class BookDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	
	//회원조회
	public ArrayList<BookDto> memberList(){
		ArrayList<BookDto> arr = new ArrayList<BookDto>();
		String query= "select \r\n" + 
					 "p_no, p_name, \r\n" + 
					 "to_char(to_date(p_birth),'yyyy\"년\"MM\"월\"dd\"일\"') as p_birth, \r\n" + 
					 "decode(p_gender, 'M', '남자', 'F', '여자')as p_gender, \r\n" + 
					 "p_tel1, p_tel2, p_tel3, \r\n" + 
					 "to_char(to_date(p_reg_date),'yyyy-MM-dd') as p_reg_date\r\n" + 
					 "from e_07_이소민_client";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String p_no = rs.getNString("p_no");
				String p_name = rs.getNString("p_name");
				String p_birth = rs.getNString("p_birth");
				String p_gender = rs.getNString("p_gender");
				String p_tel1 = rs.getNString("p_tel1");
				String p_tel2 = rs.getNString("p_tel2");
				String p_tel3 = rs.getNString("p_tel3");
				String p_tel = p_tel1+"-"+p_tel2+"-"+p_tel3;
				String p_reg_date = rs.getNString("p_reg_date");
				
				BookDto dto = new BookDto(p_no, p_name, p_birth, p_gender, p_tel, p_reg_date);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("memberList() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	};
	
	
	//자동생성 대여번호
	public String getRentNo() {
		String rentno="";
		String query="select nvl(max(p_rentno),'20200000') as rentno\r\n" + 
					 "from e_07_이소민_bookrent";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				rentno = rs.getNString("rentno");
				int no = Integer.parseInt(rentno);
				no = no+1;
				rentno = Integer.toString(no);
			}
		}catch(Exception e) {
			System.out.println("getRentNo() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return rentno;
	}
	
	//도서대여등록
	public int bookrentSave(BookDto dto) {
		int result = 0;
		String query="insert into e_07_이소민_bookrent\r\n" + 
					 "(p_rentno, p_no, b_code, p_s_date, p_e_date)\r\n" + 
					 "values\r\n" + 
					 "('"+dto.getP_rentno()+"', '"+dto.getP_no()+"', '"+dto.getB_code()+"', "
					 		+ "to_date('"+dto.getP_s_date()+"', 'yyyyMMdd'), to_date('"+dto.getP_e_date()+"', 'yyyyMMdd'))";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("getRentNo() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//도서 대여 이력 조회
	public ArrayList<BookDto> bookrentList(){
		ArrayList<BookDto> arr = new ArrayList<BookDto>();
		String query="select r.p_rentno, c.p_no, c.p_name, b.b_code, b.b_name, \r\n" + 
					 "to_char(r.p_s_date, 'yyyy-MM-dd')as p_s_date, to_char(r.p_e_date,'yyyy-MM-dd')as p_e_date\r\n" + 
					 "from e_07_이소민_client c,\r\n" + 
					 "e_07_이소민_bookrent r,\r\n" + 
					 "e_07_이소민_book b\r\n" + 
					 "where c.p_no = r.p_no\r\n" + 
					 "and r.b_code = b.b_code\r\n"+
					 "order by r.p_rentno";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String p_rentno = rs.getNString("p_rentno");
				String p_no = rs.getNString("p_no");
				String p_name = rs.getNString("p_name");
				String b_code = rs.getNString("b_code");
				String b_name = rs.getNString("b_name");
				String p_s_date = rs.getNString("p_s_date");
				String p_e_date = rs.getNString("p_e_date");
				if(p_e_date == null) p_e_date="미납";
				
				BookDto dto = new BookDto(p_no, p_name, p_rentno, b_code, p_s_date, p_e_date, b_name);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("memberList() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//책 조회
	public ArrayList<BookDto> bookList(){
		ArrayList<BookDto> arr= new ArrayList<BookDto>();
		String query="select b.b_code, b.b_name, b.b_publisher, count(b.b_code) as count\r\n" + 
					 "from e_07_이소민_book b,\r\n" + 
					 "e_07_이소민_bookrent r\r\n" + 
					 "where b.b_code = r.b_code\r\n" + 
					 "group by b.b_code, b.b_name, b.b_publisher\r\n" + 
					 "order by b.b_code";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String b_code= rs.getString("b_code");
				String b_name= rs.getString("b_name");
				String publisher= rs.getString("b_publisher");
				int count = rs.getInt("count");
				
				BookDto dto = new BookDto(b_code, b_name, publisher, count);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("rentList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
}













