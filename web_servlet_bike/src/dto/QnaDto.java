package dto;

public class QnaDto {
	private String no, title, content, reply, reg_id, reg_name, reg_date, update_date, reply_date, state, reply_id, reply_name;
	private int hit;
	
	
	//질문 수정
	public QnaDto(String no, String title, String content, String update_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.update_date = update_date;
	}


	// 답변달기
	public QnaDto(String no, String reply, String reply_date, String state, String reply_id, String reply_name) {
		super();
		this.no = no;
		this.reply = reply;
		this.reply_date = reply_date;
		this.state = state;
		this.reply_id = reply_id;
		this.reply_name = reply_name;
	}
	
	
	//뷰
	public QnaDto(String no, String title, String content, String reply, String reg_id, String reg_name,
			String reg_date, String update_date, String reply_date, String state, String reply_id, String reply_name, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.reply = reply;
		this.reg_id = reg_id;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.update_date = update_date;
		this.reply_date = reply_date;
		this.state = state;
		this.reply_id = reply_id;
		this.reply_name = reply_name;
		this.hit = hit;
	}


	//전체 조회
	public QnaDto(String no, String title, String reg_name, String reg_date, String state, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.state = state;
		this.hit = hit;
	}
	

	//질문 등록
	public QnaDto(String no, String title, String content, String reg_id, String reg_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
	}
	

	public String getReply_name() {
		return reply_name;
	}
	public String getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getReply() {
		return reply;
	}
	public String getReg_id() {
		return reg_id;
	}
	public String getReg_name() {
		return reg_name;
	}
	public String getReg_date() {
		return reg_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public String getReply_date() {
		return reply_date;
	}
	public String getState() {
		return state;
	}
	public String getReply_id() {
		return reply_id;
	}
	public int getHit() {
		return hit;
	}
	
	
	
}
