package track;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//예약번호 중복검사
	public int resvnoCount(String resvno) {
		int count = 0;
		String query="select count(*) as count from exam_auto_contract\r\n" + 
					 "where resvno='"+resvno+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		}catch(Exception e) {
			System.out.println("resvnoCount: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}
	
	
	
	//근무일수집계
	public ArrayList<SUb3Dto> getWorkCount(){
		ArrayList<SUb3Dto> arr = new ArrayList<SUb3Dto>();
		String query="select c.empno, e.empname, decode(e.deptcode, '10','영업팀','20','총무팀','30','구매팀') deptcode,\r\n" + 
					 "count(c.empno) count\r\n" + 
					 "from exam_auto_contract c, exam_auto_emp e\r\n" + 
					 "where c.empno=e.empno \r\n" + 
					 "group by c.empno, e.empname, e.deptcode\r\n" + 
					 "order by c.empno";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String empno = rs.getNString("empno");
				String empname = rs.getNString("empname");
				String deptname = rs.getNString("deptcode");
				int count = rs.getInt("count");
				
				SUb3Dto dto = new SUb3Dto(empno, empname, deptname, count);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getContractList : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	
	
	//좌석예약조회
	public ArrayList<Sub2Dto> getContractList(String empno){
		ArrayList<Sub2Dto> arr = new ArrayList<Sub2Dto>();
		String query="select c.empno, e.empname, to_char(to_date(c.resvdate),'yyyy\"년\"MM\"월\"dd\"일\"') resvdate,\r\n" + 
					 "c.seatno, s.office, s.callno\r\n" + 
					 "from exam_auto_contract c, exam_auto_emp e, exam_auto_seat s\r\n" + 
					 "where c.empno=e.empno and s.seatno=c.seatno\r\n" + 
					 "and c.empno='"+empno+"'\r\n" + 
					 "order by c.resvdate desc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String empname = rs.getNString("empname");
				String resvdate = rs.getNString("resvdate");
				String seatno = rs.getNString("seatno");
				String office = rs.getNString("office");
				String callno = rs.getNString("callno");
				
				Sub2Dto dto = new Sub2Dto(empno, empname, resvdate, seatno, office, callno);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getContractList : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	
	//근무좌석 예약
	public int saveContract(Sub1Dto dto) {
		int result = 0;
		String query="insert into exam_auto_contract values ('"+dto.getResvno()+"','"+dto.getEmpno()+"','"+dto.getResvdate()+"','"+dto.getSeatno()+"')";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveContract : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	};
}
