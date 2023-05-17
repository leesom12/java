package b_if;

import java.util.Scanner;

public class J0111_4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("성명?");
		String name=sc.next();
		System.out.print("학년?");
		int grade=sc.nextInt();
		
		if(grade>=1 && grade<=6) {
			System.out.print("국어 점수?");
			int kor=sc.nextInt();
			System.out.print("수학 점수?");
			int mat=sc.nextInt();
			System.out.print("영어 점수?");
			int eng=sc.nextInt();
			
			if(kor>=0 && kor<=100 && eng>=0 && eng<=100 && mat>=0 && mat<=100) {
				int ave=(kor+mat+eng)/3;
				String result="불합격";		
				if (grade<=3) {
					if (ave>=70) result="합격";
					} else {
						if (ave>=80) result="합격";
					}
				System.out.println("성명: "+name);
				System.out.println("학년: "+grade);
				System.out.println("평균: "+ave);
				System.out.println("결과: "+result);
			
			}else System.out.println("점수 입력 오류!!");
		}else System.out.println("학년 입력 오류!!");
	}

}
