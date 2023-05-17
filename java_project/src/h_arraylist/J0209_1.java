package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class J0209_1 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		J0209_1_dao dao= new J0209_1_dao();
		
		System.out.print("몇 명?");
		int count= sc.nextInt();
		
		ArrayList<J0209_1_dto> arr= new ArrayList<>();
		for(int k=0; k<count; k++) {
			System.out.print("성명?");
			String name= sc.next();
			System.out.print("성별? [남:m, 여:f]");
			String gender= sc.next();
			System.out.print("나이?");
			int age= sc.nextInt();
			
			J0209_1_dto dto= new J0209_1_dto();
			
			dto.setName(name);
			dto.setGender(dao.getGender(gender));
			dto.setAge(age);
			dto.setMoney(dao.getMoney(gender, age));
			
			arr.add(dto);
		}
		
		dao.setPrint(arr);
		
	}

}
