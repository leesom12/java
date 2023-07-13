package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.FreeBoardDto;

public class FreeBoardDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//첨부파일 다운로드 수
	public void downloadHit_update(String no) {
		String query=" update bike_이소민_freeboard\r\n" + 
					 " set download_hit= download_hit+1\r\n" + 
					 " where no='"+no+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			int result= ps.executeUpdate();
			if(result == 0) System.out.println("downloadHit_update() 오류:"+query);
		}catch(Exception e) {
			System.out.println("downloadHit_update() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
	}
	
	
	//삭제
	public int deleteFreeBoard(String no) {
		int result = 0;
		String query="delete bike_이소민_freeboard\r\n" + 
					 "where no = '"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("deleteFreeBoard() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//업데이트
	public int updateFreeBoard(FreeBoardDto dto) {
		int result =0;
		String query="update bike_이소민_freeboard\r\n" + 
					 "set title='"+dto.getTitle()+"', content='"+dto.getContent()+"', attach='"+dto.getAttach()+"', "
					 		+ "update_date=to_date('"+dto.getUpdate_date()+"', 'yyyy-MM-dd hh24:mi:ss')\r\n" + 
					 "where no ='"+dto.getNo()+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("updateFreeBoard() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	//조회수
	public void hitUpdate(String no) {
		String query=" update bike_이소민_freeboard\r\n" + 
					 " set hit= hit+1\r\n" + 
					 " where no='"+no+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			int result= ps.executeUpdate();
			if(result == 0) System.out.println("hitUpdate() 오류:"+query);
		}catch(Exception e) {
			System.out.println("hitUpdate() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
	}
	
	
	//이전글
	public FreeBoardDto preNo(String no) {
		FreeBoardDto dto = null;
		String query=" select a.no, b.title \r\n" + 
					 " from (select max(no) as no from bike_이소민_freeboard\r\n" + 
					 " where no < '"+no+"') a,\r\n" + 
					 " bike_이소민_freeboard b \r\n" + 
					 " where a.no=b.no";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String preNo= rs.getString("no");
				String preTitle= rs.getString("title");
				dto= new FreeBoardDto(preNo, preTitle);
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
	public FreeBoardDto nextNo(String no) {
		FreeBoardDto dto = null;
		String query=" select a.no, b.title \r\n" + 
					 " from (select min(no) as no from bike_이소민_freeboard\r\n" + 
					 " where no > '"+no+"') a,\r\n" + 
					 " bike_이소민_freeboard b \r\n" + 
					 " where a.no=b.no";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String nextNo= rs.getString("no");
				String nextTitle= rs.getString("title");
				dto= new FreeBoardDto(nextNo, nextTitle);
			}
		}catch(Exception e) {
			System.out.println("nextNo() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	
	//상세보기
	public FreeBoardDto viewFreeBoard(String no) {
		FreeBoardDto dto = null;
		String query="select f.no, f.title, f.attach, f.content, f.reg_id, m.name as reg_name,  f.hit, f.download_hit,\r\n" + 
					 "to_char(f.reg_date, 'yyyy-MM-dd hh24:mi:ss') as reg_date, to_char(f.update_date, 'yyyy-MM-dd hh24:mi:ss') as update_date\r\n" + 
					 "from bike_이소민_freeboard f,\r\n" + 
					 "bike_이소민_member m\r\n" + 
					 "where f.reg_id = m.id\r\n" + 
					 "and f.no = '"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				String title = rs.getNString("title");
				String attach = rs.getNString("attach");
				String content = rs.getNString("content");
				String reg_id = rs.getNString("reg_id");
				String reg_name = rs.getNString("reg_name");
				String reg_date = rs.getNString("reg_date");
				String update_date = rs.getNString("update_date");
				int hit = rs.getInt("hit");
				int download_hit = rs.getInt("download_hit");
				
				dto = new FreeBoardDto(no, title, content, attach, reg_id, reg_name, reg_date, update_date, hit, download_hit);
			}
		}catch(Exception e) {
			System.out.println("viewFreeBoard() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	//전체 조회
	public ArrayList<FreeBoardDto> getFreeboardList(String select, String search, int start, int end){
		ArrayList<FreeBoardDto> arr = new ArrayList<FreeBoardDto>();
		String query="select * from\r\n" + 
					 "(select rownum as rnum, tbl.* from\r\n" + 
					 "(select f.no, f.title, f.attach, m.name as reg_name, to_char(f.reg_date, 'yyyy-MM-dd') as reg_date, f.hit\r\n" + 
					 "from bike_이소민_freeboard f,\r\n" + 
					 "bike_이소민_member m\r\n" + 
					 "where f.reg_id = m.id\r\n" + 
					 "and "+select+" like '%"+search+"%'\r\n"
					 +"order by f.reg_date desc\r\n"
					 + ") tbl) where rnum >="+start+" and rnum <= "+end+"";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getNString("no");
				String title = rs.getNString("title");
				String attach = rs.getNString("attach");
				String reg_name = rs.getNString("reg_name");
				String reg_date = rs.getNString("reg_date");
				int hit = rs.getInt("hit");
				FreeBoardDto dto = new FreeBoardDto(no, title, attach, reg_name, reg_date, hit);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getFreeboardList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//등록
	public int saveFreeBoard(FreeBoardDto dto) {
		int result = 0;
		String query="insert into bike_이소민_freeboard\r\n" + 
					 "(no, title, content, attach, reg_id, reg_date)\r\n" + 
					 "values\r\n" + 
					 "('"+dto.getNo()+"', '"+dto.getTitle()+"', '"+dto.getContent()+"', '"+dto.getAttach()+"', "
					 		+ "'"+dto.getReg_id()+"', to_date('"+dto.getReg_date()+"','yyyy-MM-dd hh24:mi:ss'))";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveFreeBoard() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//게시글 번호 생성
	public String getMaxNo() {
		String no = "";
		String query="select nvl(max(no), 'F000') as no from bike_이소민_freeboard";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				no = rs.getString("no");
				no = no.substring(1);
				int n = Integer.parseInt(no);
				n++;
				DecimalFormat df= new DecimalFormat("F000");
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
				 " from bike_이소민_freeboard f \r\n" + 
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
