package dto;

public class ProductSaleDto {
	private String no, product_no, product_name, mem_id, mem_name, address, mobile, payment, process_state, purchase_date, strPrice, attach,
			delivery_date, saleTrend_date, price_sum;
	private int product_price, sale_count;
	
	
	//판매현황
	public ProductSaleDto(String saleTrend_date, String price_sum, int sale_count) {
		super();
		this.saleTrend_date = saleTrend_date;
		this.price_sum = price_sum;
		this.sale_count = sale_count;
	}

	
	
	//상세보기
	public ProductSaleDto(String no, String product_no, String product_name, String mem_id, String mem_name,
			String address, String mobile, String payment, String process_state, String purchase_date, String strPrice, String attach, 
			String delivery_date, int product_price) {
		super();
		this.no = no;
		this.product_no = product_no;
		this.product_name = product_name;
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.address = address;
		this.mobile = mobile;
		this.payment = payment;
		this.process_state = process_state;
		this.purchase_date = purchase_date;
		this.strPrice = strPrice;
		this.attach = attach;
		this.delivery_date = delivery_date;
		this.product_price = product_price;
	}
	
	

	//조회
	public ProductSaleDto(String no, String product_no, String product_name, String mem_id, String mem_name, String address,
			String payment, String process_state, String purchase_date, String strPrice, int product_price) {
		super();
		this.no = no;
		this.product_no = product_no;
		this.product_name = product_name;
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.address = address;
		this.payment = payment;
		this.process_state = process_state;
		this.purchase_date = purchase_date;
		this.strPrice = strPrice;
		this.product_price = product_price;
	}


	//등록
	public ProductSaleDto(String no, String product_no, String mem_id, String address, String payment,
			String process_state, String purchase_date, int product_price) {
		super();
		this.no = no;
		this.product_no = product_no;
		this.mem_id = mem_id;
		this.address = address;
		this.payment = payment;
		this.process_state = process_state;
		this.purchase_date = purchase_date;
		this.product_price = product_price;
	}
	
	
	
	public int getSale_count() {
		return sale_count;
	}
	public String getSaleTrend_date() {
		return saleTrend_date;
	}
	public String getPrice_sum() {
		return price_sum;
	}
	public String getDelivery_date() {
		return delivery_date;
	}
	public String getAttach() {
		return attach;
	}
	public String getMobile() {
		return mobile;
	}
	public String getStrPrice() {
		return strPrice;
	}
	public String getMem_name() {
		return mem_name;
	}
	public String getProduct_name() {
		return product_name;
	}
	public String getNo() {
		return no;
	}
	public String getProduct_no() {
		return product_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public String getAddress() {
		return address;
	}
	public String getPayment() {
		return payment;
	}
	public String getProcess_state() {
		return process_state;
	}
	public String getPurchase_date() {
		return purchase_date;
	}
	public int getProduct_price() {
		return product_price;
	}
	
	
}
