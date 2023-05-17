package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class J0221_이소민_dao {
	Connection con= null;
	PreparedStatement ps= null;
	ResultSet rs= null;
	
	//검색
	ArrayList<J0221_이소민_dto> searchInfo(String gubun, String search){
		ArrayList<J0221_이소민_dto> dtos= new ArrayList<>();
		String qeury="select id, name, area, age from e_이소민_member\r\n" + 
					 "where "+gubun+" like '%"+search+"%'\r\n"+
					 "order by id asc";
		
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(qeury);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				String id= rs.getString("id");
				String name= rs.getString("name");
				String area= rs.getString("area");
				if(area == null) area="";
				int age= rs.getInt("age");
				
				J0221_이소민_dto dto = new J0221_이소민_dto(id, name, area, age);
				dtos.add(dto);
			}
			
		}catch(SQLException e) {
			System.out.println("searchInfo() 오류: "+qeury);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dtos;
	}

	// 프린트
	public void setPrint(ArrayList<J0221_이소민_dto> dtos) {
		System.out.println("============================");
		System.out.println("ID\t성명\t지역\t나이");
		System.out.println("----------------------------");
		if(dtos.size() == 0) System.out.println("\t    정보없음");
		else {
			for(int k=0; k<dtos.size(); k++) {
				System.out.print(dtos.get(k).getId()+"\t");
				System.out.print(dtos.get(k).getName()+"\t");
				System.out.print(dtos.get(k).getArea()+"\t");
				if(dtos.get(k).getAge() == 0) {
					System.out.print(""+"\n");
				} else System.out.print(dtos.get(k).getAge()+"\n");
			}
		}
		System.out.println("----------------------------");
		
	}

	//등록
	public int saveInfo(J0221_이소민_dto dto) {
		int result=0;
		String query="insert into e_이소민_member\r\n" + 
					 "(id, name, area, age)\r\n" + 
					 "values\r\n" + 
					 "('"+dto.getId()+"', '"+dto.getName()+"', '"+dto.getArea()+"', "+dto.getAge()+")";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveInfo() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}

	// 한 명 검색
	public J0221_이소민_dto getIdResult(String id) {
		J0221_이소민_dto arr= null;
		String query="select id, name, area, age from e_이소민_member\r\n" + 
					 "where id like '"+id+"'";
		try {
			con=DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				String name= rs.getString("name");
				String area= rs.getString("area");
				if(area == null) area="";
				int age= rs.getInt("age");
				
				arr= new J0221_이소민_dto(id, name, area, age);
			}
			
		} catch(Exception e) {
			System.out.println("getIdResult() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return arr;
	}

	//수정
	public int updateInfo(J0221_이소민_dto dto) {
		int result =0;
		String query="update e_이소민_member\r\n" + 
					 "set name='"+dto.getName()+"', area='"+dto.getArea()+"', age="+dto.getAge()+"\r\n" + 
					 "where id='"+dto.getId()+"'";
		
		try {
			con=DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result=ps.executeUpdate();
		} catch(Exception e) {
			System.out.println("updateInfo() 오류 "+ query);
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}

	//삭제
	public int deleteInfo(String id) {
		int result =0;
		String query="delete from e_이소민_member\r\n" + 
					 "where id='"+id+"'";
		
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("deleteInfo() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
}
