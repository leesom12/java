package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.DeptDto;
import dto.ScoreListDto;
import dto.ScoreSaveDto;
import dto.StudentSaveDto;

public class ScoreDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//반별 통계
	public ArrayList<DeptDto> deptScoreList(){
		ArrayList<DeptDto> arr = new ArrayList<DeptDto>();
		String query="select b.syear, b.sclass, a.tname, sum(b.kor) sum_kor, sum(b.eng) sum_eng, sum(b.mat) sum_mat,\r\n" + 
					 "to_char(round(avg(b.kor),1),'99.9') ave_kor, to_char(round(avg(b.eng),1),'99.9') ave_eng, to_char(round(avg(b.mat),1),'99.9') ave_mat\r\n" + 
					 "from e_04_이소민_dept a,\r\n" + 
					 "e_04_이소민_score b\r\n" + 
					 "where b.syear=a.syear and b.sclass=a.sclass \r\n" + 
					 "group by b.syear, b.sclass, a.tname\r\n" + 
					 "order by syear,sclass";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String syear = rs.getNString("syear");
				String sclass = rs.getNString("sclass");
				String tname = rs.getNString("tname");
				int sum_kor = rs.getInt("sum_kor");
				int sum_eng = rs.getInt("sum_eng");
				int sum_mat = rs.getInt("sum_mat");
				String ave_kor = rs.getNString("ave_kor");
				String ave_eng = rs.getNString("ave_eng");
				String ave_mat = rs.getNString("ave_mat");
				
				DeptDto dto = new DeptDto(syear, sclass, tname, ave_kor, ave_eng, ave_mat, sum_kor, sum_eng, sum_mat);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("scoreList 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//학년별 조회
	public ScoreListDto year_scoreList() {
		ScoreListDto dto = null;
		String query="select syear, sum(kor) sum_kor, sum(eng) sum_eng, sum(mat) sum_mat,\r\n" + 
					 "to_char(round(avg(kor),1),'99.9') ave_kor, to_char(round(avg(eng),1),'99.9') ave_eng, to_char(round(avg(mat),1),'99.9') ave_mat\r\n" + 
					 "from e_04_이소민_score group by syear";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String syear = rs.getNString("syear");
				int sum_kor = rs.getInt("sum_kor");
				int sum_eng = rs.getInt("sum_eng");
				int sum_mat = rs.getInt("sum_mat");
				String ave_kor = rs.getNString("ave_kor");
				String ave_eng = rs.getNString("ave_eng");
				String ave_mat = rs.getNString("ave_mat");
				
				dto = new ScoreListDto(syear, ave_kor, ave_eng, ave_mat, sum_kor, sum_eng, sum_mat);
			}
		}catch(Exception e) {
			System.out.println("year_scoreList 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	//학생성적조회
	public ArrayList<ScoreListDto> scoreList(){
		ArrayList<ScoreListDto> arr = new ArrayList<ScoreListDto>();
		String query="select b.syear, b.sclass, b.sno, a.sname, decode(a.gender, 'M','남','여') gender,\r\n" + 
					 "b.kor, b.eng, b.mat, (kor+eng+mat) sum, to_char((round((kor+eng+mat)/3,1)),'99.9') ave\r\n" + 
					 "from e_04_이소민_student a,\r\n" + 
					 "e_04_이소민_score b\r\n" + 
					 "where a.sclass=b.sclass and a.syear=b.syear and a.sno=b.sno\r\n" + 
					 "order by syear, sclass, sno";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String syear = rs.getNString("syear");
				String sclass = rs.getNString("sclass");
				String sno = rs.getNString("sno");
				String sname = rs.getNString("sname");
				String gender = rs.getNString("gender");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int total = rs.getInt("sum");
				String ave = rs.getNString("ave");
				
				ScoreListDto dto = new ScoreListDto(syear, sclass, sno, sname, gender, ave, kor, eng, mat, total);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("scoreList 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//성적입력
	public int scoreSave(ScoreSaveDto dto) {
		int result = 0;
		String query="insert into e_04_이소민_score values('"+dto.getSyear()+"','"+dto.getSclass()+"','"+dto.getSno()+"',"
					 + "'"+dto.getKor()+"','"+dto.getEng()+"','"+dto.getMat()+"')";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("scoreSave 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//학생등록
	public int studentSave(StudentSaveDto dto) {
		int result = 0;
		String query="insert into e_04_이소민_student values"
					+ "('"+dto.getSyear()+"','"+dto.getSclass()+"','"+dto.getSno()+"','"+dto.getSname()+"','"+dto.getBirth()+"',"
					+ "'"+dto.getGender()+"','"+dto.getTel1()+"','"+dto.getTel2()+"','"+dto.getTel3()+"')";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("studentSave 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
}
