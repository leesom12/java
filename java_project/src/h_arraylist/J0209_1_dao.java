package h_arraylist;

import java.util.ArrayList;

public class J0209_1_dao {
	
	String getGender(String gubun) {
		String gender="";
		if(gubun.equals("m") || gubun.equals("M")) {
			gender="남자";
		} else if(gubun.equals("f") || gubun.equals("F")) {
			gender="여자";
		} else gender="입력오류";
		return gender;
	}
	
	int getMoney(String gender, int age) {
		int basic= 1000000;
		
		if(gender.equals("m") || gender.equals("M")) {
			basic= basic+ 200000;
		} else if(gender.equals("f") || gender.equals("F")) {
			basic= basic+ 300000;
		} else basic=0;
		
		if(age>=25) {
			basic= basic+100000;
		}
		return basic;
	}
	
	void setPrint(ArrayList<J0209_1_dto> arr) {
		System.out.println("-------------------------------------");
		System.out.println("성명"+"\t"+"성별"+"\t"+"나이"+"\t"+"급여");
		System.out.println("-------------------------------------");
		
		for(int k=0; k<arr.size(); k++) {
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getGender()+"\t");
			System.out.print(arr.get(k).getAge()+"\t");
			System.out.print(arr.get(k).getMoney()+"\n");
		}
	}
}
