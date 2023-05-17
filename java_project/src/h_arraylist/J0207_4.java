package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class J0207_4 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		ArrayList<J0207_4_dto> dtos= new ArrayList<>();
		J0207_4_dao dao= new J0207_4_dao();
		
		System.out.print("몇 명?");
		int count= sc.nextInt();
		
		for(int k=0; k<count; k++) {
			System.out.print("아이디?");
			String id= sc.next();
			System.out.print("성명?");
			String name= sc.next();
			System.out.print("나이?");
			int age= sc.nextInt();
			System.out.print("부서? [총무: 10, 재무: 20, 영업: 30]");
			String depart= sc.next();
			System.out.print("직위? [사원:s, 대리:d, 과장:g]");
			String rank= sc.next();
			
			depart= dao.getDepart(depart);
			rank= dao.getRank(rank);
			
			J0207_4_dto dto= new J0207_4_dto(id, name, age, depart, rank);
			dtos.add(dto);
		}
		
		System.out.println("-------------------------------------");
		System.out.println("ID"+"\t"+"성명"+"\t"+"나이"+"\t"+"부서"+"\t"+"직위");
		System.out.println("-------------------------------------");
		
		for(int k=0; k<dtos.size(); k++) {
			System.out.print(dtos.get(k).getId()+"\t");
			System.out.print(dtos.get(k).getName()+"\t");
			System.out.print(dtos.get(k).getAge()+"\t");
			System.out.print(dtos.get(k).getDepart()+"\t");
			System.out.print(dtos.get(k).getRank()+"\n");
		}

	}

}
