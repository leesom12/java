package h_arraylist;

public class J0207_3_dao {
	
	String getKind(String kind) {
		String kind2="";
		if(kind.equals("c")||kind.equals("C")) {
			kind2="고양이";
		} else if (kind.equals("d")|| kind.equals("D")) {
			kind2="강아지";
		} else kind2="입력 오류";
		return kind2;
	}
	
}
