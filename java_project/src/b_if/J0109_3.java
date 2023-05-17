package b_if;

import java.util.Scanner;

public class J0109_3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("국어점수?");
		int kor=sc.nextInt();
		if (kor<0 || kor>100) System.out.println("국어점수 입력 오류");
		else {
			System.out.print("영어점수?");
			int eng=sc.nextInt();
			if (eng<0 || eng>100) System.out.println("영어점수 입력 오류");
			else {
				System.out.print("수학점수?");
				int mat=sc.nextInt();
				if (mat<0 || mat>100) System.out.println("수학점수 입력 오류");
				else {
					int total=kor+eng+mat;
					int ave=total/3;
					
					String result="";
					if (ave>=90) result="A";
					else if (ave>=80) result="B";
					else if (ave>=70) result="C";
					else result="F";
					
					System.out.println("총점: "+total);
					System.out.println("평균: "+ave);
					System.out.println("결과: "+result);
				}
			}
		}
		
		/*
		System.out.print("국어점수?");
		int kor=sc.nextInt();
		System.out.print("영어점수?");
		int eng=sc.nextInt();
		System.out.print("수학점수?");
		int mat=sc.nextInt();
		
		int total=kor+eng+mat;
		int ave=total/3;
		
		if (kor>100 || kor<0 || eng>100 || eng<0 || mat>100 || mat<0) {
			System.out.println("점수 입력 오류");
		} else { String result="";
				if(ave>=90) {
					result="A";
				} else if(ave>=80) {
					result="B";
				}else if(ave>=70) {
					result="C";
				} else result="F";
		
				System.out.println("총점: "+total);
				System.out.println("평균: "+ave);
				System.out.println("결과: "+result);
		}
		*/
		
		
		
		
		/*
		System.out.print("국어점수?");
		String kor=sc.next();
		System.out.print("영어점수?");
		String eng=sc.next();
		System.out.print("수학점수?");
		String mat=sc.next();
		
		String total= Integer.toString( 
				 	  Integer.parseInt(kor)+
				      Integer.parseInt(eng)+
				      Integer.parseInt(mat));
		
		int ave= Integer.parseInt(total)/3;
		
		String result="";				// int는 0으로 초기화
		if(ave>=90) result="A";
		else if(ave>=80) result="B";
		else if(ave>=70) result="C";
		else result="F";
		
		System.out.println("총점: "+total);
		System.out.println("평균: "+ave);
		System.out.println("결과: "+result);
		*/
		
		
	}

}
