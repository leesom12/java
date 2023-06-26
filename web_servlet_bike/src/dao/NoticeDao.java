package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.NoticeDto;

public class NoticeDao {
	Connection con= null;
	PreparedStatement ps= null;
	ResultSet rs= null;
	
//	//인덱스 리스트에 뜨는 목록
//	public ArrayList<NoticeDto> getIndexNoticeList(){
//		ArrayList<NoticeDto> arr = new ArrayList<NoticeDto>();
//		String query="select * from\r\n" + 
//					 "(select rownum as rnum, tbl.* from\r\n" + 
//					 "(select no, title, to_char(reg_date, 'yyyy-MM-dd') as reg_date from home_이소민_notice\r\n" + 
//					 "order by reg_date desc)\r\n" + 
//					 "tbl)\r\n" + 
//					 "where rnum>=1 and rnum<=7";
//		try {
//			con = DBConnection.getConnection();
//			ps= con.prepareStatement(query);
//			rs= ps.executeQuery();
//			while(rs.next()) {
//				String no = rs.getString("no");
//				String title = rs.getString("title");
//				String reg_date = rs.getString("reg_date");
//				NoticeDto dto = new NoticeDto(no, title, reg_date);
//				arr.add(dto);
//			}
//		}catch(Exception e) {
//			System.out.println("getIndexNoticeList() 오류: "+query);
//			e.printStackTrace();
//		}finally {
//			DBConnection.closeDB(con, ps, rs);
//		}
//		return arr;
//	}
	
