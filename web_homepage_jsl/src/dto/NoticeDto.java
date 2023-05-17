package dto;

public class NoticeDto {
	private String no, title, content, attach, reg_id, reg_name, reg_date;
	private int hit;
	
	//notice_view
	public NoticeDto(String no, String title, String content, String attach, String reg_name, String reg_date, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.attach = attach;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.hit = hit;
	}
	
	//db_notice_save
	public NoticeDto(String no, String title, String content, String attach, String reg_id, String reg_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.attach = attach;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
	}

	//notice_list
	public NoticeDto(String no, String title, String attach, String reg_name, String reg_date, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.attach = attach;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.hit = hit;
	}

	//이전글, 다음글
	public NoticeDto(String no, String title) {
		super();
		this.no = no;
		this.title = title;
	}
	
	//수정 (db_notice_update)
	public NoticeDto(String no, String title, String content, String attach) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.attach = attach;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}

	public void setReg_name(String reg_name) {
		this.reg_name = reg_name;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public void setHit(int hit) {
		this.hit = hit;
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
	public String getAttach() {
		return attach;
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
	public int getHit() {
		return hit;
	}
	
}