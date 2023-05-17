<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@ include file="../common_session.jsp"%>
<%@page import="dao.*, dto.*" %>

<%
	request.setCharacterEncoding("UTF-8");
	QnaDao dao= new QnaDao();
	String no= request.getParameter("t_no");
	QnaDto dto= dao.qnaView(no);

	if(sessionId == null) sessionId ="";
	if(!sessionId.equals(dto.getReg_id())){ %>
		<script type="text/javascript">
			alert("작성자만 이용 가능한 화면입니다");
			location.href="/web_homepage_jsl/qna/qna_list.jsp";
		</script>
<%} else if(dto.getAnswer_content() != null){ %>
		<script type="text/javascript">
		alert("답변이 등록되어 수정/삭제할 수 없습니다");
		location.href="/web_homepage_jsl/qna/qna_list.jsp";
		</script>
<%} %>
	
<script type="text/javascript">
	function goSave(){
		if(checkValue(qna.t_title,"제목을 입력하세요"))return;
		if(checkValue(qna.t_content,"내용을 입력하세요"))return;
		qna.method="post";
		qna.action="db_qna_update.jsp";
		qna.submit();
	}
</script>

	<!-- sub contents -->
	<div class="sub_title">
	<h2>질문답변</h2>
	<%@ include file="../common_menu.jsp" %>
	</div>

	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">질문과 답변 글쓰기</h2>
	  <form name="qna">
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
			<input name="t_no" value="<%=dto.getNo() %>" type="hidden">
			<table class="bord_table">
				<caption class="sr-only">공지사항 입력 표</caption>
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="15%">
					<col width="35%">
				</colgroup>
				<tbody>
					<tr class="first">
						<th>제목</th>
						<td colspan="3"><input type="text" value="<%=dto.getTitle()%>" name="t_title" ></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea name="t_content"><%=dto.getContent() %></textarea></td>
					</tr>
					<tr>
						<th rowspan="2">작성자</th>
						<td rowspan="2"><%=dto.getReg_name() %></td>
						<th>등록일</th>
						<td><%=dto.getReg_date()%></td>
					</tr>
					<tr>
						<th>수정일</th>
						<td><%=CommonUtil.getTodayTime() %></td>
					</tr>
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="submit" onclick="goSave()" value="저장" class="btn_ok">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기" class="btn_reset">&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onClick="location.href='qna_list.jsp';">
			</div>
		</form>
	  </div>
	  
	</div>
	<!-- end contents -->
	
	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>
	

<%@ include file="../common_footer.jsp" %>

 </body>
</html>









