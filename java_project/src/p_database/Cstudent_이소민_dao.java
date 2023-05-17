package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Cstudent_이소민_dao {
	Connection con =null;
	PreparedStatement ps= null;
	ResultSet rs= null;
	
	//학생조회
	public ArrayList<Cstudent_이소민_dto> getStudentList(String gubun, String i) {
		ArrayList<Cstudent_이소민_dto> dtos= new ArrayList<>();
		String query="select id, age, name\r\n" + 
					 "from e_이소민_educatee\r\n" + 
					 "where "+gubun+" like '%"+i+"%'\r\n"+
					 "order by id asc";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				String sid= rs.getString("id");
				String sname= rs.getString("name");
				int age= rs.getInt("age");
				
				Cstudent_이소민_dto dto= new Cstudent_이소민_dto(sid, sname, age);
				dtos.add(dto);
			}
			
		}catch(Exception e) {
			System.out.println("getStudentList(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dtos;
	}
	
	//프린트
	public void getStudentPrint(ArrayList<Cstudent_이소민_dto> dtos) {
		System.out.println("========================");
		System.out.println("번호\t성명\t나이");
		System.out.println("------------------------");
		if(dtos.size() == 0) {
			System.out.println("\t\t정보없음");
		}else {
			for(int k=0; k<dtos.size(); k++) {
				System.out.print(dtos.get(k).getSid()+"\t");
				System.out.print(dtos.get(k).getSname()+"\t");
				System.out.print(dtos.get(k).getAge()+"\n");
			}
		}
		System.out.println("------------------------");
		if(dtos.size() != 0) {
			System.out.println("총 "+dtos.size()+"명");
			System.out.println("------------------------");
		}
	}

	//ID 중복체크
	public int checkStudentId(String id) {
		int count =0;
		String query="select count(*) as count\r\n" + 
					 "from e_이소민_educatee\r\n" + 
					 "where id='"+id+"'";
		
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) count= rs.getInt("count");
		}catch(Exception e) {
			System.out.println("checkStudentId(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return count;
	}

	
	//학생등록
	public int saveStudent(Cstudent_이소민_dto dto) {
		int result=0;
		String query="insert into e_이소민_educatee\r\n" + 
					 "(id, name, age)\r\n" + 
					 "values('"+dto.getSid()+"', '"+dto.getSname()+"', "+dto.getAge()+")";
		
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveStudent(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}

	//학생 수정
	public int updateStudent(Cstudent_이소민_dto dto) {
		int result= 0;
		String query="update e_이소민_educatee\r\n" + 
					 "set name='"+dto.getSname()+"', age="+dto.getAge()+"\r\n" + 
					 "where id='"+dto.getSid()+"'";
		try {
			con= DBConnection.getConnection();
			ps=con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("updateStudent(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

	// 학생 삭제
	public int deleteStudent(String id) {
		int result=0;
		String query="delete from e_이소민_educatee\r\n" + 
					 "where id='"+id+"'";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("deleteStudent(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}


	
	

}
