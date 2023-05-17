package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.BookDto;

public class BookDao {
	Connection con = null;
	PreparedStatement ps= null;
	ResultSet rs= null;
	
	//대여 번호 부여
	public int getRentNo() {
		int no=0;
		String query="select nvl(max(p_rentno),'20230000') as no from e_이소민_bookrent";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				no= rs.getInt("no");
				String no1= Integer.toString(no);
				no1= no1.substring(4);
				no= Integer.parseInt(no1);
				no= no+1;
				DecimalFormat df= new DecimalFormat("0000");
				no1="2023"+df.format(no);
				no= Integer.parseInt(no1);
			}
		}catch(Exception e) {
			System.out.println("getRentNo() 오류: "+query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return no;
	}
	
	
	//도서 대여 등록
	public int rentSave(BookDto dto) {
		int result= 0;
		String query="insert into e_이소민_bookrent\r\n" + 
					 "(p_rentno, p_no, b_code, p_s_date)\r\n" + 
					 "values\r\n" + 
					 "('"+dto.getNo()+"', '"+dto.getP_no()+"', '"+dto.getCode()+"', to_date('"+dto.getRent_date()+"', 'yyyy-MM-dd'))";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("rentSave() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//회원 번호 유무검사
	public int checkPNo(String p_no) {
		int count=0;
		String query="select count(*) as count\r\n" + 
					 "from e_이소민_client\r\n" + 
					 "where p_no='"+p_no+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				count= rs.getInt("count");
			}
		}catch(Exception e) {
			System.out.println("checkPNo() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}
	
		//도서 번호 유무검사
		public int checkBCode(String b_code) {
			int count=0;
			String query="select count(*) as count\r\n" + 
						 "from e_이소민_book\r\n" + 
						 "where b_code='"+b_code+"'";
			try {
				con= DBConnection.getConnection();
				ps= con.prepareStatement(query);
				rs= ps.executeQuery();
				if(rs.next()) {
					count= rs.getInt("count");
				}
			}catch(Exception e) {
				System.out.println("checkBCode() 오류: "+query);
				e.printStackTrace();
			}finally {
				DBConnection.closeDB(con, ps, rs);
			}
			return count;
		}
		
	//대여 이력 조회
	public ArrayList<BookDto> rentList(){
		ArrayList<BookDto> arr= new ArrayList<BookDto>();
		String query="select r.p_rentno, r.p_no, c.p_name, r.b_code, b.b_name, \r\n" + 
					 "to_char(r.p_s_date, 'yyyy-MM-dd') as p_s_date, to_char(r.p_e_date, 'yyyy-MM-dd') as p_e_date\r\n" + 
					 "from e_이소민_client c,\r\n" + 
					 " e_이소민_bookrent r,\r\n" + 
					 " e_이소민_book b\r\n" + 
					 " where r.p_no= c.p_no\r\n" + 
					 " and r.b_code= b.b_code\r\n" + 
					 " order by p_s_date desc";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				int no= rs.getInt("p_rentno");
				String p_no= rs.getString("p_no");
				String p_name= rs.getString("p_name");
				String b_code= rs.getString("b_code");
				String b_name= rs.getString("b_name");
				String rent_date= rs.getString("p_s_date");
				String return_date= rs.getString("p_e_date");
				if(return_date == null) return_date="미납";
				
				BookDto dto = new BookDto(no, p_no, p_name, b_code, b_name, rent_date, return_date);
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
	
	//책 조회
	public ArrayList<BookDto> bookList(){
		ArrayList<BookDto> arr= new ArrayList<BookDto>();
		String query="select b_code, b_name, b_publisher\r\n" + 
					 "from e_이소민_book\r\n" + 
					 "order by b_code";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String b_code= rs.getString("b_code");
				String b_name= rs.getString("b_name");
				String publisher= rs.getString("b_publisher");
				
				BookDto dto = new BookDto(b_code, b_name, publisher);
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
	
	//건수 조회
	public int getRentNum(String b_code) {
		int count=0;
		String query="select count(*) as count\r\n" + 
					 "from e_이소민_bookrent\r\n" + 
					 "where b_code='"+b_code+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				count= rs.getInt("count");
			}
		}catch(Exception e) {
			System.out.println("getRentNo() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}	
}