	// 페이징+리스트
	public ArrayList<NoticeDto> noticeListPage(String select, String search, int start, int end){
		ArrayList<NoticeDto> arr= new ArrayList<NoticeDto>();
		String query=" select * from(\r\n" + 
					 "     select rownum as rnum, tbl.* from (\r\n" + 
					 "         select n.no, n.title, n.content, n.attach, m.name,\r\n" + 
					 "         to_char(n.reg_date, 'yy-MM-dd')as reg_date, n.hit\r\n" + 
					 "         from home_이소민_notice n,\r\n" + 
					 "         home_이소민_member m\r\n" + 
					 "         where n.reg_id= m.id\r\n" + 
					 "         and "+select+" like '%"+search+"%'\r\n" + 
					 "         order by no desc\r\n" + 
					 "    ) tbl\r\n" + 
					 ") where rnum >= "+start+" and rnum <= "+end+"";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String no= rs.getString("no");
				String title= rs.getString("title");
				String content= rs.getString("content");
				String attach= rs.getString("attach");
				String name= rs.getString("name");
				String reg_date= rs.getString("reg_date");
				int hit= rs.getInt("hit");
				NoticeDto dto = new NoticeDto(no, title, content, attach, name, reg_date, hit);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("noticeList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//글 개수 불러오기
	public int getTotalCount(String select, String search) {
		int count=0;
		String query=" select count(*) as count \r\n" + 
					 " from home_이소민_notice n \r\n" + 
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
	
	
	//게시글 번호 생성
	public String getMaxNo() {
		String no="";
		String query="select nvl(max(no),'N000') as no from home_이소민_notice";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				no= rs.getString("no");
				no= no.substring(1);
				int n= Integer.parseInt(no);
				n++;
				DecimalFormat df= new DecimalFormat("N000");
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
	
	//저장
	public int saveNotice(NoticeDto dto) {
		int result=0;
		String query=" insert into home_이소민_notice\r\n" + 
					 " (no, title, content, attach, reg_id, reg_date)\r\n" + 
					 " values\r\n" + 
					 " ('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getAttach()+"','"+dto.getReg_id()+"', to_date('"+dto.getReg_date()+"','yyyy-MM-dd hh24:mi:ss') )";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveNotice() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
//	//조회
//	public ArrayList<NoticeDto> noticeList(String gubun, String search) {
//		ArrayList<NoticeDto> arr= new ArrayList<NoticeDto>();
//		String query=" select n.no, n.title, n.attach, m.name,\r\n" + 
//					 " to_char(n.reg_date, 'yy-MM-dd')as reg_date, n.hit\r\n" + 
//					 " from home_이소민_notice n,\r\n" + 
//					 " home_이소민_member m\r\n" + 
//					 " where n.reg_id= m.id\r\n" + 
//					 " and "+gubun+" like '%"+search+"%'\r\n" + 
//					 " order by no desc";
//		try {
//			con= DBConnection.getConnection();
//			ps= con.prepareStatement(query);
//			rs= ps.executeQuery();
//			while(rs.next()) {
//				String no= rs.getString("no");
//				String title= rs.getString("title");
//				String attach= rs.getString("attach");
//				String name= rs.getString("name");
//				String reg_date= rs.getString("reg_date");
//				int hit= rs.getInt("hit");
//				NoticeDto dto = new NoticeDto(no, title, attach, name, reg_date, hit);
//				arr.add(dto);
//			}
//		}catch(Exception e) {
//			System.out.println("noticeList() 오류: "+query);
//			e.printStackTrace();
//		}finally {
//			DBConnection.closeDB(con, ps, rs);
//		}
//		return arr;
//	}
	
	//상세보기
	public NoticeDto noticeView(String no) {
		NoticeDto dto= null;
		String query=" select n.no ,n.title, n.content, n.attach, m.name, \r\n" + 
					 " to_char(n.reg_date, 'yyyy-MM-dd hh24:mi:ss')as reg_date, n.hit\r\n" + 
					 " from home_이소민_notice n,\r\n" + 
					 " home_이소민_member m\r\n" + 
					 " where n.reg_id= m.id\r\n" + 
					 " and no='"+no+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String title= rs.getString("title");
				String content= rs.getString("content");
				String attach= rs.getString("attach");
				String name= rs.getString("name");
				String reg_date= rs.getString("reg_date");
				int hit= rs.getInt("hit");
				
				dto=new NoticeDto(no, title, content, attach, name, reg_date, hit);
			}
		}catch(Exception e) {
			System.out.println("noticeView() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	//조회수
	public void hitUpdate(String no) {
		String query=" update home_이소민_notice\r\n" + 
					 " set hit= hit+1\r\n" + 
					 " where no='"+no+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			int result= ps.executeUpdate();
			if(result == 0) System.out.println("공지사항 조회수 hitUpdate() 오류:"+query);
		}catch(Exception e) {
			System.out.println("hitUpdate() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
	}
	
	//이전글
	public NoticeDto preView(String no) {
		NoticeDto dto= null;
		String query=" select a.no, b.title from \r\n" + 
					 " (select max(no) as no from home_이소민_notice\r\n" + 
					 " where no < '"+no+"') a,\r\n" + 
					 " home_이소민_notice b where a.no=b.no";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String preNo= rs.getString("no");
				String title = rs.getString("title");
				dto= new NoticeDto(preNo, title);
			}
		}catch(Exception e) {
			System.out.println("preView() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	//다음글
	public NoticeDto nextView(String no) {
		NoticeDto dto= null;
		String query="  select a.no, b.title from \r\n" + 
					 " (select min(no) as no from home_이소민_notice\r\n" + 
					 " where no > '"+no+"') a,\r\n" + 
					 " home_이소민_notice b where a.no=b.no";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String preNo= rs.getString("no");
				String title = rs.getString("title");
				dto= new NoticeDto(preNo, title);
			}
		}catch(Exception e) {
			System.out.println("preView() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	//수정
	public int updateNotice(NoticeDto dto) {
		int result=0;
		String query=" update home_이소민_notice\r\n" + 
					 " set title='"+dto.getTitle()+"', content='"+dto.getContent()+"', attach='"+dto.getAttach()+"'\r\n" + 
					 " where no='"+dto.getNo()+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("updateNotice() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	//삭제
	public int noticeDelte(String no) {
		int result=0;
		String query= " delete from home_이소민_notice\r\n" + 
					  " where no='"+no+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("noticeDelete() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	
	
	
	
	
}
