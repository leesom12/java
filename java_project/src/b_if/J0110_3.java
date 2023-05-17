package b_if;

import java.util.Scanner;

public class J0110_3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("직업? 학생 1 주부 2 회사원 3");
		String job=sc.next();
		System.out.print("월 납입액?");
		int monthSave=sc.nextInt();
		System.out.print("몇 년?");
		int year=sc.nextInt();
		
		int total=monthSave*12*year;
		double finalWon=0;
		
		if(job.equals("1")) {
			finalWon=total*1.2;
		}else if(job.equals("2")) {
			finalWon=total*1.1;
		}else if(job.equals("3")) {
			finalWon=total*1.05;
		}else System.out.println("직업 입력 오류");
		
		if(job.equals("1") || job.equals("2") || job.equals("3")) {
			System.out.println("최종 만기금액: "+finalWon+"원");
		}

	}

}
