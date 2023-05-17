package g_생성자;

public class J0206_2_dao {
	double getAve(int kor, int eng, int mat) {
		double ave= (kor+ eng+ mat)/3.0;
		return ave;
	}
	
	String getResult(int kor, int eng, int mat) {
		String result="불합격";
		double ave= (kor+ eng+ mat)/3.0;
		if(kor>=60 && eng>=60 && mat>=60 && ave>=80) {
			result="합격";
		}
		return result;	
	}
	
	void getPrint(J0206_2_dto[] arr) {
		System.out.println("-----------------------------------------------------");
		System.out.println("아이디 "+"\t"+"성명"+"\t"+"국어"+"\t"+"영어"+"\t"+"수학"+"\t"+"평균"+"\t"+"결과");
		System.out.println("-----------------------------------------------------");
		for(int k=0; k<arr.length; k++) {
			System.out.print(arr[k].getId()+"\t");
			System.out.print(arr[k].getName()+"\t");
			System.out.print(arr[k].getKor()+"\t");
			System.out.print(arr[k].getEng()+"\t");
			System.out.print(arr[k].getMat()+"\t");
			System.out.print(Math.round(arr[k].getAve()*100)/100.0 +"\t");
			System.out.print(arr[k].getResult()+"\n");
		}
	}

}
