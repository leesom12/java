package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

public class Consulting_이소민_dao {
	Connection con= null;
	PreparedStatement ps= null;
	ResultSet rs= null;
	Date date=null;

	//상담내역 조회
	public ArrayList<Consulting_이소민_dto> getConsultingList(String gubun, String c) {
		ArrayList<Consulting_이소민_dto> dtos= new ArrayList<Consulting_이소민_dto>();
		String query="select c.no, c.sid, e.name as ename, c.mid, m.name as mname,\r\n" + 
					 "to_char(cdate, 'yy/mm/dd') as cdate, c.content\r\n" + 
					 "from e_이소민_consulting c, e_이소민_educatee e, e_이소민_mentor m\r\n" + 
					 "where c.sid= e.id and c.mid=m.id\r\n" + 
					 "and "+gubun+" like '%"+c+"%'\r\n" + 
					 "order by no asc";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String no=rs.getString("no");
				String sid= rs.getString("sid");
				String sname= rs.getString("ename");
				String mid= rs.getString("mid");
				String mname= rs.getString("mname");
				String date= rs.getString("cdate");
				String content= rs.getString("content");
				if(content == null) content="";
				
				Consulting_이소민_dto dto= new Consulting_이소민_dto(no, sid, sname, mid, mname, date, content);
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getConsultingList(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}

	//프린트
	public void getConsultPrint(ArrayList<Consulting_이소민_dto> dtos) {
		System.out.println("================================================================");
		System.out.println("번호\t학생\t\t멘토\t\t일시\t\t내용");
		System.out.println("----------------------------------------------------------------");
		if(dtos.size() == 0) {
			System.out.println("정보없음");
		}else {
			for(int k=0; k<dtos.size(); k++) {
				System.out.print(dtos.get(k).getCid()+"\t");
				System.out.print(dtos.get(k).getSid());
				System.out.print("("+dtos.get(k).getSname()+")"+"\t");
				System.out.print(dtos.get(k).getMid());
				System.out.print("("+dtos.get(k).getMname()+")"+"\t");
				System.out.print(dtos.get(k).getDate()+"\t");
				System.out.print(dtos.get(k).getContent()+"\n");
			}
			System.out.println("----------------------------------------------------------------");
			System.out.println("총 "+ dtos.size()+"건");
		}
		System.out.println("----------------------------------------------------------------");
		
	}

	//상담번호 중복 체크
	public int checkNo(String gubun, String c) {
		int count =0;
		String query="select count(*) as count\r\n" + 
					 "from e_이소민_consulting\r\n" + 
					 "where "+gubun+"='"+c+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()) count= rs.getInt("count");
		}catch(Exception e) {
			System.out.println("checkNo(): "+query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}

	//상담 등록
	public int saveConsult(Consulting_이소민_dto dto) {
		int result= 0;
		String query="insert into \"E_이소민_CONSULTING\"\r\n" + 
					 "(no, sid, mid, cdate, content)\r\n" + 
					 "values('"+dto.getCid()+"','"+dto.getSid()+"','"+dto.getMid()+"','"+dto.getDate()+"','"+dto.getContent()+"')";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveConsult(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

	//상담 수정
	public int updateConsult(Consulting_이소민_dto dto) {
		int result = 0;
		String query="update e_이소민_consulting\r\n" + 
					 "set sid='"+dto.getSid()+"', mid='"+dto.getMid()+"', cdate='"+dto.getDate()+"', content='"+dto.getContent()+"'\r\n" + 
					 "where no='"+dto.getCid()+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("updateConsult(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

	//상담 삭제
	public int deleteConsult(String no) {
		int result=0;
		String query="delete from e_이소민_consulting\r\n" + 
					 "where no ='"+no+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("deleteConsult(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	

}
