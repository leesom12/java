package g_생성자;

import java.util.Scanner;

public class J0202_1 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		J0202_dao dao= new J0202_dao();
		
		J0202_dto[] arr = new J0202_dto[2];
		
		int salary=0;
		for(int k=0; k<arr.length; k++) {
			System.out.print("사번?");
			String sabun= sc.next();
			System.out.print("성명?");
			String name= sc.next();
			System.out.print("부서[총무:c , 재무:j , 영업:y]?");
			String depart= sc.next();
			System.out.print("직위[사원:10 , 대리:20 , 과장:30]?");
			String rank= sc.next();
			
			depart=dao.getDepartName(depart);
			rank= dao.getRankName(rank);
			salary=dao.getSalary(depart, rank);
			
			J0202_dto dto= new J0202_dto(sabun, name, depart, rank, salary);
			arr[k]=dto;
		}
		
		System.out.println("=============================");
		dao.getPrint(arr);
		
		System.out.println("=============================");
		System.out.print("성명 검색?");
		String search= sc.next();
		dao.searchData(arr, search);

	}

}
