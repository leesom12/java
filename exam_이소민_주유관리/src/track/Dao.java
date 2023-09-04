package track;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//일자별 매출통계
	public ArrayList<Sub3Dto> getDaySale(){
		ArrayList<Sub3Dto> arr = new ArrayList<Sub3Dto>();
		String query="select to_char(to_date(s.oildate),'yyyy\"년\"MM\"월\"dd\"일\"') as oildate, o.oilname, \r\n" + 
				 	 "count(s.oilcost)||'건' as count, to_char(sum(s.oilcost),'l999,999,999') as cost\r\n" + 
				 	 "from tbl_saleinfo_202010 s, tbl_oilinfo_202010 o\r\n" + 
				 	 "where s.oiltype=o.oiltype \r\n" + 
				 	 "group by to_char(to_date(s.oildate),'yyyy\"년\"MM\"월\"dd\"일\"'), o.oilname\r\n" + 
				 	 "order by oildate, o.oilname";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String oildate = rs.getNString("oildate");
				String oilname = rs.getNString("oilname");
				String count = rs.getNString("count");
				String cost = rs.getNString("cost");
				
				Sub3Dto dto = new Sub3Dto(oildate, oilname, count, cost);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getDaySale(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	
	//매출총액
	public String getTotalCost() {
		String total = "";
		String query="select to_char(sum(oilcost),'l999,999,999') as totalcost\r\n" + 
					 "from tbl_saleinfo_202010";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				total = rs.getNString("totalcost");
			}
		}catch(Exception e) {
			System.out.println("getTotalCost(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return total;
	}
	
	
	//전체매출조회
	public ArrayList<Sub2Dto> getSaleInfo(){
		ArrayList<Sub2Dto> arr = new ArrayList<Sub2Dto>();
		String query="select s.saleno, to_char(to_date(s.oildate),'yyyy\"년\"MM\"월\"dd\"일\"') as oildate, \r\n" + 
					 "o.oilname, s.amount, \r\n" + 
					 "decode(s.paytype,'1','현금','2','카드') as paytype, \r\n" + 
					 "case when c.custname is null then '비회원'\r\n" + 
					 "     else c.custname\r\n" + 
					 "end as custname,\r\n" + 
					 "case when c.custno is null then '비회원'\r\n" + 
					"     else c.custno\r\n" + 
					"end as custno,\r\n" + 
					"(case when c.custtel1 is null then '0000' else c.custtel1 end)||'-'||\r\n" + 
					"(case when c.custtel2 is null then '0000' else c.custtel2 end)||'-'||\r\n" + 
					"(case when c.custtel3 is null then '0000' else c.custtel3 end) as custtel,\r\n" + 
					"s.creditcart, \r\n" + 
					"to_char(s.oilcost,'l999,999,999') as oilcost\r\n" + 
					"from tbl_saleinfo_202010 s, tbl_oilinfo_202010 o, tbl_custinfo_202010 c\r\n" + 
					"where s.oiltype=o.oiltype and s.custno=c.custno(+)\r\n" + 
					"order by s.saleno";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String saleno = rs.getNString("saleno");
				String oildate = rs.getNString("oildate");
				String oilname = rs.getNString("oilname");
				String amount = rs.getNString("amount");
				String paytype = rs.getNString("paytype");
				String custname = rs.getNString("custname");
				String custno = rs.getNString("custno");
				String custtel = rs.getNString("custtel");
				String creditcart = rs.getNString("creditcart");
				if(creditcart==null) creditcart="";
				String oilcost = rs.getNString("oilcost");
				
				Sub2Dto dto = new Sub2Dto(saleno, oildate, oilname, amount, paytype, custname, custno, custtel, creditcart, oilcost);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getSaleInfo(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	
	//매출등록
	public int saveSaleInfo(Sub1Dto dto){
		int result = 0;
		String query="insert into tbl_saleinfo_202010 values "
						+ "('"+dto.getSaleno()+"','"+dto.getOildate()+"','"+dto.getOiltype()+"','"+dto.getAmount()+"',"
						+ "'"+dto.getPaytype()+"','"+dto.getCustno()+"','"+dto.getCreditcart()+"','"+dto.getOilcost()+"')";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveSaleInfo(): "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
}
