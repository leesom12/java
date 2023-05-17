package g_생성자;

import java.util.Scanner;

public class J0131_1 {

	public static void main(String[] args) {
		J0131_1_dao dao= new J0131_1_dao();
		Scanner sc= new Scanner(System.in);
		
		System.out.print("이름?");
		String name=sc.next();
		System.out.print("국어점수?");
		int kor= sc.nextInt();
		System.out.print("영어점수?");
		int eng=sc.nextInt();
		System.out.print("수학점수?");
		int mat=sc.nextInt();
		
		J0131_1_dto dto = dao.getDto(name, kor, eng, mat);
		dao.setTotal(dto);
		dao.setAve(dto);
		dao.dtoPrint(dto);
		
//		System.out.println("name: "+dto.getName());
//		System.out.println("total: "+dto.getTotal());
//		System.out.println("ave: "+dto.getAve());
	}

}
