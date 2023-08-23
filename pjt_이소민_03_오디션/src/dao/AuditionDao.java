package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.AuditionDto;
import dto.MetoDto;
import dto.Sub4;

public class AuditionDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//점수 등록
	public int saveMentoPoint(MetoDto dto) {
		int result =0;
		String query="insert into e_03_이소민_point values ('"+dto.getSerial_no()+"','"+dto.getArtist_id()+"', '"+dto.getMento_id()+"', '"+dto.getPoint()+"')";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveMentoPoint 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//점수등록 씨리얼넘버 자동생성
	public int getMaxNo() {
		int serial_no =0;
		String query="select nvl(max(serial_no),'2019000') serial_no from e_03_이소민_point";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				serial_no = rs.getInt("serial_no");
				serial_no= serial_no+1;
			}
		}catch(Exception e) {
			System.out.println("getMaxNo 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return serial_no;
	}
	
	//멘토점수조회
	public ArrayList<Sub4> getGradeList(){
		ArrayList<Sub4> arr = new ArrayList<Sub4>();
		String query="select tbl.*, rownum as rnum from\r\n" + 
				"(select  p.artist_id, a.artist_name, decode(a.artist_gender, 'M','남성','여성') artist_gender, \r\n" + 
				"sum(p.point) as total_point, to_char(round(avg(p.point),2),'99.99') ave_point\r\n" + 
				"from e_03_이소민_artist a,\r\n" + 
				"e_03_이소민_point p\r\n" + 
				"where a.artist_id = p.artist_id\r\n" + 
				"group by p.artist_id, a.artist_name, a.artist_birth, a.artist_gender\r\n" + 
				"order by total_point desc)tbl";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String artist_id = rs.getNString("artist_id");
				String artist_name = rs.getNString("artist_name");
				String artist_gender = rs.getNString("artist_gender");
				String total= rs.getNString("total_point");
				String ave= rs.getNString("ave_point");
				String rank = rs.getNString("rnum");
				
				Sub4 dto = new Sub4(artist_id, artist_name, artist_gender, total, ave, rank);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getGradeList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//멘토점수조회
	public ArrayList<AuditionDto> getMentoPoniList(){
		ArrayList<AuditionDto> arr = new ArrayList<AuditionDto>();
		String query="select p.serial_no, p.artist_id, a.artist_name, to_char(to_date(a.artist_birth),'yyyy\"년\"MM\"월\"dd\"일\"') artist_birth,\r\n" + 
					 "p.point, m.mento_id, m.mento_name\r\n" + 
					 "from e_03_이소민_artist a,\r\n" + 
					 "e_03_이소민_point p,\r\n" + 
					 "e_03_이소민_mento m\r\n" + 
					 "where a.artist_id = p.artist_id and p.mento_id = m.mento_id\r\n"+
					 "order by p.serial_no";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				int serial_no = rs.getInt("serial_no");
				String artist_id = rs.getNString("artist_id");
				String artist_name = rs.getNString("artist_name");
				String artist_birth = rs.getNString("artist_birth");
				int mento_point = rs.getInt("point");
				String mento_id = rs.getNString("mento_id");
				String mento_name = rs.getNString("mento_name");
				String grade = "";
				if(mento_point >= 90) grade="A";
				else if(mento_point >= 80) grade="B";
				else if(mento_point >= 70) grade="C";
				else if(mento_point >= 60) grade="D";
				else grade="F";
				
				AuditionDto dto = new AuditionDto(artist_id, artist_name, artist_birth, mento_id, mento_name, grade, serial_no, mento_point);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getMentoPoniList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//멘토점수등록-참가자선택
	public ArrayList<AuditionDto> getMemberCheck(){
		ArrayList<AuditionDto> arr = new ArrayList<AuditionDto>();
		String query="select artist_id from e_03_이소민_artist\r\n" + 
				 	 "where artist_id not in(select artist_id from e_03_이소민_point)";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String artist_id = rs.getNString("artist_id");
				AuditionDto dto = new AuditionDto(artist_id);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getMemberCheck() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//참가자 목록 조회
	public ArrayList<AuditionDto> getArtistList(){
		ArrayList<AuditionDto> arr = new ArrayList<AuditionDto>();
		String query="select artist_id, artist_name, \r\n" + 
					 "decode(artist_gender, 'M','남성','F','여성') artist_gender, \r\n" + 
					 "to_char(to_date(artist_birth),'yyyy\"년\"MM\"월\"dd\"일\"') artist_birth, \r\n" + 
					 "decode(talent, '1','댄스','2','랩','3','노래') talent, agency\r\n" + 
					 "from e_03_이소민_artist\r\n" + 
					 "order by artist_id";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String artist_id = rs.getNString("artist_id");
				String artist_name = rs.getNString("artist_name");
				String artist_gender = rs.getNString("artist_gender");
				String artist_birth = rs.getNString("artist_birth");
				String talent = rs.getNString("talent");
				String agency= rs.getNString("agency");
				
				AuditionDto dto = new AuditionDto(artist_id, artist_name, artist_gender, artist_birth, talent, agency);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getArtistList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//오디션 등록
	public int auditionSave(AuditionDto dto) {
		int result =0;
		String query="insert into e_03_이소민_artist values ('"+dto.getArtist_id()+"', '"+dto.getArtist_name()+"', '"+dto.getArtist_gender()+"', "
				+ "'"+dto.getArtist_birth()+"', '"+dto.getTalent()+"', '"+dto.getAgency()+"')";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("auditionSave() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
}
