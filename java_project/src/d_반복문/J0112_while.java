package d_반복문;

public class J0112_while {

	public static void main(String[] args) {
		
		for(int k=1; k<=5; k++) {
			
		}
		
		int j=1; // while 사용할 때 초기값은 바깥에, 조건은 소괄호 안에, 증감은 while문 안에
		while(j<=9) {
			System.out.println("2*"+j+" = "+2*j);
			j++;
		}

	}

}
