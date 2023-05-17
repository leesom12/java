package e_배열;

public class J0118_1 {

	public static void main(String[] args) {
		String[]aa= {"홍길동", "대전", "25"};
		String[][] str= {{"홍길동", "대전", "25"},
						 {"이상화", "서울", "30"}};
		
		int[][] score= {{10, 20, 30, 40, 50},
						{100, 200, 300, 400, 500}};
		
		int total=0;
		for(int k=0; k<score.length; k++) {
			int sum=0;
			for(int j=0; j<score[k].length; j++) {
				System.out.print(score[k][j]+"\t");
				sum=sum+score[k][j];
				total=total+score[k][j];
			}
			System.out.print("합: "+sum);
			System.out.print("\n");
		}
		System.out.println("\n"+"전체 합계: "+total);
	}

}
