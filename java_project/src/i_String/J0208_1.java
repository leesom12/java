package i_String;

public class J0208_1 {

	public static void main(String[] args) {
		String str="가나다라마바";
		int len= str.length();
		System.out.println(len);
		
		String a=str.substring(2);
		System.out.println(a);
		
		String b= str.substring(2,5);
		System.out.println(b);
		
		int position= str.indexOf("바");
		if(position != -1 && position+3 <= str.length()) {
			String c= str.substring(position,position+3);
			System.out.println(c);
		}
		
		if(len>3) {
			String d= str.substring(0, 3);
			System.out.println(d+"...");
		}

	}

}
