package h_arraylist;

public class J0207_4_dao {
	
	String getDepart(String gubun) {
		String depart="";
		if(gubun.equals("10")) {
			depart="총무";
		} else if(gubun.equals("20")) {
			depart="재무";
		} else if(gubun.equals("30")) {
			depart="영업";
		} else depart="입력 오류";
		return depart;
	}
	
	String getRank(String gubun) {
		String rank="";
		if(gubun.equals("s")||gubun.equals("S")) {
			rank="사원";
		} else if(gubun.equals("d")||gubun.equals("D")) {
			rank="대리";
		} else if(gubun.equals("g")||gubun.equals("G")) {
			rank="과장";
		} else rank="입력 오류";
		return rank;
	}
	
	
}
