package d_반복문;

import java.util.Scanner;

public class J0112_4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		/*
		int total=0;
		for(int k=1; k<=5; k++) {
			 System.out.print("수 입력?");
			 int num=sc.nextInt();
			 total+=num;
		 }
		System.out.println("총합: "+total);
		*/
		
		int total=0;
		for(int k=1; true; k++) {
			System.out.print("수 입력?");
			int num=sc.nextInt();
			total+=num;
			if(num==0) break;
		}
		System.out.println("총합: "+ total);
	}

}
