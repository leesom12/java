package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.Sub1Dto;
import dto.Sub2Dto;
import dto.Sub3Dto;
import dto.Sub4Dto;

public class OlympicDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//참가자 등수 조회
	public ArrayList<Sub4Dto> getRank(){
		ArrayList<Sub4Dto> arr = new ArrayList<Sub4Dto>();
		String query="select decode(to_char(rownum),'1','금','2','은','3','동', rownum) rnum, tbl.* from\r\n" + 
					 "(select p.player_no, p.name, n.nation_name, s.skill_name,\r\n" + 
					 "to_char(o.total) total, o.ave||'점' ave\r\n" + 
					 "from e_08_이소민_olympic_player p, e_08_이소민_olympic_point o, e_08_이소민_olympic_nation n, e_08_이소민_olympic_skill s\r\n" + 
					 "where p.player_no = o.player_no and p.nation_code = n.nation_code and p.skill_level = s.skill_level\r\n" + 
					 "order by o.ave desc)tbl";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String rnum = rs.getNString("rnum");
				String player_no = rs.getNString("player_no");
				String name = rs.getNString("name");
				String nation_name = rs.getNString("nation_name");
				String skill_name = rs.getNString("skill_name");
				String total = rs.getNString("total");
				String ave = rs.getNString("ave");
				
				Sub4Dto dto = new Sub4Dto(rnum, player_no, name, nation_name, skill_name, total, ave);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getPointList(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//심사 점수 조회
	public ArrayList<Sub3Dto> getPointList(){
		ArrayList<Sub3Dto> arr = new ArrayList<Sub3Dto>();
		String query="select p.player_no, p.name, o.point_1||'점' point_1, o.point_2||'점' point_2, o.point_3||'점' point_3, \r\n" + 
					 "o.point_4||'점' point_4, to_char(o.total) total, o.ave||'점' ave\r\n" + 
					 "from e_08_이소민_olympic_player p, e_08_이소민_olympic_point o\r\n" + 
					 "where p.player_no = o.player_no\r\n"+
					 "order by substr(p.player_no, 4,1)";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String player_no = rs.getNString("player_no");
				String name = rs.getNString("name");
				String point_1 = rs.getNString("point_1");
				String point_2 = rs.getNString("point_2");
				String point_3 = rs.getNString("point_3");
				String point_4 = rs.getNString("point_4");
				String total = rs.getNString("total");
				String ave = rs.getNString("ave");
				
				Sub3Dto dto = new Sub3Dto(player_no, name, point_1, point_2, point_3, point_4, total, ave);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getPointList(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	
	//심사점수 수정
	public int updatePoint(Sub2Dto dto) {
		int result = 0;
		String query="update e_08_이소민_olympic_point\r\n" + 
					 "set point_1="+dto.getPoint_1()+", point_2="+dto.getPoint_2()+", point_3="+dto.getPoint_3()+", point_4="+dto.getPoint_4()+", "
					 		+ "total="+dto.getTotal()+", ave="+dto.getAve()+"\r\n" + 
					 "where player_no='"+dto.getPlayer_no()+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("updatePoint(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	//심사점수 등록
	public int savePoint(Sub2Dto dto) {
		int result = 0;
		String query="insert into e_08_이소민_olympic_point values ('"+dto.getPlayer_no()+"','"+dto.getPoint_1()+"','"+dto.getPoint_2()+"',"
					+ "'"+dto.getPoint_3()+"','"+dto.getPoint_4()+"','"+dto.getTotal()+"','"+dto.getAve()+"')";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("savePoint(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//가산점 조회
	public int getSkillPoint(String player_no) {
		int point=0;
		String query="select skill_level from e_08_이소민_olympic_player\r\n" + 
					 "where player_no ='"+player_no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				String skill_level = rs.getNString("skill_level");
				point = Integer.parseInt(skill_level);
			}
		}catch(Exception e) {
			System.out.println("getSkillPoint(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return point;
	}
	
	
	//참가자 목록 조회
	public ArrayList<Sub1Dto> getPlayerList(){
		ArrayList<Sub1Dto> arr = new ArrayList<Sub1Dto>();
		String query="select p.player_no, p.name, n.nation_name,\r\n" + 
					 "to_char(to_date(p.birth),'yyyy\"년\"MM\"월\"dd\"일\"') birth,\r\n" + 
					 "decode(substr(p.player_no, 1,1),'1','남자','여자') gender,\r\n" + 
					 "s.skill_name\r\n" + 
					 "from e_08_이소민_olympic_player p, e_08_이소민_olympic_skill s, e_08_이소민_olympic_nation n\r\n" + 
					 "where p.skill_level = s.skill_level and p.nation_code = n.nation_code\r\n" + 
					 "order by substr(p.player_no, 4,1)";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String player_no = rs.getNString("player_no");
				String name = rs.getNString("name");
				String nation_name = rs.getNString("nation_name");
				String birth = rs.getNString("birth");
				String gender = rs.getNString("gender");
				String skill_name = rs.getNString("skill_name");
				
				Sub1Dto dto = new Sub1Dto(player_no, name, gender, birth, skill_name, nation_name);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getPlayerList(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
}
