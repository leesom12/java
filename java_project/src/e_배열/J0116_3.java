package e_배열;

import java.util.Scanner;

public class J0116_3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("몇 명?");
		int len=sc.nextInt();
		String[] name=new String[len];
		
		for(int k=0; k<len; k++) {
			System.out.print((k+1)+"번째 이름 입력?");
			name[k]=sc.next();
		}
		for(int k=0; k<len; k++) {
			System.out.println("성명: "+name[k]);
		}
		System.out.println("=========================");
		
		System.out.print("찾고 싶은 문자?");
		String moonja=sc.next();
		int count=0;
		
		for(int k=0; k<len; k++) {
			if(name[k].indexOf(moonja)!=-1) {
				System.out.println(name[k]);
				count+=1;
			}
		}
		System.out.println(count+"명");

	}

}
