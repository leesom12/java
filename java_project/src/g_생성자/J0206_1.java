package g_생성자;

import java.util.Scanner;

public class J0206_1 {

	public static void main(String[] args) {
		J0206_member_dao dao= new J0206_member_dao();
		Scanner sc= new Scanner(System.in);
		
		System.out.print("몇 명?");
		int count= sc.nextInt();
		
		J0206_member_dto[] arr= new J0206_member_dto[count];
		
		for(int k=0; k<arr.length; k++) {
			System.out.print("아이디?");
			String id= sc.next();
			System.out.print("성명?");
			String name= sc.next();
			System.out.print("키?");
			double height= sc.nextDouble();
			System.out.print("몸무게");
			double weight= sc.nextDouble();
			
			String result= dao.getResult(height, weight);
			J0206_member_dto dto= new J0206_member_dto(id, name, height, weight, result);
			arr[k]= dto;
		}
		
		dao.getPrint(arr);

	}

}
