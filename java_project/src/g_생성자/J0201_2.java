package g_생성자;

import java.util.Scanner;

public class J0201_2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		J0201_dao dao= new J0201_dao();
		
		System.out.print("몇 명?");
		int count= sc.nextInt();
		
		J0201_dto[] arr= new J0201_dto[count];
		
		for(int k=0; k<arr.length; k++) {
			System.out.print("성명?");
			String name= sc.next();
			System.out.print("나이?");
			int age= sc.nextInt();
			System.out.print("지역? 서울:S, 대전:D, 청주:C, 부산:B");
			String area= sc.next();
			System.out.print("학력? 중졸:M, 고졸:H, 대졸:U");
			String edu= sc.next();
			
			area= dao.getAreaName(area);
			edu= dao.getEduName(edu);
			J0201_dto dto= new J0201_dto(name, area, edu, age);
			arr[k]=dto;
		}
		
		for(int k=0; k<arr.length; k++) {
			System.out.println("성명: "+ arr[k].getName());
			System.out.println("나이: "+arr[k].getAge() );
			System.out.println("지역: "+arr[k].getArea());
			System.out.println("학력: "+arr[k].getEdu());
			System.out.println("");
		}
		

	}

}
