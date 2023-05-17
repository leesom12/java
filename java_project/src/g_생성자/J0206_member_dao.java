package g_생성자;

public class J0206_member_dao {
	
	//(몸무게<= (키-100)*0.9) 정상
	
	String getResult(double height, double weight) {
		String result="비만";
		if(weight<=(height-100)*0.9) result="정상";
		return result;
	}
	
	void getPrint(J0206_member_dto[] arr) {
		System.out.println("--------------------------------------");
		System.out.println("아이디 "+"\t"+"성명"+"\t"+"키"+"\t"+"몸무게"+"\t"+"결과");
		System.out.println("--------------------------------------");
		for(int k=0; k<arr.length; k++) {
			System.out.print(arr[k].getId()+"\t");
			System.out.print(arr[k].getName()+"\t");
			System.out.print(arr[k].getHeight()+"\t");
			System.out.print(arr[k].getWeight()+"\t");
			System.out.print(arr[k].getResult()+"\n");
		}
	}
}
