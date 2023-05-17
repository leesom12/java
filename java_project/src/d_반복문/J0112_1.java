package d_반복문;

import java.util.Scanner;

public class J0112_1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("몇단부터?");
		int start=sc.nextInt();
		System.out.print("몇단까지?");
		int end=sc.nextInt();
		
		if(start<=end) {
			for (int a=start; a<=end; a++) {
				for(int b=1; b<=9; b++) {
					System.out.println(a+"*"+b+" = "+a*b);
				}
			}
		} else System.out.println("값 입력 오류!!");
		

//		for(int k=1; k<=5; k++) {
//			for(int j=1; j<3; j++) {
//				System.out.println("K: "+k+" J: "+j);
//			}
//		}
		

	}

}
