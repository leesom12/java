package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class J0207_2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		ArrayList<J0207_1_dto> dtos= new ArrayList<>();
		
		System.out.print("몇 명?");
		int count= sc.nextInt();
		
		for(int k=0; k<count; k++) {
			System.out.print("아이디?");
			String id= sc.next();
			System.out.print("성명?");
			String name= sc.next();
			System.out.print("지역?");
			String area= sc.next();
			System.out.print("나이?");
			int age= sc.nextInt();
			
			J0207_1_dto dto= new J0207_1_dto(id, name, area, age);
			dtos.add(dto);
		}
		
		System.out.println("ID"+"\t"+"성명"+"\t"+"지역"+"\t"+"나이");
		System.out.println("----------------------------");
		for(int k=0; k<dtos.size(); k++) {
			System.out.print(dtos.get(k).getId()+"\t");
			System.out.print(dtos.get(k).getName()+"\t");
			System.out.print(dtos.get(k).getArea()+"\t");
			System.out.print(dtos.get(k).getAge()+"\n");
		}
	}

}
