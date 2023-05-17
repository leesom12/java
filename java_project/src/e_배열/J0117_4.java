package e_배열;

public class J0117_4 {

	public static void main(String[] args) {
		String[]str= {"홍길동", "50", "60", "70", "80", "90"};
	
		
		int total=0;
		for(int k=1; k<str.length; k++) {
			total=total+Integer.parseInt(str[k]);
		}
		
		System.out.println(str[0]+"\t"+"총점: "+total);	
		System.out.println("-------------------------------");
	
		total=0;
		String[]score=new String[str.length+1];
		for(int k=0; k<str.length; k++) {
			score[k]=str[k];
			if(k>0) {
				total=total+Integer.parseInt(score[k]);
			}
		}
		score[str.length]="총점: "+Integer.toString(total);
		
		for(int k=0; k<score.length; k++) {
			System.out.print(score[k]+"\t");
		}
		
		
	}

}
