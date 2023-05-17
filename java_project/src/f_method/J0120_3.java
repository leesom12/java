package f_method;

public class J0120_3 {

	public static void main(String[] args) {
		J0120_3_sub sub=new J0120_3_sub();
		
		int[] score= {10,20,30,40,50};
		int total=sub.getTotal(score);
		System.out.println("total: "+total);
		
		int ave=sub.getAve(score, 5);
		System.out.println("ave: "+ave);
		
		int ave_2=sub.getAve(score);
		System.out.println("ave_2: "+ave_2);

	}

}
