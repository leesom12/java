<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@page import="dao.*, dto.*" %>
<%@ page import="common.*" %>
<%@ include file="../common_session.jsp"%>
<%
	if(!sessionLevel.equals("top")){
%>
		<script type="text/javascript">
			alert("관리자 화면입니다!");
			location.href="faq_list.jsp";
		</script>
<%
	}
	FaqDao dao= new FaqDao();
	request.setCharacterEncoding("UTF-8");
	String no= request.getParameter("t_no");
	FaqDto dto= dao.viewFaq(no);
%>
<script type="text/javascript">
	function goUpdateForm(){
		if(checkValue(faq.t_title,"제목을 입력하세요"))return;
		var titleLength= faq.t_title.value;
		if(titleLength.length > 50){
			alert("50자 이내의 제목으로 입력하세요");
			return;
		}
		if(checkValue(faq.t_content,"내용을 입력하세요"))return;
		faq.method="post";
		faq.action="db_faq_update.jsp";
		faq.submit();
	}
</script>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>자주하는 질문(FAQ)</h2>
	<%@ include file="../common_menu.jsp" %>
	</div>

	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">글쓰기</h2>
	  <form name="faq">
	  	<input name="t_no" value="<%=dto.getNo()%>" type="hidden">
	  	<input name="t_reg_date" value="<%=dto.getReg_date()%>" type="hidden">
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
			<table class="bord_table">
				<caption class="sr-only">자주하는 질문 입력 표</caption>
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="15%">
					<col width="35%">
				</colgroup>
				<tbody>
					
					<tr>
						<th>질문</th>
						<td colspan="3"><input type="text" name="t_title" value="<%=dto.getTitle()%>"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea name="t_content"><%=dto.getContent() %></textarea></td>
					</tr>
					<tr>
						<th>등록일</th>
						<td><%=dto.getReg_date() %></td>
						<th>수정일</th>
						<td><%=CommonUtil.getTodayTime() %></td>
					</tr>
					
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="submit" value="수정" class="btn_ok" onclick="goUpdateForm()">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기" class="btn_reset">&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onClick="location.href='faq_list.jsp';">
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









    