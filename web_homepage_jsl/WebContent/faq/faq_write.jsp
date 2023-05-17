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
%>
<script type="text/javascript">
	function goSave(){
		if(checkValue(faq.t_title,"제목을 입력하세요"))return;
		var titleLength= faq.t_title.value;
		if(titleLength.length > 50){
			alert("50자 이내의 제목으로 입력하세요");
			return;
		}
		if(checkValue(faq.t_content,"내용을 입력하세요"))return;
		
		faq.method="post";
		faq.action="db_faq_save.jsp";
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
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
			<table class="bord_table">
				<caption class="sr-only">자주하는 질문 입력 표</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					
					<tr>
						<th>질문</th>
						<td><input type="text" name="t_title"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="t_content"></textarea></td>
					</tr>
					
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="submit" style="cursor:pointer" value="저장" class="btn_ok" onclick="goSave()">&nbsp;&nbsp;
				<input type="reset" style="cursor:pointer" value="다시쓰기" class="btn_reset">&nbsp;&nbsp;
				<input type="button" style="cursor:pointer" value="목록" class="btn_list" onClick="location.href='faq_list.jsp';">
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









    