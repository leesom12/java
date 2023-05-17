package b_if;

import java.util.Scanner;

public class J0109_1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("남자는 1, 여자는 2?");
		String gender=sc.next();
		String result="비정상";
		
		if (gender.equals("1") || gender.equals("2")) {
			System.out.print("체력지수?");
			int health = sc.nextInt();
			
			if (health>100 || health<0) {
				System.out.println("체력 입력 오류");
			} else {
				if(gender.equals("1")) {
					if (health>=75) result="정상";
				} else {
					if(health>=65) result="정상";
				} System.out.println(result+"입니다");
			}
		}else System.out.println("성별 입력 오류");
		
	}

}
