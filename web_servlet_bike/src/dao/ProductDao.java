package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.CommonUtil;
import common.DBConnection;
import dto.ProductDto;
import dto.ProductSaleDto;

public class ProductDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs= null;
	

	//주문 취소
	public int orderDelete(String no) {
		int result =0;
		String query="update BIKE_이소민_PRODUCT_SALE\r\n" + 
					 "set process_state = '주문취소'\r\n" + 
					 "where no = '"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("orderDelete() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	//배송상태 업데이트
	public int processUpdate(String no, String state, String delivery_date) {
		int result =0;
		String query="update BIKE_이소민_PRODUCT_SALE\r\n" + 
					 "set process_state = '"+state+"',\r\n" + 
					 "delivery_date =to_date('"+delivery_date+"','yyyy-MM-dd hh24:mi:ss')\r\n"+
					 "where no = '"+no+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("processUpdate() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	//판매내역 상세보기
	public ProductSaleDto viewSaleList(String no) {
		ProductSaleDto dto = null;
		String query="select s.no, s.product_no, p.p_name, s.member_id, m.name as member_name, s.address, m.mobile_1, m.mobile_2, m.mobile_3, s.payment, s.product_price,\r\n" + 
					 "to_char(s.product_price, '999,999,999') as strprice, p.attach, to_char(s.purchase_date, 'yyyy-MM-dd hh24:mi:ss') as purchase_date,\r\n" + 
					 "to_char(s.delivery_date, 'yyyy-MM-dd hh24:mi:ss') as delivery_date, s.process_state\r\n" + 
					 "from bike_이소민_product_sale s,\r\n" + 
					 "bike_이소민_member m,\r\n" + 
					 "bike_이소민_product p\r\n" + 
					 "where s.product_no = p.no\r\n" + 
					 "and s.member_id = m.id\r\n" + 
					 "and s.no='"+no+"'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String product_no = rs.getNString("product_no");
				String product_name = rs.getNString("p_name");
				String mem_id = rs.getNString("member_id");
				String mem_name = rs.getNString("member_name");
				String address = rs.getNString("address");
				String mo1 = rs.getNString("mobile_1");
				String mo2 = rs.getNString("mobile_2");
				String mo3 = rs.getNString("mobile_3");
				String mobile = mo1+"-"+mo2+"-"+mo3;
				String payment = rs.getNString("payment");
				int product_price = rs.getInt("product_price");
				String strPrice = rs.getNString("strprice");
				String attach = rs.getNString("attach");
				String purchase_date = rs.getNString("purchase_date");
				String process_state = rs.getNString("process_state");
				String delivery_date = rs.getNString("delivery_date");
				
				dto = new ProductSaleDto(no, product_no, product_name, mem_id, mem_name, address, mobile, payment, process_state, 
						purchase_date, strPrice, attach, delivery_date, product_price);
			
			}
		}catch(Exception e) {
			System.out.println("viewSaleList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	
	//주문 개수 불러오기
	public int getSaleTotalCount(String select, String search, String state) {
		int count=0;
		String query=" select count(*) as count \r\n" + 
					 " from bike_이소민_product_sale s \r\n" + 
					 " where "+select+" like '%"+search+"%'\r\n"
					 +"and s.process_state like '%"+state+"%'";
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
	
	//판매리스트
	public ArrayList<ProductSaleDto> getSaleList(String select, String search, String process, int start, int end){
		ArrayList<ProductSaleDto> arr = new ArrayList<ProductSaleDto>();
		String query="select * from\r\n" + 
					 "(select rownum as rnum, tbl.* from\r\n" + 
					 "(select s.no, s.product_no, p.p_name, s.member_id, m.name as member_name, s.address, s.payment, s.product_price,\r\n" + 
					 "to_char(s.product_price, '999,999,999') as strprice, to_char(s.purchase_date, 'yyyy-MM-dd') as purchase_date,\r\n" + 
					 "s.process_state\r\n" + 
					 "from bike_이소민_product_sale s,\r\n" + 
					 "bike_이소민_member m,\r\n" + 
					 "bike_이소민_product p\r\n" + 
					 "where s.product_no = p.no\r\n" + 
					 "and s.member_id = m.id\r\n" + 
					 "and "+select+" like '%"+search+"%'"
					 +"and s.process_state like '%"+process+"%'"
					 +"order by s.purchase_date desc"
					 + ")tbl) where rnum >="+start+" and rnum<="+end+"";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String product_no = rs.getString("product_no");
				String product_name = rs.getString("p_name");
				String mem_id = rs.getString("member_id");
				String mem_name = rs.getString("member_name");
				String address = rs.getString("address");
				String payment = rs.getString("payment");
				int product_price = rs.getInt("product_price");
				String strPrice = rs.getString("strPrice");
				String purchase_date = rs.getString("purchase_date");
				String process_state = rs.getString("process_state");
				
				ProductSaleDto dto = new ProductSaleDto(no, product_no, product_name, mem_id, mem_name, address, payment,
						process_state, purchase_date, strPrice, product_price);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getSaleList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	
	//고객용 주문 리스트
	public ArrayList<ProductSaleDto> getCustomerSale(String id, String process, int start, int end){
		ArrayList<ProductSaleDto> arr = new ArrayList<ProductSaleDto>();
		String query="select * from\r\n" + 
					 "(select rownum as rnum, tbl.* from\r\n" + 
					 "(select s.no, s.product_no, p.p_name, s.member_id, m.name as member_name, s.address, s.payment, s.product_price,\r\n" + 
					 "to_char(s.product_price, '999,999,999') as strprice, to_char(s.purchase_date, 'yyyy-MM-dd') as purchase_date,\r\n" + 
					 "s.process_state\r\n" + 
					 "from bike_이소민_product_sale s,\r\n" + 
					 "bike_이소민_member m,\r\n" + 
					 "bike_이소민_product p\r\n" + 
					 "where s.product_no = p.no\r\n" + 
					 "and s.member_id = m.id\r\n" + 
					 "and s.member_id = '"+id+"'\r\n" + 
					 "and s.process_state like '%"+process+"%'\r\n" + 
					 "order by s.purchase_date desc"+
					 ")tbl) where rnum >="+start+" and rnum<="+end+"";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				
				String no = rs.getString("no");
				String product_no = rs.getString("product_no");
				String product_name = rs.getString("p_name");
				String mem_id = rs.getString("member_id");
				String mem_name = rs.getString("member_name");
				String address = rs.getString("address");
				String payment = rs.getString("payment");
				int product_price = rs.getInt("product_price");
				String strPrice = rs.getString("strPrice");
				String purchase_date = rs.getString("purchase_date");
				String process_state = rs.getString("process_state");
				
				ProductSaleDto dto = new ProductSaleDto(no, product_no, product_name, mem_id, mem_name, address, payment,
						process_state, purchase_date, strPrice, product_price);
				arr.add(dto);
			}
				
		}catch(Exception e) {
			System.out.println("getCustomerSale() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//주문 등록
	public int saveProductSale(ProductSaleDto dto) {
		int result = 0;
		String query= "insert into bike_이소민_product_sale\r\n" + 
					  "(no, product_no, member_id, address, payment, process_state, purchase_date, product_price)\r\n" + 
					  "values\r\n" + 
					  "('"+dto.getNo()+"', '"+dto.getProduct_no()+"', '"+dto.getMem_id()+"', '"+dto.getAddress()+"', "
					  	+ "'"+dto.getPayment()+"', '"+dto.getProcess_state()+"', to_date('"+dto.getPurchase_date()+"', 'yyyy-MM-dd hh24:mi:ss'), "
					  	+ ""+dto.getProduct_price()+")";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("saveProductSale() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//주문 번호 생성
	public String getProductSaleNo() {
		String no ="";
		String todayDate = CommonUtil.getToday(); 
		todayDate = todayDate.replaceAll("-", "");
		todayDate = todayDate.substring(2);
		String query="select nvl(max(no), '0000') as no\r\n" + 
					 "from bike_이소민_product_sale\r\n" + 
					 "where no like '%"+todayDate+"%'";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String preNo = rs.getString("no");
				if(preNo.length() > 5) preNo = preNo.substring(6);
				int pre = Integer.parseInt(preNo);
				pre = pre+1;
				DecimalFormat df= new DecimalFormat("0000");
				no = todayDate+df.format(pre);
			}
		}catch(Exception e) {
			System.out.println("getProductSaleNo() 오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return no;
	}
	
	
	//인덱스 페이지에 뜨는 목록 조회
	public ArrayList<ProductDto> getIndexProductList(int start, int end){
		ArrayList<ProductDto> arr = new ArrayList<ProductDto>();
		String query="select * from\r\n" + 
					 "(select rownum as rnum, tbl.* from\r\n" + 
					 "(select\r\n" + 
					 "no, attach, p_name, to_char(price, '999,999,999') as strprice\r\n" + 
					 "from bike_이소민_product\r\n" + 
					 "order by p_level desc, reg_date desc)\r\n" + 
					 "tbl) where rnum >="+start+" and rnum <="+end+"";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String p_name = rs.getString("p_name");
				String attach = rs.getString("attach");
				String strPrice = rs.getString("strprice");
				ProductDto dto = new ProductDto(no, p_name, attach, strPrice);
				arr.add(dto);
			}
			if(arr.size() < 6) {
				for(int i=arr.size(); i<6; i++) {
					ProductDto dto = null;
					arr.add(dto);
				}
			}
		}catch(Exception e) {
			System.out.println("getIndexProductList() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//삭제
	public int deleteProduct(String no) {
		int result =0;
		String query="delete from bike_이소민_product\r\n" + 
					 "where no='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("deleteProduct() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//업데이트
	public int updateProduct(ProductDto dto) {
		int result = 0;
		String query="update bike_이소민_product\r\n" + 
					 "set p_name='"+dto.getP_name()+"', detail='"+dto.getDetail()+"', attach='"+dto.getAttach()+"', p_size='"+dto.getP_size()+"',\r\n" + 
					 "p_level='"+dto.getP_level()+"', price='"+dto.getPrice()+"', update_date=to_date('"+dto.getUpdate_date()+"', 'yyyy-MM-dd hh24:mi:ss')\r\n" + 
					 "where no='"+dto.getNo()+"'";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("updateProduct() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	//view-이전글
	public ProductDto getPreDto(String no) {
		ProductDto dto = null;
		String query="select a.no, b.p_name from\r\n" + 
					 "(select max(no) as no from bike_이소민_product\r\n" + 
					 "where no < '"+no+"') a,\r\n" + 
					 "bike_이소민_product b\r\n" + 
					 "where a.no = b.no";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String preNo = rs.getString("no");
				String preName = rs.getString("p_name");
				dto = new ProductDto(preNo, preName);
			}
		}catch(Exception e) {
			System.out.println("getPreDto() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	
	//view-다음글
	public ProductDto getNextDto(String no) {
		ProductDto dto = null;
		String query="select a.no, b.p_name from\r\n" + 
					 "(select min(no) as no from bike_이소민_product\r\n" + 
					 "where no > '"+no+"') a,\r\n" + 
					 "bike_이소민_product b\r\n" + 
					 "where a.no= b.no";
		try {
			con= DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String nextNo = rs.getString("no");
				String nextName = rs.getString("p_name");
				dto = new ProductDto(nextNo, nextName);
			}
		}catch(Exception e) {
			System.out.println("getNextDto() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	
	//조회수 업데이트
	public void updateHit(String no) {
		String query="update bike_이소민_product\r\n" + 
					 "set hit = hit+1\r\n" + 
					 "where no='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			int result= ps.executeUpdate();
			if(result != 1)System.out.println("updateHit() 오류:" +query);
		}catch(Exception e) {
			System.out.println("updateHit() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
	}
	
	
	//상세보기
	public ProductDto productView(String no) {
		ProductDto dto = null;
		String query="select p.no, p.p_name, p.detail, p.attach, p.p_size, p.p_level, p.price,\r\n" + 
					 "to_char(price, '999,999,999') as strPrice, p.hit, m.name as reg_name, \r\n" + 
					 "to_char(p.reg_date, 'yyyy-MM-dd hh24:mi:ss') as reg_date,\r\n" + 
					 "to_char(p.update_date, 'yyyy-MM-dd hh24:mi:ss') as update_date\r\n" + 
					 "from bike_이소민_product p, bike_이소민_member m\r\n" + 
					 "where p.reg_id=m.id\r\n" + 
					 "and no='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps= con.prepareStatement(query);
			rs= ps.executeQuery();
			if(rs.next()) {
				String p_name = rs.getString("p_name");
				String detail = rs.getString("detail");
				String attach = rs.getString("attach");
				String p_size = rs.getString("p_size");
				String p_level = rs.getString("p_level");
				String  strPrice = rs.getString("strPrice");
				int price = rs.getInt("price");
				int hit = rs.getInt("hit");
				String reg_name= rs.getString("reg_name");
				String reg_date = rs.getString("reg_date");
				String update_date = rs.getString("update_date");
				
				dto = new ProductDto(no, p_name, detail, attach, p_size, p_level, reg_name, reg_date, update_date, strPrice, hit, price);
				
			}
		}catch(Exception e) {
			System.out.println("productView() 오류: "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	
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
	
	
	//글 개수 불러오기
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














