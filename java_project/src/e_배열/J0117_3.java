package e_배열;

import java.util.Scanner;

public class J0117_3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("몇 과목?");
		int count=sc.nextInt();
		String[]score=new String[count+2];
		int total=0;
		
		for(int k=0; k<count; k++) {
			System.out.print((k+1)+"번째 점수?");
			score[k]=sc.next();
			total=total+Integer.parseInt(score[k]);
		}
		
		score[count]="총점: "+Integer.toString(total);
		int ave=total/count;
		score[count+1]="평균: "+Integer.toString(ave);
		
		for(int k=0; k<score.length; k++) {
			System.out.print(score[k]+"점"+"\t");
		}

	}

}
