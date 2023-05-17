package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class J0215_main {

	public static void main(String[] args) {
		J0214_dao dao= new J0214_dao();
		Scanner sc= new Scanner(System.in);
//		
//		System.out.print("ID?");
//		String id=sc.next();
//		J0214_dto dto= dao.getMemberInfo(id);
//		
//		if(dto == null) {
//			System.out.println("존재하지 않는 ID");
//		}else {
//			System.out.println("ID: "+dto.getId());
//			System.out.println("name: "+dto.getName() );
//			System.out.println("area: "+dto.getArea());
//			System.out.println("age: "+dto.getAge());
//		}
		
		ArrayList<J0214_dto> dtos = new ArrayList<J0214_dto>();
		dtos =dao.getMemberList("m.name","");
		dao.dtosPrint(dtos);
		
		System.out.println("=================================");
		System.out.print("검색할 이름?");
		String search= sc.next();
		dtos =dao.getMemberList("m.name", search);
		dao.dtosPrint(dtos);
		
		System.out.println("=================================");
		System.out.print("검색할 ID?");
		String id= sc.next();
		dtos= dao.getMemberList("m.id", id);
		dao.dtosPrint(dtos);
		
	}

}
