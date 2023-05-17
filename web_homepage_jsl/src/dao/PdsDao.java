package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.NewsDto;
import dto.PdsDto;

public class PdsDao {

	Connection con= null;
	PreparedStatement ps= null;
	ResultSet rs= null;
	
	//게시글 번호 생성
	public String getMaxNo() {
		String no="";
		String query="select nvl(max(no),'P000') as no from home_이소민_pds";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				no= rs.getString("no");
				no= no.substring(1);
				int n= Integer.parseInt(no);
				n++;
				DecimalFormat df= new DecimalFormat("P000");
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
	
	//등록
	public int savePds(PdsDto dto) {
		int result=0;
		String query="insert into home_이소민_pds\r\n" + 
					 "(no, title, content, attach, reg_id, reg_date)\r\n" + 
					 "values\r\n" + 
					 "('"+dto.getNo()+"', '"+dto.getTitle()+"', '"+dto.getContent()+"', '"+dto.getAttach()+"', '"+dto.getReg_id()+"', \r\n" + 
					 "to_date('"+dto.getReg_date()+"', 'yyyy-MM-dd hh24:mi:ss'))";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("savePds() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//조회
	public ArrayList<PdsDto> pdsList(String select, String search, int start, int end){
		ArrayList<PdsDto> arr= new ArrayList<PdsDto>();
		String query="select * from\r\n" + 
					 "    (select rownum as rnum, tbl.* from\r\n" + 
					 "        (select p.no, p.title, p.content, p.attach, m.name as reg_name, \r\n" + 
					 "        to_char(p.reg_date, 'yyyy-MM-dd') as reg_date, \r\n" + 
					 "        to_char(p.update_date, 'yyyy-MM-dd hh24:mi:ss') as update_date, \r\n" + 
					 "        p.hit\r\n" + 
					 "        from home_이소민_pds p, home_이소민_member m\r\n" + 
					 "        where p.reg_id=m.id\r\n" + 
					 "        and "+select+" like '%"+search+"%' \r\n"
					 		+ "order by p.no desc) \r\n" + 
					 "    tbl)\r\n" + 
					 "where rnum >="+start+" and rnum<="+end+""; 
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String no= rs.getString("no");
				String title= rs.getString("title");
				String content= rs.getString("content");
				String attach= rs.getString("attach");
				String name= rs.getString("reg_name");
				String reg_date= rs.getString("reg_date");
				String update_date= rs.getString("update_date");
				int hit= rs.getInt("hit");

				PdsDto dto = new PdsDto(no, title, content, attach, name, reg_date, update_date, hit);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("pdsList() 오류: "+query);
			e.printStackTrace();			
		}finally {
			DBConnection.closeDB(con, ps, rs);
			
		}
		return arr;
	}
	
	//상세조회
	public PdsDto viewPds(String no) {
		PdsDto dto = null;
		String query="select p.no, p.title, p.content, p.attach, m.name as reg_name, \r\n" + 
					 "to_char(p.reg_date, 'yyyy-MM-dd hh24:mi:ss') as reg_date, \r\n" + 
					 "to_char(p.update_date, 'yyyy-MM-dd hh24:mi:ss') as update_date, \r\n" + 
					 "p.hit\r\n" + 
					 "from home_이소민_pds p, home_이소민_member m\r\n" + 
					 "where p.reg_id=m.id\r\n" + 
					 "and no='"+no+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String title= rs.getString("title");
				String content= rs.getString("content");
				String attach= rs.getString("attach");
				String name= rs.getString("reg_name");
				String reg_date= rs.getString("reg_date");
				//reg_date= reg_date.substring(0, 19);
				String update_date= rs.getString("update_date");
				//update_date= update_date.substring(0, 19);
				int hit= rs.getInt("hit");

				dto = new PdsDto(no, title, content, attach, name, reg_date, update_date, hit);
			}
		}catch(Exception e) {
			System.out.println("pdsList() 오류: "+query);
			e.printStackTrace();			
		}finally {
			DBConnection.closeDB(con, ps, rs);
			
		}
		return dto;
	}
	
	//조회수
	public void hitUpdate(String no) {
		String query=" update home_이소민_pds\r\n" + 
					 " set hit= hit+1\r\n" + 
					 " where no='"+no+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			int result= ps.executeUpdate();
			if(result == 0) System.out.println("자료실 조회수 hitUpdate() 오류:"+query);
		}catch(Exception e) {
			System.out.println("hitUpdate() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
	}	

	//이전글
	public PdsDto preNo(String no) {
		PdsDto dto = null;
		String query=" select a.no, b.title \r\n" + 
					 " from (select max(no) as no from home_이소민_pds\r\n" + 
					 " where no < '"+no+"') a,\r\n" + 
					 " home_이소민_pds b \r\n" + 
					 " where a.no=b.no";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String preNo= rs.getString("no");
				String preTitle= rs.getString("title");
				dto= new PdsDto(preNo, preTitle);
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
	public PdsDto nextNo(String no) {
		PdsDto dto = null;
		String query=" select a.no, b.title \r\n" + 
					 " from (select min(no) as no from home_이소민_pds\r\n" + 
					 " where no > '"+no+"') a,\r\n" + 
					 " home_이소민_pds b \r\n" + 
					 " where a.no=b.no";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String nextNo= rs.getString("no");
				String nextTitle= rs.getString("title");
				dto= new PdsDto(nextNo, nextTitle);
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
	public int updatePds(PdsDto dto) {
		int result=0;
		String query="update home_이소민_pds\r\n" + 
					 "set title='"+dto.getTitle()+"', content='"+dto.getContent()+"', attach='"+dto.getAttach()+"',\r\n" + 
					 "update_date= to_date('"+dto.getUpdate_date()+"','yyyy-MM-dd hh24:mi:ss')\r\n" + 
					 "where no='"+dto.getNo()+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("updatePds() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//삭제
	public int deletePds(String no) {
		int result=0;
		String query=" delete from home_이소민_pds\r\n" + 
					 " where no='"+no+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("deletePds() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	//글 개수 불러오기
	public int getTotalCount(String select, String search) {
		int count=0;
		String query=" select count(*) as count \r\n" + 
					 " from home_이소민_pds p \r\n" + 
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
