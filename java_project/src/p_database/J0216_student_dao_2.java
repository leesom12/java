package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class J0216_student_dao_2{
	Connection 			con = null;
	PreparedStatement 	ps  = null;
	ResultSet 			rs  = null;
	
	//전체 조회
	public ArrayList<J0216_student_dto_2> getStudentList() {
		ArrayList<J0216_student_dto_2> dtos =
									new ArrayList<>();
		String query ="select id, name, kor, eng, mat, total, result \r\n" + 
				      " from e_이소민_student \r\n" + 
				      " order by id asc";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()){
				String id   = rs.getString("id");
				String name = rs.getString("name");
				int kor     = rs.getInt("kor"); 
				int eng     = rs.getInt("eng");
				int mat     = rs.getInt("mat");
				int total   = rs.getInt("total");
				String result = rs.getString("result");
				J0216_student_dto_2 dto =
						new J0216_student_dto_2(id, name, kor, eng, mat, total, result);
				dtos.add(dto);
			}
		}catch(SQLException e){
			System.out.println("getStudentList() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dtos;
	}

	//프린트
	public void resultPrint(ArrayList<J0216_student_dto_2> dtos) {
		System.out.println("=====================================================");
		System.out.println("ID\t성명\t국어\t영어\t수학\t총점\t결과");
		System.out.println("-----------------------------------------------------");
		if(dtos.size() == 0) {
			System.out.println("\t\t\t정보 없음");
		}
		for(int k=0; k< dtos.size(); k++) {
			System.out.print(dtos.get(k).getId()+"\t");
			System.out.print(dtos.get(k).getName()+"\t");
			System.out.print(dtos.get(k).getKor()+"\t");
			System.out.print(dtos.get(k).getEng()+"\t");
			System.out.print(dtos.get(k).getMat()+"\t");
			System.out.print(dtos.get(k).getTotal()+"\t");
			System.out.print(dtos.get(k).getResult()+"\n");
		}		
		System.out.println("-----------------------------------------------------\n");
	}
	
	//id, name 조회
	public ArrayList<J0216_student_dto_2> 
	             getSearchList(String gubun, String search){
	    ArrayList<J0216_student_dto_2> dtos =
	    		                     new ArrayList<>();
	    String query="select id, name, kor, eng, mat, total, result\r\n" + 
		    		 " from e_이소민_student \r\n" + 
		    		 " where "+gubun+" like '%"+search+"%' \r\n" + 
		    		 " order by id asc ";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()){
				String id   = rs.getString("id");
				String name = rs.getString("name");
				int kor     = rs.getInt("kor"); 
				int eng     = rs.getInt("eng");
				int mat     = rs.getInt("mat");
				int total   = rs.getInt("total");
				String result = rs.getString("result");
				J0216_student_dto_2 dto =
						new J0216_student_dto_2(id, name, kor, eng, mat, total, result);
				dtos.add(dto);
			}
		}catch(SQLException e){
			System.out.println("getSearchList() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
	    
		return dtos;
	}

	//총점 도출
	public int getTotal(int kor, int eng, int mat) {
		return kor + eng + mat;
	}

	//결과 도출
	public String getResult(int total) {
		String result="";
		double ave = total / 3.0;
		
		if(ave >=90) result="수";
		else if(ave >=80) result="우";
		else if(ave >=70) result="미";
		else if(ave >=60) result="양";
		else result="가";
		
		return result;
	}
	
	// 등록
	public int saveStudent(J0216_student_dto_2 dto){
		int result = 0;
		String query="insert into e_이소민_student\r\n" + 
				" (id, name, kor, eng, mat, total, result)\r\n" + 
				" values \r\n" + 
				" ('"+dto.getId()+"','"+dto.getName()+"',"+dto.getKor()+","+dto.getEng()+","+dto.getMat()+","+dto.getTotal()+",'"+dto.getResult()+"')";
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
					
		}catch(SQLException e){
			System.out.println("saveStudent() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		
		return result;
	}

	//한 명 조회
	public J0216_student_dto_2 getStudentInfo(String id) {
		J0216_student_dto_2 dto= null;
		String query="select id, name, kor, eng, mat, total, result\r\n" + 
					 "from e_이소민_student\r\n" + 
					 "where id like '"+id+"'";
		
		try {
			con=DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				String name=rs.getString("name");
				int kor= rs.getInt("kor");
				int eng= rs.getInt("eng");
				int mat= rs.getInt("mat");
				int total= rs.getInt("total");
				String result= rs.getString("result");
				
				dto= new J0216_student_dto_2(id, name, kor, eng, mat, total, result);
			}
			
		}catch(SQLException e) {
			System.out.println("getStudentInfo() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dto;
	}

	//수정
	public int updateStudent(J0216_student_dto_2 dto2) {
		int result=0;
		String query="update e_이소민_student\r\n" + 
					 "set name='"+dto2.getName()+"',\r\n"+
					 " kor='"+dto2.getKor()+"',\r\n "+
					 "eng='"+dto2.getEng()+"',\r\n"+
					 " mat='"+dto2.getMat()+"',\r\n"+
					 "total='"+dto2.getTotal()+"',\r\n "+
					 "result='"+dto2.getResult()+"'\r\n" + 
					 "where id='"+dto2.getId()+"'";
		
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("updatStudent() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}

	//삭제
	public int deleteStudent(String id) {
		int result=0;
		String query="delete from e_이소민_student\r\n" + 
					 "where id='"+id+"'";
		
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("deleteStudent() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}





}



























