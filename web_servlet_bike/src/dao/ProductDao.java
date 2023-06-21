package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.ProductDto;

public class ProductDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs= null;
	
	//전체조회
	public ArrayList<ProductDto> getProductList(String select, String search, int start, int end){
		ArrayList<ProductDto> arr= new ArrayList<ProductDto>();
		String query="select * from\r\n" + 
					 "    (select rownum as rnum, tbl.* from\r\n" + 
					 "        (select no, p_name, to_char(price, '999,999,999') as price, hit, attach, to_char(reg_date, 'yyyy-MM-dd') as reg_date \r\n" + 
					 "        from bike_이소민_product\r\n" + 
					 "        where "+select+" like '%"+search+"%'\r\n" + 
					 "        order by p_level desc, reg_date desc\r\n" + 
					 "    )tbl\r\n" + 
					 ")where rnum>="+start+" and rnum<="+end+"";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String p_name = rs.getString("p_name");
				String price = rs.getString("price");
				int hit = rs.getInt("hit");
				String attach = rs.getString("attach");
				String reg_date = rs.getString("reg_date");
				ProductDto dto = new ProductDto(no, p_name, price, attach, hit, reg_date);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getProductList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//개수 불러오기
	public int getTotalCount(String select, String search) {
		int count=0;
		String query=" select count(*) as count \r\n" + 
					 " from bike_이소민_product n \r\n" + 
					 " where "+select+" like '%"+search+"%'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) count= rs.getInt("count");
		}catch(Exception e) {
			System.out.println("getTotalCount() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}
	
	//등록
	public int saveProduct(ProductDto dto) {
		int result = 0;
		String query="insert into bike_이소민_product\r\n" + 
					 "(no, p_name, detail, attach, p_size, price, p_level, reg_id, reg_date)\r\n" + 
					 "values\r\n" + 
					 "('"+dto.getNo()+"', '"+dto.getP_name()+"', '"+dto.getDetail()+"', '"+dto.getAttach()+"', '"+dto.getP_size()+"', '"+dto.getPrice()+"', \r\n" + 
					 " '"+dto.getP_level()+"', '"+dto.getReg_id()+"', to_date('"+dto.getReg_date()+"', 'yyyy-MM-dd hh24:mi:ss'))";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveProduct() 오류:"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//상품 번호 생성
	public String getProductNum() {
		String no="";
		String query="select nvl(max(no),'0000') as no from bike_이소민_product";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				no = rs.getString("no");
				int no1= Integer.parseInt(no);
				no1= no1+1;
				DecimalFormat df= new DecimalFormat("0000");
				no=df.format(no1);
			}
		}catch(Exception e) {
			System.out.println("getProductNum() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return no;
	}
}













