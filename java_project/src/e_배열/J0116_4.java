package e_배열;

import java.util.Scanner;

public class J0116_4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("몇 과목?");
		int count=sc.nextInt();
		
		int[]score=new int[count];
		for(int k=0; k<count; k++) {
			System.out.print("점수?");
			score[k]=sc.nextInt();
		}
		
		System.out.println("---------------------");
		for(int k=0; k<count; k++) {
			System.out.print(score[k]+"\t");
		}
		
	}

}
