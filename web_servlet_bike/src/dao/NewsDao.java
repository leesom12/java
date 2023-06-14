package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.NewsDto;

public class NewsDao {
	Connection con= null;
	PreparedStatement ps= null;
	ResultSet rs= null;

	//글 개수 불러오기
	public int getTotalCount(String select, String search) {
		int count=0;
		String query=" select count(*) as count \r\n" + 
					 " from home_이소민_news n \r\n" + 
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
	
	//뉴스 번호
	public String getNewsNo() {
		String no="";
		String query=" select nvl(max(no),'N000') as no from home_이소민_news";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				no= rs.getString("no");
				no= no.substring(1);
				int no1= Integer.parseInt(no);
				no1= no1+1;
				DecimalFormat df= new DecimalFormat("N000");
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
	
	//등록
	public int saveNews(NewsDto dto) {
		int result=0;
		String query=" insert into home_이소민_news\r\n" + 
					 " (no, title, content, attach, reg_id, reg_date)\r\n" + 
					 " values\r\n" + 
					 " ('"+dto.getNo()+"', '"+dto.getTitle()+"', '"+dto.getContent()+"', '"+dto.getAttach()+"', '"+dto.getReg_id()+"', \r\n" + 
					 " to_date('"+dto.getReg_date()+"','yyyy-MM-dd hh24:mi:ss'))";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveNews() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//전체조회
	public ArrayList<NewsDto> newsList(String select, String search, int start, int end){
		ArrayList<NewsDto> arr= new ArrayList<NewsDto>();
		String query="select * from\r\n" + 
					"    (select rownum as rnum, tbl.* from\r\n" + 
					"        ( select n.no, n.title, m.name,\r\n" + 
					"         to_char(n.reg_date, 'yyyy-MM-dd')as reg_date, n.hit\r\n" + 
					"         from home_이소민_news n,\r\n" + 
					"         home_이소민_member m\r\n" + 
					"         where n.reg_id= m.id\r\n" + 
					"         and "+select+" like '%"+search+"%'\r\n" + 
					"         order by n.reg_date desc)tbl)\r\n" + 
					"where rnum >= "+start+" and rnum <= "+end+"";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String no= rs.getString("no");
				String title= rs.getString("title");
				String reg_name= rs.getString("name");
				String reg_date= rs.getString("reg_date");
				int hit= rs.getInt("hit");
				NewsDto dto= new NewsDto(no,title, reg_name, reg_date, hit);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("saveNews() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//상세조회
	public NewsDto newsView(String no) {
		NewsDto dto= null;
		String query=" select  n.title, n.content, n.attach, m.name,\r\n" + 
					 " to_char(n.reg_date, 'yyyy-MM-dd hh24:mi:ss')as reg_date, \r\n" + 
					 " n.update_date, n.hit\r\n" + 
					 " from home_이소민_news n,\r\n" + 
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
				String attach = rs.getString("attach");
				String reg_name= rs.getString("name");
				String reg_date= rs.getString("reg_date");
				String update_date= rs.getString("update_date");
				int hit= rs.getInt("hit");
				dto= new NewsDto(no,title, content, attach, reg_name, reg_date, update_date, hit);
			}
		}catch(Exception e) {
			System.out.println("saveNews() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	//조회수
	public void hitUpdate(String no) {
		String query=" update home_이소민_news\r\n" + 
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
	public NewsDto preNo(String no) {
		NewsDto dto = null;
		String query=" select a.no, b.title \r\n" + 
					 " from (select max(no) as no from home_이소민_news\r\n" + 
					 " where no < '"+no+"') a,\r\n" + 
					 " home_이소민_news b \r\n" + 
					 " where a.no=b.no";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String preNo= rs.getString("no");
				String preTitle= rs.getString("title");
				dto= new NewsDto(preNo, preTitle);
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
	public NewsDto nextNo(String no) {
		NewsDto dto = null;
		String query=" select a.no, b.title \r\n" + 
					 " from (select min(no) as no from home_이소민_news\r\n" + 
					 " where no > '"+no+"') a,\r\n" + 
					 " home_이소민_news b \r\n" + 
					 " where a.no=b.no";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String nextNo= rs.getString("no");
				String nextTitle= rs.getString("title");
				dto= new NewsDto(nextNo, nextTitle);
			}
		}catch(Exception e) {
			System.out.println("nextNo() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	//수정
	public int updateNews(NewsDto dto) {
		int result=0;
		String query=" update home_이소민_news\r\n" + 
					 " set title='"+dto.getTitle()+"', content='"+dto.getContent()+"', attach='"+dto.getAttach()+"'\r\n" + 
					 " update_date=to_date('"+dto.getUpdate_date()+"','yyyy-MM-dd hh24:mi:ss')\r\n" + 
					 " where no='"+dto.getNo()+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("updateNews() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//삭제
	public int deleteNews(String no) {
		int result=0;
		String query=" delete from home_이소민_news\r\n" + 
					 " where no='"+no+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("updateNews() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
