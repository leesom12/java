package g_생성자;

import java.util.Scanner;

public class J0203_이소민 {

	public static void main(String[] args) {
		J0203_이소민_dao dao= new J0203_이소민_dao();
		Scanner sc= new Scanner(System.in);
		
		System.out.print("몇 명?");
		int count= sc.nextInt();
		
		J0203_이소민_dto[] arr= new J0203_이소민_dto[count];
		for(int k=0; k<arr.length; k++) {
			System.out.print("이름?");
			String name= sc.next();
			System.out.print("국어?");
			int kor= sc.nextInt();
			System.out.print("영어?");
			int eng= sc.nextInt();
			System.out.print("수학?");
			int mat= sc.nextInt();
			
			int ave=dao.getAve(kor, eng, mat);
			String result= dao.getResult(ave);
			
			J0203_이소민_dto dto= new J0203_이소민_dto(name, kor, eng, mat, ave, result);
			arr[k]=dto;
		}
		
		dao.getPrint(arr);
	}

}
