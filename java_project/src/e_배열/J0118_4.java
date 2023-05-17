package e_배열;

import java.util.Scanner;

public class J0118_4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("몇 명?");
		int name=sc.nextInt();
		System.out.print("몇 과목?");
		int sub=sc.nextInt();
		
		String[][] score= new String[name][sub+1];
		
		for(int k=0; k<score.length; k++) {
			for(int j=0; j<score[k].length; j++) {
				if(j==0) System.out.print("이름?");
				else System.out.print(j+"번째 점수?");
				score[k][j]=sc.next();
			}
		}
		
		for(int k=0; k<score.length; k++) {
			for(int j=0; j<score[k].length; j++) {
				System.out.print(score[k][j]+"\t");
			}
			System.out.print("\n");
		}

	}

}
