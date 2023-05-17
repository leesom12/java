package b_if;

import java.util.Scanner;

public class J0106_3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("몇 학년?");
		int grade=sc.nextInt();
		String result="불합격";
		
		if(grade>6 || grade<1) {
			System.out.println("학년 입력 오류입니다.");
		}else{
			System.out.print("점수?");
			int score=sc.nextInt();
			 if(score>100 || score<0) {
				System.out.println("점수 입력 오류입니다.");
			} else {
				if(grade>=4) {
					if(score>=80) result="합격"; 
				} else {
					if(score>=70)  result="합격";
				}
				System.out.println(grade+"학년 "+score+"점으로 "+result+"입니다.");
			}		
		
		}
	}
}		
			
