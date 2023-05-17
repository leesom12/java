package e_배열;

import java.util.Scanner;

public class J0116_5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("몇 과목?");
		int count=sc.nextInt();
		
		int[] score= new int[count];
		int total=0;
		for(int k=0; k<score.length; k++) {
			System.out.print((k+1)+"번 째 점수?");
			score[k]=sc.nextInt();
		}
		
		for(int k=0; k<count; k++) {
			System.out.print(score[k]+"점"+"\t");
			total=total+score[k];
		}
		int ave=total/count;
		
		System.out.println("  ");
		System.out.println("총점: "+total);
		System.out.println("평균: "+ave);

	}

}
