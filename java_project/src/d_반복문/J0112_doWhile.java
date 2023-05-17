package d_반복문;

import java.util.Scanner;

public class J0112_doWhile {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int gu=0;
		do {
			System.out.print("선택? 검색 1, 등록 2, 수정 3");
			gu=sc.nextInt();
		} while(gu!=0);
		
		System.out.println("종료");

	}

}
