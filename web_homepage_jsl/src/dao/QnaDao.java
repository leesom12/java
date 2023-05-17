package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import common.DBConnection;
import dto.QnaDto;

public class QnaDao {

	Connection con= null;
	PreparedStatement ps= null;
	ResultSet rs= null;
	
	//게시글 개수
	public int getTotalCount(String select, String search) {
		int count=0;
		String query= "select count(*) as count \r\n" + 
					  " from home_이소민_qna q  \r\n" + 
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
	
	//질문 번호
	public String getNo() {
		String no="";
		String query=" select nvl(max(no),'Q000') as no from home_이소민_qna";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				no= rs.getString("no");
				no= no.substring(1);
				int no1= Integer.parseInt(no);
				no1= no1+1;
				DecimalFormat df= new DecimalFormat("Q000");
				no=df.format(no1);
			}
		}catch(Exception e) {
			System.out.println("getNewsNo() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return no;
	}
	
	//질문 등록
	public int questionSave(QnaDto dto) {
		int result=0;
		String query="insert into home_이소민_qna\r\n" + 
					 "(no, title, content, reg_id, reg_date)\r\n" + 
					 "values\r\n" + 
					 "('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getReg_id()+"',\r\n" + 
					 " to_date('"+dto.getReg_date()+"','yyyy-MM-dd hh24:mi:ss'))";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("questionSave() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//조회
	public ArrayList<QnaDto> qnaList(String select, String search, int start, int end){
		ArrayList<QnaDto> arr= new ArrayList<QnaDto>();
		String query="select * from\r\n" + 
					 "    (select rownum as rnum, tbl.* from\r\n" + 
				 	 "        (select \r\n" + 
					 "        q.no, q.title, q.answer_content, m.name as reg_name, \r\n" + 
					 "        to_char(q.reg_date, 'yyyy-MM-dd')as reg_date, q.hit\r\n" + 
					 "        from home_이소민_qna q,\r\n" + 
					 "        home_이소민_member m\r\n" + 
					 "        where q.reg_id= m.id\r\n" + 
					 "        and "+select+" like '%"+search+"%'\r\n" + 
					 "        order by q.reg_date desc\r\n" + 
					 "    ) tbl\r\n" + 
					 ")where rnum >="+start+" and rnum <= "+end+"";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String no= rs.getString("no");
				String title= rs.getString("title");
				String answer_content= rs.getString("answer_content");
				String reg_name= rs.getString("reg_name");
				String reg_date=rs.getString("reg_date");
				int hit= rs.getInt("hit");
				
				QnaDto dto= new QnaDto(no, title, answer_content, reg_name, reg_date, hit);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("qnaList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//상세조회
	public QnaDto qnaView(String no) {
		QnaDto dto= null;
		String query="select\r\n" + 
					 "q.no, q.title, q. reg_id, m.name as reg_name, \r\n" + 
					 "to_char(q.reg_date, 'yyyy-MM-dd hh24:mi:ss')as reg_date,\r\n" + 
					 "to_char(q.update_date, 'yyyy-MM-dd hh24:mi:ss')as update_date, q.hit, q.content,\r\n" + 
					 "q.answer_content, q.answer_id, q.answer_reg_date, q.answer_update_date\r\n" + 
					 "from home_이소민_qna q,\r\n" + 
					 "home_이소민_member m\r\n" + 
					 "where q.reg_id= m.id\r\n" + 
					 "and no='"+no+"'";

		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String title= rs.getString("title");
				String reg_id= rs.getString("reg_id");
				String reg_name= rs.getString("reg_name");
				String reg_date=rs.getString("reg_date");
				String update_date=rs.getString("update_date");
				int hit= rs.getInt("hit");
				String content= rs.getString("content");
				String answer_content= rs.getString("answer_content");
				String answer_id= rs.getString("answer_id");
				String answer_reg_date= rs.getString("answer_reg_date");
				String answer_update_date= rs.getString("answer_update_date");
				
				dto= new QnaDto(no, title, reg_id, reg_name, reg_date, update_date, hit, content, answer_content, answer_id, answer_reg_date, answer_update_date);
			}
		}catch(Exception e) {
			System.out.println("qnaList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	//조회수
	public void hitUpdate(String no) {
		String query=" update home_이소민_qna\r\n" + 
					 " set hit= hit+1\r\n" + 
					 " where no='"+no+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			int result= ps.executeUpdate();
			if(result == 0) System.out.println("뉴스 조회수 hitUpdate() 오류:"+query);
		}catch(Exception e) {
			System.out.println("hitUpdate() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
	}
	
	//이전글
	public QnaDto preNo(String no) {
		QnaDto dto = null;
		String query=" select a.no, b.title \r\n" + 
					 " from (select max(no) as no from home_이소민_qna\r\n" + 
					 " where no < '"+no+"') a,\r\n" + 
					 " home_이소민_qna b \r\n" + 
					 " where a.no=b.no";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String preNo= rs.getString("no");
				String preTitle= rs.getString("title");
				dto= new QnaDto(preNo, preTitle);
			}
		}catch(Exception e) {
			System.out.println("preNo() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}

	//다음글
	public QnaDto nextNo(String no) {
		QnaDto dto = null;
		String query=" select a.no, b.title \r\n" + 
					 " from (select min(no) as no from home_이소민_qna\r\n" + 
					 " where no > '"+no+"') a,\r\n" + 
					 " home_이소민_qna b \r\n" + 
					 " where a.no=b.no";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String preNo= rs.getString("no");
				String preTitle= rs.getString("title");
				dto= new QnaDto(preNo, preTitle);
			}
		}catch(Exception e) {
			System.out.println("nextNo() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	//질문 수정
	public int questionUpdate(QnaDto dto) {
		int result=0;
		String query="update home_이소민_qna\r\n" + 
					 "set title='"+dto.getTitle()+"', content='"+dto.getContent()+"', \r\n" + 
					 "update_date=to_date('"+dto.getUpdate_date()+"','yyyy-MM-dd hh24:mi:ss')\r\n" + 
					 "where no='"+dto.getNo()+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("questionUpdate() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	//질문 삭제
	public int questionDelete(String no) {
		int result=0;
		String query=" delete from home_이소민_qna\r\n" + 
					 " where no='"+no+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("questionUpdate() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//답변 등록
	public int replySave(QnaDto dto) {
		int result=0;
		String query="update home_이소민_qna\r\n" + 
					 "set answer_id='"+dto.getAnswer_id()+"', answer_content='"+dto.getAnswer_content()+"', \r\n" + 
					 "answer_reg_date=to_date('"+dto.getAnswer_reg_date()+"','yyyy-MM-dd hh24:mi:ss'), \r\n" + 
					 "attach='"+dto.getAttach()+"' \r\n" + 
					 "where no='"+dto.getNo()+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("replySave() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	//답변 수정
	public int replyUpdate(QnaDto dto) {
		int result=0;
		String query="update home_이소민_qna\r\n" + 
				 	 "set answer_content='"+dto.getAnswer_content()+"', \r\n" + 
					 "answer_update_date=to_date('"+dto.getAnswer_update_date()+"','yyyy-MM-dd hh24:mi:ss'), \r\n" + 
					 "attach='"+dto.getAttach()+"' \r\n" + 
					 "where no='"+dto.getNo()+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("replyUpdate() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//답변 삭제
	public int replyDelete(String no) {
		int result=0;
		String query="update home_이소민_qna\r\n" + 
					 "set answer_id='', answer_content='', answer_reg_date='', \r\n" + 
					 "answer_update_date='' ,attach='' \r\n" + 
					 "where no='"+no+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("replyDelete() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
