package g_생성자;

public class J0203_dao {
	
	String getGenderName(String gubun) {
		String gender="";
		if(gubun.equals("F")||gubun.equals("f")) {
			gender="여";
		} else if(gubun.equals("M")||gubun.equals("m")) {
			gender="남";
		} else gender="성별 입력 오류";
		return gender;
	}
	
	int getMoney(String gender, int age) {
		int money=0;
		if(gender.equals("여") || gender.equals("남")) {
			if(gender.equals("여")) { 
				money=120000;
				if(age<=20) {
					money= money+30000;
				} else if(age<=25) {
					money= money+50000;
				} else money= money+100000;
			}else if(gender.equals("남")) {
				money=100000;
				if(age<=20) {
					money= money+30000;
				} else if(age<=25) {
					money= money+50000;
				} else money= money+100000;
			}
		} else money=0;		
		return money;
	}
	
	void getPrint(J0203_dto[]arr ) {
		for(int k=0; k<arr.length; k++) {
			System.out.println("name: "+arr[k].getName());
			System.out.println("gender: "+arr[k].getGender());
			System.out.println("age: "+arr[k].getAge());
			System.out.println("money: "+arr[k].getMoney()+"\n");
		}
	}

}
