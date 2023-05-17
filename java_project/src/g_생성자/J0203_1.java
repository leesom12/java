package g_생성자;

import java.util.Scanner;

public class J0203_1 {

	public static void main(String[] args) {
		J0203_dao dao= new J0203_dao();
		Scanner sc= new Scanner(System.in);
		
		System.out.print("몇 명?");
		int count= sc.nextInt();
		J0203_dto[] arr= new J0203_dto[count];
		
		for(int k=0; k<arr.length; k++) {
			System.out.print("성명?");
			String name= sc.next();
			System.out.print("성별? [남:m, 여:f]");
			String gender= sc.next();
			System.out.print("나이?");
			int age= sc.nextInt();
			
			gender=dao.getGenderName(gender);
			int money= dao.getMoney(gender, age);
			
			J0203_dto dto = new J0203_dto(name, gender, age, money);
			arr[k]= dto;
		}
		
		System.out.println("==============================");
		dao.getPrint(arr);

	}

}
