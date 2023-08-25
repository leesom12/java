package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.SUb3Dto;
import dto.Sub1Dto;
import dto.Sub2Dto;
import dto.Sub5Dto;

public class VoteDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//등수
	public ArrayList<Sub5Dto> getRank(){
		ArrayList<Sub5Dto> arr = new ArrayList<Sub5Dto>();
		String query="select  tbl.m_no, tbl.m_name, tbl.v_count, to_char(round((tbl.v_count/total.total_count)*100,2),'99.99')||'%' percent from\r\n" + 
					"(select v.m_no,m.m_name, count(v.m_no) v_count \r\n" + 
					"from e_06_이소민_member m, e_06_이소민_vote v where m.m_no=v.m_no and v.v_confirm='Y' group by v.m_no, m.m_name) tbl,\r\n" + 
					"(select count(*) total_count from e_06_이소민_vote where v_confirm='Y' ) total\r\n" + 
					"order by tbl.v_count desc";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String m_no = rs.getNString("m_no");
				String m_name = rs.getNString("m_name");
				String v_count = rs.getNString("v_count");
				String percent = rs.getNString("percent");
				
				Sub5Dto dto = new Sub5Dto(m_no, m_name, v_count, percent);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getVoteConfirmList(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	
	//투표검수조회
	public ArrayList<SUb3Dto> getVoteConfirmList(){
		ArrayList<SUb3Dto> arr = new ArrayList<SUb3Dto>();
		String query="select v_name, to_char(to_date(decode(substr(v_jumin, 7, 1),'1','19','2','19','20')|| substr(v_jumin, 1, 6)),'yyyy\"년\"MM\"월\"dd\"일\"') v_birth, \r\n" + 
					 "extract(year from sysdate)-(decode(substr(v_jumin, 7, 1),'1','19','2','19','20')|| substr(v_jumin, 1, 2))||'세' v_age,\r\n" + 
					 "decode(substr(v_jumin, 7, 1),'1','남','2','여') v_gender, m_no,\r\n" + 
					 "to_char(v_time,'99,99') v_time, decode(v_confirm, 'Y','확인','미확인') v_confrim\r\n" + 
					 "from e_06_이소민_vote\r\n" + 
					 "where v_area='제1투표장'\r\n" + 
					 "order by v_confirm, v_time";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String v_name = rs.getNString("v_name");
				String v_birth = rs.getNString("v_birth");
				String v_age = rs.getNString("v_age");
				String v_gender = rs.getNString("v_gender");
				String m_no = rs.getNString("m_no");
				String v_time = rs.getNString("v_time");
				v_time = v_time.replaceAll(",", ":");
				String v_confirm = rs.getNString("v_confrim");
				
				SUb3Dto dto = new SUb3Dto(v_name, v_birth, v_age, v_gender, m_no, v_time, v_confirm);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getVoteConfirmList(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	
	
	//투표하기
	public int saveVote(Sub2Dto dto) {
		int result = 0;
		String query="insert into e_06_이소민_vote values ('"+dto.getV_jumin()+"','"+dto.getV_name()+"','"+dto.getM_no()+"',"
					+ "'"+dto.getV_time()+"','"+dto.getV_area()+"','"+dto.getV_confirm()+"')";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveVote() : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	//투표하기 - 후보번호 select box
	public ArrayList<Sub1Dto> getNumberList(){
		ArrayList<Sub1Dto> arr = new ArrayList<Sub1Dto>();
		String query="select m.m_no, m.m_name, p.p_name, decode(m.p_school ,'1','고졸','2','학사','3','석사','4','박사') p_school,\r\n" + 
					 "m.m_jumin, m.m_city, p.p_tel1, p.p_tel2, p.p_tel3\r\n" + 
					 "from e_06_이소민_member m, e_06_이소민_party p\r\n" + 
					 "where m.p_code = p.p_code\r\n"+
					 "order by m.m_no";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String m_no = rs.getNString("m_no");
				String m_name = rs.getNString("m_name");
				
				Sub1Dto dto = new Sub1Dto(m_no, m_name);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getNumberList(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//후보조회
	public ArrayList<Sub1Dto> getMemberList(){
		ArrayList<Sub1Dto> arr = new ArrayList<Sub1Dto>();
		String query="select m.m_no, m.m_name, p.p_name, decode(m.p_school ,'1','고졸','2','학사','3','석사','4','박사') p_school,\r\n" + 
					"substr(m.m_jumin, 1, 6)||'-'||substr(m.m_jumin, 7)m_jumin, m.m_city, p.p_tel1, p.p_tel2, p.p_tel3\r\n" + 
					"from e_06_이소민_member m, e_06_이소민_party p\r\n" + 
					"where m.p_code = p.p_code";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String m_no = rs.getNString("m_no");
				String m_name = rs.getNString("m_name");
				String p_name = rs.getNString("p_name");
				String p_school = rs.getNString("p_school");
				String m_jumin = rs.getNString("m_jumin");
				String m_city = rs.getNString("m_city");
				String p_tel1 = rs.getNString("p_tel1");
				String p_tel2 = rs.getNString("p_tel2");
				String p_tel3 = rs.getNString("p_tel3");
				String p_tel = p_tel1+"-"+p_tel2+"-"+p_tel3;
				
				Sub1Dto dto = new Sub1Dto(m_no, m_name, p_name, p_school, m_jumin, m_city, p_tel);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getMemberList(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
}
