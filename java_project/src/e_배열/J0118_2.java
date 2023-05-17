package e_배열;

import java.util.Scanner;

public class J0118_2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[][] score=new int[2][3];
		
		for(int k=0; k<score.length; k++) {
			for(int j=0; j<score[k].length; j++) {
				System.out.print("점수 입력?");
				score[k][j]=sc.nextInt();
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
