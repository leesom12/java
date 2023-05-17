package e_배열;

import java.util.Scanner;

public class J0117_1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("몇 과목?");
		int count=sc.nextInt();
		
		int[]score=new int[count+2];
		int total=0;
		
		for(int k=0; k<count; k++) {
			System.out.print((k+1)+"번째 점수?");
			score[k]=sc.nextInt();
			total=total+score[k];
		}

		score[count]=total;
		int ave=total/count;
		score[count+1]=ave;
		
		for(int k=0; k<score.length; k++) {
			System.out.print(score[k]+"\t");
		}

	}

}
