package g_생성자;

import java.util.Scanner;

public class J0130_2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		J0130_1_dao dao = new J0130_1_dao();
		J0130_student dto= new J0130_student();
		
		System.out.print("이름?");
		String name= sc.next();
		System.out.print("국어 점수?");
		int kor=sc.nextInt();
		System.out.print("영어 점수?");
		int eng=sc.nextInt();
		System.out.print("수학 점수?");
		int mat=sc.nextInt();
		
//		int total= dao.getTotal(kor, eng, mat);
//		int ave= dao.getAve(total, 3);
		
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMat(mat);
		
		int total= dao.getTotal(dto);
		dto.setTotal(total);
		int ave = dao.getAve(dto);
		dto.setAve(ave);
		
//		dao.getSetTotal(dto);
//		dao.getSetAve(dto);
//		dto.setTotal(total);
//		dto.setAve(ave);
		
		System.out.println("name: "+dto.getName());
		System.out.println("kor: "+dto.getKor());
		System.out.println("eng: "+dto.getEng());
		System.out.println("mat: "+dto.getMat());
		System.out.println("total: "+dto.getTotal());
		System.out.println("ave: "+dto.getAve());

	}

}
