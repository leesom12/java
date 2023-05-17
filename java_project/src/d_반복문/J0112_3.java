package d_반복문;

import java.util.Scanner;

public class J0112_3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("몇부터?");
		int start=sc.nextInt();
		System.out.print("몇까지?");
		int end=sc.nextInt();
		int total=0;
		
		for(int k=start; k<=end; k++) {
			total+=k;
		}
		System.out.println("총합: "+total);
	}

}
