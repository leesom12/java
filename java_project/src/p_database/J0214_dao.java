package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class J0214_dao {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	//성명 조회
	String getName(String id){
		String name="";
		String query="select name from member \r\n" + 
					 "where id='"+id+"'";
		
		try {
			con= DBConnection.getConnection();		// 데이터 베이스에 접속
			ps= con.prepareStatement(query);		// 실행 준비. 쿼리문을 실행
			rs= ps.executeQuery();					// 결과 도출. 조회해올때 사용하는 class
			
			if(rs.next()) {							// 결과가 존재하면 true 값으로 return해주는 메소드(boolean)
				// name=rs.getString(1);			// database에서 조회하고자 하는 column의 순서 
				name=rs.getString("name");			// database에서 조회하고자 하는 column의 이름
			}
			
		} catch (SQLException e) {
			System.out.println("getName(): "+query);
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);		// 오류가 나든 말든 db접속을 끊어줌
		}
		
		return name;
	}
	
	//1명의 회원정보 조회
	J0214_dto getMemberInfo(String id) {
		J0214_dto dto= null;
		String query="select id, name, area, age from member\r\n" + 
					 "where id='"+id+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			
			if(rs.next()) {
				id= rs.getString(1);
				String name=rs.getString("name");
				String area=rs.getString("area");
				int age=rs.getInt("age");
				dto= new J0214_dto(id, name, area, age);
			}
			
		}catch(SQLException e) {
			System.out.println("getMemberInfo(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dto;
	}
	
	
	// 모든 회원목록 조회
	ArrayList<J0214_dto> getMemberList(String gubun, String search){
		ArrayList<J0214_dto> dtos= new ArrayList<J0214_dto>();
		String query="select m.id, m.name, a.area_name as area, m.age \r\n" + 
					 "from member m, areacommon a\r\n" + 
					 "where m.area = a.area_code\r\n" + 
					 "and "+gubun+" like '%"+search+"%' \r\n"+
					 "order by m.id asc";
//		System.out.println(query);
		
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			
			while(rs.next()) {								// true이면 계속 반복되는 조건문. 가져오는 값이 여러 개일 때 주로 사용
				String id= rs.getString("id");
				String name= rs.getString("name");
				String area= rs.getString("area");
				int age= rs.getInt("age");
					
				J0214_dto dto= new J0214_dto(id, name, area, age);
				dtos.add(dto);
			}
			
		}catch(SQLException e) {
			System.out.println("getMemberList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dtos;
	}
	
	void dtosPrint(ArrayList<J0214_dto> dtos) {
		
		if(dtos.size() == 0) {
			System.out.println("검색 결과 없음");
		} else {
			System.out.println("\n"+"총 인원: "+dtos.size()+"명");
			System.out.println("\n"+"ID"+"\t"+"NAME"+"\t"+"AREA"+"\t"+"AGE");
			System.out.println("-----------------------------");
			for(int k=0; k<dtos.size(); k++) {
				System.out.print(dtos.get(k).getId()+"\t");
				System.out.print(dtos.get(k).getName()+"\t");
				System.out.print(dtos.get(k).getArea()+"\t");
				System.out.print(dtos.get(k).getAge()+"\n");
			}
		}
	}
	
}
