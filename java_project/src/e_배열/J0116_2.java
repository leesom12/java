package e_배열;

import java.util.Scanner;

public class J0116_2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("몇 명?");
		int count=sc.nextInt();
		String[] name=new String[count];
		
		for(int k=0; k<count; k++) {
			System.out.print("이름 입력?");
			name[k]=sc.next();
		}
		for(int k=0; k<count; k++) {
			System.out.println("성명: "+name[k]);
		}
		
		

	}

}
