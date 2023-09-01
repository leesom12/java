package track;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//지역별 관측 조회
	public ArrayList<Sub4Dto> getAreaAverage(){
		ArrayList<Sub4Dto> arr = new ArrayList<Sub4Dto>();
		String query="select to_char(to_date(t.test_date),'yyyy\"년\"MM\"월\"dd\"일\"') as test_date, c.city_code,\r\n" + 
					 "c.city_name, to_char(trunc(avg(t.test_value),0)) as avg,\r\n" + 
					 "case when trunc(avg(t.test_value),0) >150 then '매우나쁨'\r\n" + 
					 "     when trunc(avg(t.test_value),0) >=81 then '나쁨'\r\n" + 
					 "     when trunc(avg(t.test_value),0) >=31 then '보통'\r\n" + 
					 "     else '좋음'\r\n" + 
					 "end as stat\r\n" + 
					 "from tbl_test_202005 t, tbl_city_202005 c\r\n" + 
					 "where t.city_code= c.city_code \r\n" + 
					 "group by to_char(to_date(t.test_date),'yyyy\"년\"MM\"월\"dd\"일\"'), c.city_code, c.city_name\r\n" + 
					 "order by test_date, c.city_code";
		try {
			con= DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String test_date = rs.getNString("test_date");
				String city_name = rs.getNString("city_name");
				String avg = rs.getNString("avg");
				String stat = rs.getNString("stat");
				
				
				Sub4Dto dto = new Sub4Dto(test_date, city_name, avg, stat);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getAreaAverage: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	
	
	
	//측정이력조회
	public ArrayList<Sub3Dto> getTestList(){
		ArrayList<Sub3Dto> arr = new ArrayList<Sub3Dto>();
		String query="select to_char(to_date(t.test_date),'yyyy\"년\"MM\"월\"dd\"일\"') as test_date,\r\n" + 
				"decode(t.test_ampm,'AM','오전','오후') as test_ampm, t.pollution, c.city_code, c.city_name, a.area_name, t.test_value\r\n" + 
				"from tbl_city_202005 c, tbl_area_202005 a, tbl_test_202005 t\r\n" + 
				"where c.area_code = a.area_code and t.city_code= c.city_code\r\n" + 
				"order by test_date, test_ampm, city_code";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String test_date = rs.getNString("test_date");
				String test_ampm = rs.getNString("test_ampm");
				String pollution = rs.getNString("pollution");
				String city_code = rs.getNString("city_code");
				String city_name = rs.getNString("city_name");
				String area_name = rs.getNString("area_name");
				int test_value = rs.getInt("test_value");
				
				Sub3Dto dto = new Sub3Dto(test_date, test_ampm, pollution, city_code, city_name, area_name, test_value);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getTestList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}	
	
	
	
	//대기오염 측정등록
	public int saveTestValue(Sub2Dto dto) {
		int result = 0;
		String query="insert into tbl_test_202005 values ('"+dto.getTest_date()+"','"+dto.getTest_ampm()+"',"
				+ "'"+dto.getPollution()+"','"+dto.getCity_code()+"','"+dto.getTest_value()+"')";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveTestValue() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	
	
	//관측지점조회
	public ArrayList<Sub1Dto> getCityList(){
		ArrayList<Sub1Dto> arr = new ArrayList<Sub1Dto>();
		String query="select c.city_code, c.city_name, a.area_code, a.area_name,\r\n" + 
				"c.city_tel1||'-'||c.city_tel2||'-'||c.city_tel3 as city_tel,\r\n" + 
				"c.city_admin, decode(c.city_level,'1','사원','2','주임','3','대리','4','과장') as city_level\r\n" + 
				"from tbl_city_202005 c, tbl_area_202005 a\r\n" + 
				"where c.area_code = a.area_code\r\n" + 
				"order by c.city_code";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String city_code = rs.getNString("city_code");
				String city_name = rs.getNString("city_name");
				String area_code = rs.getNString("area_code");
				String area_name = rs.getNString("area_name");
				String city_tel = rs.getNString("city_tel");
				String city_admin = rs.getNString("city_admin");
				String city_level = rs.getNString("city_level");
				
				Sub1Dto dto = new Sub1Dto(city_code, city_name, area_code, area_name, city_tel, city_admin, city_level);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getCityList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
}
