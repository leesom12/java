package b_if;

import java.util.Scanner;

public class J0110_4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("학년?");
		int grade=sc.nextInt();
		
		if (grade>=1 && grade<=6) {
			System.out.print("평균?");
			int ave=sc.nextInt();
			String result="불합격";
			
			if(ave>=0 && ave<=100) {
				if (grade<=3) {
					if(ave>=70) result="합격";
				}else {
					if (ave>=80) result="합격";
				}
				System.out.println(grade+"학년 "+result);
			}else System.out.println("평균 입력 오류");
		}else System.out.println("학년 입력 오류");
		
		
		
		
		
		
/*		String grade=sc.next();
		int level=Integer.parseInt(grade);
		String result="불합격";
		
		if(level>=1 && level<=6) {
			System.out.print("평균?");
			int ave=sc.nextInt();
			
			if(ave<=100 && ave>=0) {
				if(grade.equals("1")||grade.equals("2")) {
					if (ave>=60) result="합격";
				}else if(grade.equals("3")||grade.equals("4")) {
					if(ave>=70) result="합격";
				}else{
					if(ave>=80) result="합격";
				}
				System.out.println( grade+"학년 "+result);
			}else System.out.println("평균 입력 오류");
		}else System.out.println("학년 입력 오류");
		*/
	}

}
