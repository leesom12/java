package e_배열;

import java.util.Scanner;

public class J0118_3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("몇 명 입력?");
		int name=sc.nextInt();
		
		String [][] str=new String[name][3];
		
		for(int k=0; k<str.length; k++) {
			for(int j=0; j<str[k].length; j++) {
				if(j==0) System.out.print("성명?");
				else if(j==1) System.out.print("지역?");
				else if(j==2) System.out.print("나이?");
				str[k][j]=sc.next();
			}
		}
		
		for(int k=0; k<str.length; k++) {
			for(int j=0; j<str[k].length; j++) {
				System.out.print(str[k][j]+"\t");
			}
			System.out.print("\n");
		}
	}

}
