package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.EtcDto;

public class EtcDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	
	//이전글
	public EtcDto preNo(String no) {
		EtcDto dto = null;
		String query=" select a.no, b.title \r\n" + 
					 " from (select max(no) as no from bike_이소민_etc\r\n" + 
					 " where no < '"+no+"' and depth=0) a,\r\n" + 
					 " bike_이소민_etc b \r\n" + 
					 " where a.no=b.no";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String preNo= rs.getString("no");
				String preTitle= rs.getString("title");
				dto= new EtcDto(preNo, preTitle);
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
	public EtcDto nextNo(String no) {
		EtcDto dto = null;
		String query=" select a.no, b.title \r\n" + 
					 " from (select min(no) as no from bike_이소민_etc\r\n" + 
					 " where no > '"+no+"' and depth=0) a,\r\n" + 
					 " bike_이소민_etc b \r\n" + 
					 " where a.no=b.no";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String nextNo= rs.getString("no");
				String nextTitle= rs.getString("title");
				dto= new EtcDto(nextNo, nextTitle);
			}
		}catch(Exception e) {
			System.out.println("nextNo() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	
	//뷰
	public EtcDto viewEtc(String no) {
		EtcDto dto = null;
		String query="select e.no, e.group_no, e.reg_id, m.name as reg_name, to_char(e.reg_date, 'yyyy-MM-dd hh24:mi:ss') as reg_date,\r\n" + 
					 "e.depth, e.title, e.content\r\n" + 
					 "from bike_이소민_etc e,\r\n" + 
					 "bike_이소민_member m\r\n" + 
					 "where e.reg_id = m.id\r\n" + 
					 "and e.no = '"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				String group_no = rs.getNString("group_no");
				String reg_id = rs.getNString("reg_id");
				String reg_name = rs.getNString("reg_name");
				String reg_date = rs.getNString("reg_date");
				int depth = rs.getInt("depth");
				String title= rs.getNString("title");
				String content = rs.getNString("content");
				
				dto = new EtcDto(no, group_no, title, content, reg_id, reg_name, reg_date, depth);
			}
		}catch(Exception e) {
			System.out.println("viewEtc() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	//댓글 뷰
	public ArrayList<EtcDto> viewEtcComments(String no){
		ArrayList<EtcDto> arr= new ArrayList<EtcDto>();
		String query="select e.no, e.group_no, e.reg_id, m.name as reg_name, to_char(e.reg_date, 'yyyy-MM-dd hh24:mi:ss') as reg_date,\r\n" + 
					 "e.depth, lpad(' ', 4*(e.depth)) || e.title as title, e.content\r\n" + 
					 "from bike_이소민_etc e,\r\n" + 
					 "bike_이소민_member m\r\n" + 
					 "where e.reg_id = m.id\r\n" + 
					 "and level > 1\r\n" + 
					 "start with e.no = '"+no+"'\r\n" + 
					 "connect by nocycle prior no = group_no\r\n" + 
					 "order siblings by e.reg_date desc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String group_no = rs.getNString("group_no");
				String reg_id = rs.getNString("reg_id");
				String reg_name = rs.getNString("reg_name");
				String reg_date = rs.getNString("reg_date");
				int depth = rs.getInt("depth");
				String title= rs.getNString("title");
				String content = rs.getNString("content");
				
				EtcDto dto = new EtcDto(no, group_no, title, content, reg_id, reg_name, reg_date, depth);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("viewEtcComments() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//원글 작성
	public int saveEtc(EtcDto dto) {
		int result = 0;
		String query="insert into bike_이소민_etc\r\n" + 
					 "(no, group_no, depth, title, content, reg_id, reg_date)\r\n" + 
					 "values\r\n" + 
					 "('"+dto.getNo()+"', '"+dto.getGroup_no()+"', "+dto.getDepth()+", '"+dto.getTitle()+"', "
					 		+ "'"+dto.getContent()+"', '"+dto.getReg_id()+"', to_date('"+dto.getReg_date()+"', 'yyyy-MM-dd hh24:mi:ss'))";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveEtc() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	//리스트 조회
	public ArrayList<EtcDto> getEtcList(String select, String search, int start, int end){
		ArrayList<EtcDto> arr = new ArrayList<EtcDto>();
		String query= "select * from\r\n" + 
					  "(select rownum as rnum, tbl.* from\r\n" + 
					  "(select e.no, e.title, e.reg_id, m.name as reg_name, to_char(e.reg_date, 'yyyy-MM-dd') as reg_date\r\n" + 
					  "from bike_이소민_etc e,\r\n" + 
					  "bike_이소민_member m\r\n" + 
					  "where e.reg_id = m.id\r\n" + 
					  "and e.depth = 0\r\n" + 
					  "and "+select+" like '%"+search+"%')tbl) where rnum >="+start+" and rnum <= "+end+"";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getNString("no");
				String title = rs.getNString("title");
				String reg_id = rs.getNString("reg_id");
				String reg_name = rs.getNString("reg_name");
				String reg_date = rs.getNString("reg_date");
				
				EtcDto dto = new EtcDto(no, title, reg_id, reg_name, reg_date);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getEtcList");
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//게시글 번호 생성
	public String getMaxNo() {
		String no = "";
		String query="select nvl(max(no), '0000') as no from bike_이소민_etc";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				no = rs.getString("no");
				int n = Integer.parseInt(no);
				n++;
				DecimalFormat df= new DecimalFormat("0000");
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
				 " from bike_이소민_etc e \r\n" + 
				 " where "+select+" like '%"+search+"%' \r\n"+
				 " and depth = 0";
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
