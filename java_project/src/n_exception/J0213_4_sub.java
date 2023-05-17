package n_exception;

public class J0213_4_sub {
	
	int getTotal(String kor, String eng) {
		int total=0;
		try {
			total=Integer.parseInt(kor)+Integer.parseInt(eng);
		}catch(Exception e) {
			System.out.println("total 오류!!");
		}
		return total;
	}

	public int getAve(int total, String count) throws Exception {
		int ave=0;
		try {
			ave= total/Integer.parseInt(count);
		} catch(Exception e) {
			System.out.println("ave 오류!!");
		}
		return ave;
	}
}
