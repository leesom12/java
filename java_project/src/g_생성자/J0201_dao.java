package g_생성자;

public class J0201_dao {
	String getAreaName(String gubun){
		String area="";
		if(gubun.equals("S") || gubun.equals("s")) area="서울";
		else if(gubun.equals("D") || gubun.equals("d")) area="대전";
		else if(gubun.equals("C") || gubun.equals("c")) area="청주";
		else if(gubun.equals("B") || gubun.equals("b")) area="부산";
		else area="지역 없음";
		return area;
	}
	
	String getEduName(String gubun) {
		String edu="";
		if(gubun.equals("M") || gubun.equals("m")) edu="중졸";
		else if(gubun.equals("H") || gubun.equals("h")) edu="고졸";
		else if(gubun.equals("U") || gubun.equals("u")) edu="대졸";
		else edu="학력 없음";
		return edu;
	}
	
	void dtoPrint(J0201_dto[] arr) {
		for(int k=0; k<arr.length; k++) {
			System.out.print("name: "+arr[k].getName()+"\t");
			System.out.print("age: "+arr[k].getAge()+"\t");
			System.out.print("area: "+arr[k].getArea()+"\t");
			System.out.print("edu: "+arr[k].getEdu()+"\n");
		}
	}

}
