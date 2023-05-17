package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class J0222_이소민_employee_dao {
	Connection con= null;
	PreparedStatement ps= null;
	ResultSet rs= null;
	ResultSetMetaData rsmd= null;
	Statement sta= null;
	
	//조회
	public ArrayList<J0222_이소민_employee_dto> searchEmployee(String gubun, String search) {
		ArrayList<J0222_이소민_employee_dto> dtos = new ArrayList<J0222_이소민_employee_dto>();
		String query="select e.id, e.name, d.depart_name as depart, r.rank_name as rank, e.age \r\n" + 
					 "from e_이소민_employee e, commondepart d, commonrank r\r\n" + 
					 "where "+gubun+" like '%"+search+"%'\r\n" + 
					 "and e.depart = d.depart_ccode\r\n" + 
					 "and e.rank = r.rank_code\r\n" + 
					 "order by id";
		
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String id= rs.getString("id");
				String name= rs.getString("name");
				String depart= rs.getString("depart");
				String rank= rs.getString("rank");
				int age= rs.getInt("age");
				
				J0222_이소민_employee_dto dto = new J0222_이소민_employee_dto(id, name, depart, rank, age);
				dtos.add(dto);
			}
			
		}catch(Exception e) {
			System.out.println("searchEmployee(): "+query);
			e.printStackTrace();
		}finally {
			
		}
		return dtos;
	}

	//등록
	public int employeeSave(J0222_이소민_employee_dto dto) {
		int result = 0;
		String query="insert into e_이소민_employee\r\n" + 
					 "(id, name, depart, rank, age)\r\n" + 
					 "values('"+dto.getId()+"','"+dto.getName()+"','"+dto.getDepart()+"','"+dto.getRank()+"',"+dto.getAge()+")";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("employeeSvae() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}

	//프린트
	public void resultPrint(ArrayList<J0222_이소민_employee_dto> dtos) {
		System.out.println("====================================");
		System.out.println("사번\t성명\t부서\t직급\t나이");
		System.out.println("------------------------------------");
		if(dtos.size() == 0) {
			System.out.println("\t\t정보없음");
		}else {
			for(int k=0; k<dtos.size(); k++) {
				System.out.print(dtos.get(k).getId()+"\t");
				System.out.print(dtos.get(k).getName()+"\t");
				System.out.print(dtos.get(k).getDepart()+"\t");
				System.out.print(dtos.get(k).getRank()+"\t");
				System.out.print(dtos.get(k).getAge()+"\n");
			}
		}
		System.out.println("------------------------------------");
		if(dtos.size() != 0) {
			System.out.println("총 "+dtos.size()+"명");
			System.out.println("------------------------------------");
		}
	}

	//한 명 검색
	public J0222_이소민_employee_dto getEmployee(String id) {
		J0222_이소민_employee_dto dto= null;
		String query="select e.id, e.name, d.depart_name as depart, r.rank_name as rank, e.age \r\n" + 
					 "from e_이소민_employee e, commondepart d, commonrank r \r\n" + 
					 "where e.depart = d.depart_ccode\r\n" + 
					 "and e.rank = r.rank_code\r\n" + 
					 "and id='"+id+"'";
		
		try{
			con= DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				String name= rs.getString("name");
				String depart= rs.getString("depart");
				String rank= rs.getString("rank");
				int age= rs.getInt("age");
				
				dto= new J0222_이소민_employee_dto(id, name, depart, rank, age);
			}
			
		}catch(Exception e) {
			System.out.println("getEmployee() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dto;
	}

	//수정
	public int updateEmployee(J0222_이소민_employee_dto dto) {
		int result=0;
		String query="update e_이소민_employee \r\n" +
					 "set name='"+dto.getName()+"', depart='"+dto.getDepart()+"', rank='"+dto.getRank()+"', age="+dto.getAge()+"\r\n" + 
					 "where id='"+dto.getId()+"'";
		
		try {
			con= DBConnection.getConnection();
			ps=con.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("updateEmployee() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

	//삭제
	public int deleteEmployee(J0222_이소민_employee_dto dto) {
		int result=0;
		String query="delete from e_이소민_employee\r\n" + 
					 "where id='"+dto.getId()+"'";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("deleteEmployee() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
	
	//컬럼 명 조회
	public ArrayList<String> columnUpdate() {
		ArrayList<String> arr= new ArrayList<String>();
		String query= "select * from e_이소민_employee";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			rsmd=rs.getMetaData();
			
			int cols= rsmd.getColumnCount();
			for(int i=1; i<=cols; i++) {
				arr.add(rsmd.getColumnName(i));
			}
			
		}catch(Exception e) {
			System.out.println("columnUpdate(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}

	//ID 중복 검사
	public int checkId(String id) {
		int count=0;
		String query="select count(*) as count from e_이소민_employee\r\n" + 
					 "where id ='"+id+"'";
		
		try{
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) count= rs.getInt("count");
			
		}catch(Exception e) {
			System.out.println("checkID() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return count;
	}

	//코드 값 가져오기
	public String getCode(String gubun, String id) {
		String code ="";
		String query ="select "+gubun+" from e_이소민_employee\r\n" + 
					  "where id = '"+id+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				code= rs.getString(1);
			}
		}catch(Exception e) {
			System.out.println("checkID() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return code;
	}

	
	
}
