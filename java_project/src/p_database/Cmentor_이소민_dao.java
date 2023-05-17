package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Cmentor_이소민_dao {
	Connection con= null;
	PreparedStatement ps= null;
	ResultSet rs= null;
	
	//멘토 조회
	public ArrayList<Cmentor_이소민_dto> getMentorList(String gubun ,String m) {
		ArrayList<Cmentor_이소민_dto> dtos= new ArrayList<Cmentor_이소민_dto>();
		String query="select id, name\r\n" + 
					 "from e_이소민_mentor\r\n" + 
					 "where "+gubun+" like '%"+m+"%'\r\n"+
					 "order by id asc";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String m_id= rs.getString("id");
				String m_name= rs.getString("name");
				Cmentor_이소민_dto dto= new Cmentor_이소민_dto(m_id, m_name);
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getMentorList(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}

	//프린트
	public void mentorPrint(ArrayList<Cmentor_이소민_dto> dtos) {
		System.out.println("===============");
		System.out.println("번호\t성명");
		System.out.println("---------------");
		if(dtos.size() == 0) {
			System.out.println("정보없음");
		}else {
			for(int k=0; k<dtos.size(); k++) {
				System.out.print(dtos.get(k).getMid()+"\t");
				System.out.print(dtos.get(k).getMname()+"\n");
			}
			System.out.println("---------------");
			System.out.println("총 "+dtos.size()+"명");
		}
		System.out.println("---------------");
	}

	//아이디 중복 검사
	public int checkMentorId(String id) {
		int count=0;
		String query="select count(*) as count\r\n" + 
					 "from e_이소민_mentor\r\n" + 
					 "where id='"+id+"'";
		try{
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()) count= rs.getInt("count");
		}catch(Exception e) {
			System.out.println("checkMentorId(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}

	//등록
	public int saveMentor(Cmentor_이소민_dto dto) {
		int result=0;
		String query="insert into e_이소민_mentor\r\n" + 
					 "(id, name)\r\n" + 
					 "values('"+dto.getMid()+"','"+dto.getMname()+"')";
		try {
			con= DBConnection.getConnection();
			ps=con.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveMentor(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

	//수정
	public int updateMentor(Cmentor_이소민_dto dto) {
		int result=0;
		String query="update e_이소민_mentor\r\n" + 
					 "set name='"+dto.getMname()+"'\r\n" + 
					 "where id='"+dto.getMid()+"'";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("updateMentor(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

	//삭제
	public int deleteMentor(String id) {
		int result=0;
		String query="delete from e_이소민_mentor\r\n" + 
					 "where id='"+id+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("deleteMentor(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	

}
