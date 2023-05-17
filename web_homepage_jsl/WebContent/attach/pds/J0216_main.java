package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class J0216_main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		J0216_student_dao dao = new J0216_student_dao();
		ArrayList<J0216_student_dto> dtos = 
				          dao.getStudentList();
		dao.resultPrint(dtos);
		
		int gubun = 0;
		do{
			System.out.print("검색 ID[1], 성명:[2], 종료[0]?");
			gubun = sc.nextInt();
			if(gubun == 1){
				System.out.print("ID?");
				String id = sc.next();
				ArrayList<J0216_student_dto> arr =
						    dao.getSearchList("id",id);
				
				
			}else if(gubun == 2) {
				System.out.print("성명?");
				String name = sc.next();
				ArrayList<J0216_student_dto> arr =
					       dao.getSearchList("name",name);			
			}
			
		}while(gubun != 0);
		
		System.out.println("종료~~~");
		
		
	
		
	}

}










