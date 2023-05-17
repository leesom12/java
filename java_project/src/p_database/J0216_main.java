package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class J0216_main {

	public static void main(String[] args) {
		J0216_student_dao dao= new J0216_student_dao();
		
		ArrayList<J0216_student_dto> dtos= new ArrayList<J0216_student_dto>();
		dtos=dao.getSelect("id","",0);
		dao.resultPrint(dtos);
		
		Scanner sc= new Scanner(System.in);
		
		int gubun=0;
		do {
			System.out.print("\n");
			System.out.print("검색 ID[1], 성명[2], 종료[0]");
			gubun=sc.nextInt();
			
			if(gubun== 1) {
				System.out.print("ID 검색?");
				String id= sc.next();
				dtos=dao.getSearchList("id", id);
				dao.resultPrint(dtos);
			}else if(gubun== 2) {
				System.out.print("성명 검색?");
				String name= sc.next();
				dtos=dao.getSearchList("name", name);
				dao.resultPrint(dtos);
			}else if(gubun!=0 && gubun!=1 && gubun!=2){
				System.out.println("입력 오류!!");
			}
		}while(gubun!= 0);
		
		System.out.println("종료");

	
//		System.out.println("=====================================================");
//		System.out.print("총점 몇 점 이상?");
//		int total= sc.nextInt();
//		dtos=dao.getSelect("id","",total);
//		dao.resultPrint(dtos);

	}

}
