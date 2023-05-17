package g_생성자;

public class J0203_이소민_dao {

	int getAve(int kor, int eng, int mat) {
		return (kor+mat+eng)/3;
	}
	
	String getResult(int ave) {
		String result="불합격";
		if(ave>=80) result="합격";
		return result;
	}
	void getPrint(J0203_이소민_dto[] arr) {
		System.out.println("----------------------------------------------");
		System.out.println("성명 "+"\t"+"국어"+"\t"+"영어"+"\t"+"수학"+"\t"+"평균"+"\t"+"결과");
		System.out.println("----------------------------------------------");
		for(int k=0; k<arr.length; k++) {
			System.out.print(arr[k].getName()+"\t");
			System.out.print(arr[k].getKor()+"\t");
			System.out.print(arr[k].getEng()+"\t");
			System.out.print(arr[k].getMat()+"\t");
			System.out.print(arr[k].getAve()+"\t");
			System.out.print(arr[k].getResult()+"\n");
		}
	}
}
