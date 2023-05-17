package dto;

public class QnaDto {
	private String no, title, content, reg_id, reg_name, reg_date, update_date, attach, answer_content, answer_id, answer_reg_date, answer_update_date; 
	private int hit;
	
	
	//질문 등록
	public QnaDto(String no, String title, String content, String reg_id, String reg_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
	}
	
	//전체 조회
	public QnaDto(String no, String title, String answer_content, String reg_name, String reg_date,  int hit) {
		super();
		this.no = no;
		this.title = title;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.answer_content = answer_content;
		this.hit = hit;
	}
	
	//상세조회
	public QnaDto(String no, String title, String reg_id, String reg_name, String reg_date, String update_date, int hit, String content, String answer_content, 
			String answer_id, String answer_reg_date, String answer_update_date) {
		super();
		this.no = no;
		this.title = title;
		this.reg_id= reg_id;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.update_date = update_date;
		this.answer_content = answer_content;
		this.hit = hit;
		this.content = content;
		this.answer_id = answer_id;
		this.answer_reg_date = answer_reg_date;
		this.answer_update_date = answer_update_date;
	}
	
	//이전글, 다음글
	public QnaDto(String no, String title) {
		super();
		this.no = no;
		this.title = title;
	}
	
	//질문 수정
	public QnaDto(String no, String title, String content, String update_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.update_date = update_date;
	}
	
	
	//답변 등록, 수정
	public QnaDto(String no, String answer_id, String answer_content, String answer_reg_date, String answer_update_date,
			String attach) {
		super();
		this.no = no;
		this.answer_id = answer_id;
		this.answer_content = answer_content;
		this.answer_reg_date = answer_reg_date;
		this.answer_update_date = answer_update_date;
		this.attach = attach;
	}

	public String getReg_name() {
		return reg_name;
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
	public String getReg_id() {
		return reg_id;
	}
	public String getReg_date() {
		return reg_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public String getAttach() {
		return attach;
	}
	public String getAnswer_content() {
		return answer_content;
	}
	public String getAnswer_id() {
		return answer_id;
	}
	public String getAnswer_reg_date() {
		return answer_reg_date;
	}
	public String getAnswer_update_date() {
		return answer_update_date;
	}
	public int getHit() {
		return hit;
	}
	
	
}
