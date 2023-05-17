package g_생성자;

public class J0202_dao {
	
	String getDepartName(String gubun) {
		String depart="";
		if(gubun.equals("c") || gubun.equals("C")) depart="총무";
		else if(gubun.equals("j") || gubun.equals("J")) depart="재무";
		else if(gubun.equals("y") || gubun.equals("Y")) depart="영업";
		else depart="부서 없음";
		return depart;
	}
	
	String getRankName(String gubun) {
		String rank="";
		if(gubun.equals("10")) rank="사원";
		else if(gubun.equals("20")) rank="대리";
		else if(gubun.equals("30")) rank="과장";
		else rank="직위 없음";
		return rank;
	}
	
	int getSalary(String depart, String rank) {
		int salary=0;
		if(depart.equals("총무")) salary= 1000000;
		else if(depart.equals("재무")) salary= 900000;
		else if(depart.equals("영업")) salary=1200000;
		
		if(rank.equals("사원")) salary= salary+200000;
		else if(rank.equals("대리")) salary= salary+300000;
		else if(rank.equals("과장")) salary= salary+400000;
			
		if(depart.equals("부서 없음") || rank.equals("직위 없음")) salary=0;
		
		return salary;
	}
	
	void getPrint(J0202_dto[] arr) {
		for(int k=0; k<arr.length; k++) {
			System.out.println("사번: "+arr[k].getSabun());
			System.out.println("이름: "+arr[k].getName());
			System.out.println("부서: "+arr[k].getDepart());
			System.out.println("직급: "+arr[k].getRank());
			System.out.println("급여: "+arr[k].getSalary()+"원"+"\n");
		}
	}
	
	void searchData(J0202_dto[] arr, String search) {
		for(int k=0; k<arr.length; k++) {
			int name= arr[k].getName().indexOf(search);
			if(name != -1) {
				System.out.println("사번: "+arr[k].getSabun());
				System.out.println("이름: "+arr[k].getName());
				System.out.println("부서: "+arr[k].getDepart());
				System.out.println("직급: "+arr[k].getRank());
				System.out.println("급여: "+arr[k].getSalary()+"원"+"\n");
			}
		}
	}
	
	
}
