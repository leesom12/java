package g_생성자;

import java.util.Scanner;

public class J0206_2 {

	public static void main(String[] args) {
		J0206_2_dao dao= new J0206_2_dao();
		Scanner sc= new Scanner(System.in);
		
		System.out.print("몇 명?");
		int count= sc.nextInt();
		
		J0206_2_dto[] arr= new J0206_2_dto[count];
		
		for(int k=0; k<arr.length; k++) {
			System.out.print("아이디?");
			String id= sc.next();
			System.out.print("성명?");
			String name= sc.next();
			System.out.print("국어 점수?");
			int kor= sc.nextInt();
			System.out.print("영어 점수?");
			int eng= sc.nextInt();
			System.out.print("수학 점수?");
			int mat= sc.nextInt();
			
			double ave= dao.getAve(kor, eng, mat);
			String result= dao.getResult(kor, eng, mat);
			
			J0206_2_dto dto = new J0206_2_dto(id, name, kor, eng, mat, ave, result);
			arr[k]= dto;
		}
		dao.getPrint(arr);

	}

}
