package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;


import common.DBConnection;
import dto.FaqDto;

public class FaqDao {
	Connection con= null;
	PreparedStatement ps= null;
	ResultSet rs= null;
	
	//글 개수 구하기
	public int getTotalCount(String select, String search) {
		int count=0;
		String query="select count(*)as count\r\n" + 
					"from home_이소민_faq f\r\n" + 
					"where "+select+" like '%"+search+"%'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) count= rs.getInt("count");
		}catch(Exception e){
			System.out.println("getTotalCount() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}
	
	
	//번호
	public String getNo() {
		String no="";
		String query="select nvl(max(no),'F000') as no from home_이소민_faq";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				no= rs.getString("no");
				no= no.substring(1);
				int no1= Integer.parseInt(no)+1;
				DecimalFormat df= new DecimalFormat("F000");
				no= df.format(no1);
			}
		}catch(Exception e) {
			System.out.println("getNo() 오류:"+ query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return no;
	}
	
	//등록
	public int saveFaq(FaqDto dto) {
		int result=0;
		String query="insert into home_이소민_faq\r\n" + 
					 "(no, title, content, reg_id, reg_date)\r\n" + 
					 "values\r\n" + 
					 "('"+dto.getNo()+"', '"+dto.getTitle()+"', '"+dto.getContent()+"', '"+dto.getReg_id()+"', \r\n" + 
					 "to_date('"+dto.getReg_date()+"', 'yyyy-MM-dd hh24:mi:ss'))";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveFaq() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//전체 조회
	public ArrayList<FaqDto> faqList(String select, String search, int start, int end){
		ArrayList<FaqDto> arr= new ArrayList<FaqDto>();
		String query="select * from\r\n" + 
					"(select rownum as rnum, tbl.* from\r\n" + 
					"(select f.no, f.title, f.content, f.reg_id, m.name as reg_name, \r\n" + 
					"to_char(f.reg_date, 'yyyy-MM-dd hh24:mi:ss') as reg_date, \r\n" + 
					"to_char(f.update_date, 'yyyy-MM-dd hh24:mi:ss') as update_date\r\n" + 
					"from HOME_이소민_FAQ f,\r\n" + 
					"home_이소민_member m\r\n" + 
					"where f.reg_id= m.id\r\n" + 
					"and "+select+" like '%"+search+"%'\r\n" + 
					"order by f.reg_date desc) tbl)\r\n" + 
					"where rnum >= "+start+" and rnum <= "+end+"";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String no= rs.getString("no");
				String title= rs.getString("title");
				String content= rs.getString("content");
				String reg_id= rs.getString("reg_id");
				String reg_name= rs.getString("reg_name");
				String reg_date= rs.getString("reg_date");
				String update_date= rs.getString("update_date");
				
				FaqDto dto= new FaqDto(no, title, content, reg_id, reg_name, reg_date, update_date);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("faqList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//상세 조회
	public FaqDto viewFaq(String no) {
		FaqDto dto= null;
		String query="select f.no, f.title, f.content, f.reg_id, m.name as reg_name, \r\n" + 
					"to_char(f.reg_date, 'yyyy-MM-dd hh24:mi:ss') as reg_date, \r\n" + 
					"to_char(f.update_date, 'yyyy-MM-dd hh24:mi:ss') as update_date\r\n" + 
					"from HOME_이소민_FAQ f,\r\n" + 
					"home_이소민_member m\r\n" + 
					"where f.reg_id= m.id\r\n" + 
					"and f.no='"+no+"'\r\n" + 
					"order by f.reg_date desc";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String title= rs.getString("title");
				String content= rs.getString("content");
				content= content.replaceAll("<br/>", "\r\n");
				String reg_id= rs.getString("reg_id");
				String reg_name= rs.getString("reg_name");
				String reg_date= rs.getString("reg_date");
				String update_date= rs.getString("update_date");
				
				dto= new FaqDto(no, title, content, reg_id, reg_name, reg_date, update_date);
			}
		}catch(Exception e) {
			System.out.println("viewFaq() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	//수정
	public int updateFaq(FaqDto dto) {
		int result=0;
		String query="update home_이소민_faq\r\n" + 
					 "set title='"+dto.getTitle()+"', content='"+dto.getContent()+"', update_date= to_date('"+dto.getUpdate_date()+"', 'yyyy-MM-dd hh24:mi:ss')\r\n" + 
					 "where no='"+dto.getNo()+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveFaq() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;	
	}
	
	//삭제
	public int deleteFaq(String no) {
		int result=0;
		String query="delete from home_이소민_faq\r\n" + 
					 "where no='"+no+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveFaq() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;	
	}
	
	
	
	
}
