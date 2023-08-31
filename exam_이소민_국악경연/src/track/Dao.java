package track;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Dao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//최종등수조회
	public ArrayList<Sub3Dto> getRank() {
		ArrayList<Sub3Dto> arr = new ArrayList<Sub3Dto>();
		String query="select e.entry_no, e.entry_name, decode(substr(e.entry_jumin,7,1),'1','남','2','여') entry_gender,\r\n" + 
				"to_char(to_date(substr(e.entry_jumin,1,6)),'yy\"년\"MM\"월\"dd\"일\"') entry_birth,\r\n" + 
				"decode(e.entry_type,'1','기악','2','민요','3','무용','4','판소리') entry_type, \r\n" + 
				"e.entry_area,to_char(r.s_tot)s_tot, r.s_ave,\r\n" + 
				"rank() over (order by s_tot desc, e.entry_no) rank\r\n" + 
				"from tbl_entry_202106 e, tbl_record_202106 r\r\n" + 
				"where e.entry_no = r.entry_no";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String entry_no = rs.getNString("entry_no");
				String entry_name = rs.getNString("entry_name");
				String entry_gender = rs.getNString("entry_gender");
				String entry_birth = rs.getNString("entry_birth");
				String entry_type = rs.getNString("entry_type");
				String entry_area = rs.getNString("entry_area");
				String s_tot = rs.getNString("s_tot");
				String s_ave = rs.getNString("s_ave");
				double ave = Double.parseDouble(s_ave);
				DecimalFormat df = new DecimalFormat("##.0#");
				s_ave = df.format(ave);
				int rank = rs.getInt("rank");
				
				Sub3Dto dto = new Sub3Dto(entry_no, entry_name, entry_gender, entry_birth, entry_type, entry_area, s_tot, s_ave, rank);
				arr.add(dto);
				
			}
		}catch(Exception e) {
			System.out.println("getRank: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	
	
	//경연결과조회
	public Sub2Dto getResult(String entry_no) {
		Sub2Dto dto = null;
		String query="select e.entry_no, e.entry_name, decode(substr(e.entry_jumin,7,1),'1','남','2','여') entry_gender,\r\n" + 
				"to_char(to_date(substr(e.entry_jumin,1,6)),'yy\"년\"MM\"월\"dd\"일\"') entry_birth,\r\n" + 
				"decode(e.entry_type,'1','기악','2','민요','3','무용','4','판소리') entry_type, e.entry_area,\r\n" + 
				"r.score1, r.score2, r.score3, r.score4, r.score5, r.s_tot, to_char(r.s_ave,'99.99') s_ave\r\n" + 
				"from tbl_entry_202106 e, tbl_record_202106 r\r\n" + 
				"where e.entry_no = r.entry_no\r\n" + 
				"and e.entry_no='"+entry_no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String entry_name = rs.getNString("entry_name");
				String entry_gender = rs.getNString("entry_gender");
				String entry_birth = rs.getNString("entry_birth");
				String entry_type = rs.getNString("entry_type");
				String entry_area = rs.getNString("entry_area");
				String s_ave = rs.getNString("s_ave");
				int score1 = rs.getInt("score1");
				int score2 = rs.getInt("score2");
				int score3 = rs.getInt("score3");
				int score4 = rs.getInt("score4");
				int score5 = rs.getInt("score5");
				int s_tot = rs.getInt("s_tot");
				
				dto = new Sub2Dto(entry_no, entry_name, entry_gender, entry_birth, entry_type, entry_area, 
						s_ave, score1, score2, score3, score4, score5, s_tot);
			}
		}catch(Exception e) {
			System.out.println("getResult: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	
	//경연점수등록
	public int saveRecord(Sub1Dto dto) {
		int result = 0;
		String query="insert into tbl_record_202106 values ('"+dto.getEntry_no()+"','"+dto.getScore1()+"','"+dto.getScore2()+"',"
						+ "'"+dto.getScore3()+"','"+dto.getScore4()+"','"+dto.getScore5()+"','"+dto.getS_max()+"','"+dto.getS_min()+"',"
						+ "'"+dto.getS_tot()+"','"+dto.getS_ave()+"')";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveRecord: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
}
