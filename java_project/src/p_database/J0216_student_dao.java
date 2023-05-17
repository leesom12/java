package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class J0216_student_dao {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	ArrayList<J0216_student_dto> getSelect(String gubun, String search, int totalScore) {
		ArrayList<J0216_student_dto> dtos= new ArrayList<J0216_student_dto>();
		String qeury="select id, name, kor, eng, mat, total, result\r\n" + 
					 "from e_이소민_student\r\n"+
					 "where "+gubun+" like '%"+search+"%' \r\n"+
					 "and total >= "+totalScore+" \r\n"+
					 "order by id asc";
		
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(qeury);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				String id= rs.getString("id");
				String name= rs.getString("name");
				int kor= rs.getInt("kor");
				int eng= rs.getInt("eng");
				int mat= rs.getInt("mat");
				int total= rs.getInt("total");
				String result= rs.getString("result");
				
				J0216_student_dto dto= new J0216_student_dto(id, name, kor, eng, mat, total, result);
				dtos.add(dto);
			}
			
		}catch(SQLException e) {
			System.out.println("getSelect() 오류 발생: "+"select id, name, kor, eng, mat, total, result\r\n" +
								"from e_이소민_student");
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dtos;
	}
	
	//doWhile문 아이디, 이름 검색
	ArrayList<J0216_student_dto> getSearchList(String gubun, String search){
		ArrayList<J0216_student_dto> dtos= new ArrayList<J0216_student_dto>();
		String query="select id, name, kor, eng, mat, total, result\r\n" + 
					 "from e_이소민_student\r\n" + 
					 "where "+gubun+" like '%"+search+"%'\r\n" + 
					 "order by id asc";
		
		try {
			con= DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				String id= rs.getString("id");
				String name= rs.getString("name");
				int kor= rs.getInt("kor");
				int eng= rs.getInt("eng");
				int mat= rs.getInt("mat");
				int total= rs.getInt("total");
				String result= rs.getString("result");
				
				J0216_student_dto dto= new J0216_student_dto(id, name, kor, eng, mat, total, result);
				dtos.add(dto);
			}
			
		}catch(SQLException e) {
			System.out.println("getSearchList() 오류발생: "+"select id, name, kor, eng, mat, total, result\r\n" + 
					 			"from e_이소민_student\r\n" + 
					 			"where "+gubun+" like '%"+search+"%'\r\n" + 
								"order by id asc");
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dtos;
	}

	//프린트
	void resultPrint(ArrayList<J0216_student_dto> dtos) {
		if(dtos.size() == 0) {
			System.out.println("검색 결과 없음");
		}else {
			System.out.println("\n"+"총 인원: "+dtos.size()+"명");
			System.out.println("=====================================================");
			System.out.println("ID\t성명\t국어\t영어\t수학\t총점\t결과");
			System.out.println("-----------------------------------------------------");
			for(int k=0; k<dtos.size(); k++) {
				System.out.print(dtos.get(k).getId()+"\t");
				System.out.print(dtos.get(k).getName()+"\t");
				System.out.print(dtos.get(k).getKor()+"\t");
				System.out.print(dtos.get(k).getEng()+"\t");
				System.out.print(dtos.get(k).getMat()+"\t");
				System.out.print(dtos.get(k).getTotal()+"\t");
				System.out.print(dtos.get(k).getResult()+"\n");
			}
			System.out.println("-----------------------------------------------------");
		}
	}
}
