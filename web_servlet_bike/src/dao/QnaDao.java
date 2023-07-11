package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.QnaDto;

public class QnaDao {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	//전체 조회
	public ArrayList<QnaDto> getQnaList(String select, String search, int start, int end){
		ArrayList<QnaDto> arr = new ArrayList<QnaDto>();
		String query="select * from\r\n" + 
					 "(select rownum as rnum, tbl.* from\r\n" + 
					 "(select q.no, q.title, m.name as reg_name, to_char(q.reg_date, 'yyyy-MM-dd') as reg_date, q.state, q.hit\r\n" + 
					 "from bike_이소민_qna q,\r\n" + 
					 "bike_이소민_member m\r\n" + 
					 "where q.reg_id = m.id\r\n" + 
					 "and "+select+" like '%"+search+"%'\r\n" + 
					 ")tbl) where rnum >= "+start+" and rnum <= "+end+"";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getNString("no");
				String title = rs.getNString("title");
				String reg_name = rs.getNString("reg_name");
				String reg_date = rs.getNString("reg_date");
				String state = rs.getNString("state");
				int hit = rs.getInt("hit");
				
				QnaDto dto = new QnaDto(no, title, reg_name, reg_date, state, hit);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getQnaList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//질문 등록
	public int saveQuestion(QnaDto dto) {
		int result = 0;
		String query="insert into bike_이소민_qna\r\n" + 
					 "(no, title, content, reg_id, reg_date)\r\n" + 
					 "values\r\n" + 
					 "('"+dto.getNo()+"', '"+dto.getTitle()+"', '"+dto.getContent()+"', '"+dto.getReg_id()+"',"
					 		+ " to_date('"+dto.getReg_date()+"', 'yyyy-MM-dd hh24:mi:ss'))";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveQuestion() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//게시글 번호 생성
	public String getMaxNo() {
		String no = "";
		String query="select nvl(max(no), 'Q000') as no from bike_이소민_qna";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				no = rs.getString("no");
				no = no.substring(1);
				int n = Integer.parseInt(no);
				n++;
				DecimalFormat df= new DecimalFormat("Q000");
				no=df.format(n);
			}
		}catch(Exception e) {
			System.out.println("getMaxNo() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return no;
	}

	//게시글 개수 불러오기
	public int getTotalCount(String select, String search) {
		int count=0;
		String query=" select count(*) as count \r\n" + 
				 " from bike_이소민_qna q \r\n" + 
				 " where "+select+" like '%"+search+"%'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) count= rs.getInt("count");
		}catch(Exception e) {
			System.out.println("getTotalCount() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}
	
}
