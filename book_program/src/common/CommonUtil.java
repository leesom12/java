package common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {
	 
	//오늘날짜. static 메소드이기 때문에 page import만 해주면, 클래스 생성없이도 CommonUtil.getToday()로 사용할 수 있다.
	public static String getToday(){
		Date time = new Date();
	    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	    String today = format1.format(time);
	    return today;
	}
	
	// 오늘 날짜 시분초 
    public static String getTodayTime(){
    	Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String today = format.format(time);
	    return today;
	}
	
}
