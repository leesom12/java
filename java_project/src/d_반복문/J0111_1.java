package d_반복문;

import java.util.Scanner;

public class J0111_1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("몇 단?");
		int dan=sc.nextInt();
		
		//초기값; 조건(언제까지); 증감
		for(int k=1;k<=9;k++) { //k는 0부터 5보다 작을 동안 하나씩 증감
			System.out.println(dan+"*"+k+" = "+dan*k);
		}
	}

}
