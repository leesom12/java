package b_if;

import java.util.Scanner;

public class J0109_2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("평균?");
		int ave = sc.nextInt();
		
		if(ave>100 || ave<0) {
			System.out.println("점수 입력 오류");
		}else if(ave>=90) {
			System.out.println("A");
		} else if(ave>=80) {
			System.out.println("B");
		} else if(ave>=70) {
			System.out.println("C");
		} else if(ave>=60) {
			System.out.println("D");
		} else System.out.println("F");

	}

}
