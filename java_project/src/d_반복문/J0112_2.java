package d_반복문;

import java.util.Scanner;

public class J0112_2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("몇부터?");
		int start=sc.nextInt();
		System.out.print("몇까지?");
		int end=sc.nextInt();
		
		int jjak=0;
		for(int k=start; k<=end; k++) {
			if(k%2==0) {
				System.out.println("k: "+k);
				jjak+=1;
			}
		}
		
		System.out.println("짝수 : "+ jjak +"개");

	}

}
