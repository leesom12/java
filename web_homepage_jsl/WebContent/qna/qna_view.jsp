<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@ include file="../common_session.jsp"%>
<%@page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	QnaDao dao= new QnaDao();
	String no= request.getParameter("t_no");
	dao.hitUpdate(no);
	QnaDto dto = dao.qnaView(no);
	QnaDto preDto = dao.preNo(no);
	QnaDto nextDto = dao.nextNo(no);
	String reg_date= dto.getReg_date().substring(0, 19);
	String update_date="";
	if(dto.getUpdate_date()!= null)update_date= dto.getUpdate_date().substring(0, 19);
	String a_date="";
	if(dto.getAnswer_reg_date()!= null)a_date= dto.getAnswer_reg_date().substring(0, 19);
	String a_update_date="";
	if(dto.getAnswer_update_date()!= null)a_update_date= dto.getAnswer_update_date().substring(0, 19);
%>
<script type="text/javascript">
	function goView(no){
		qna.t_no.value=no;
		qna.method="post";
		qna.action="qna_view.jsp";
		qna.submit();
	}
	
	function goUpdate(no){
		qna.t_no.value=no;
		qna.method="post";
		qna.action="qna_update.jsp";
		qna.submit();
	}
	
	function goDelete(no){
		qna.t_no.value=no;
		qna.method="post";
		qna.action="db_qna_delete.jsp";
		qna.submit();
	}
	
	function replyDelete(no){
		qna.t_no.value=no;
		qna.method="post";
		qna.action="db_reply_delete.jsp";
		qna.submit();
	}
</script>
<style type="text/css">
	.textarea{
		height:150%;
		background:#FBFBEF;
		outline: none;
		font-size:16px;
		resize: none;
	}
</style>
<form name="qna">
	<input name="t_no" type="hidden">
</form>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>질문답변</h2>
		<%@ include file="../common_menu.jsp" %>
	</div>

	<div class="container">
		<div class="board_view">
			<h2>[질문] <%=dto.getTitle() %></h2>
			<p class="info"><span class="user"><%=dto.getReg_name() %></span> | 등록일 <%=reg_date %> | 
			<%if(dto.getUpdate_date()!=null) out.print(" 최종수정일   "+ update_date+ " | ");%> <i class="fa fa-eye"></i> <%=dto.getHit() %> </p>
			
			<div class="board_body">
				<p style="font-weight:bold">질문</p>
				<textarea readonly class="textarea"><%=dto.getContent() %></textarea>
			
			<%if(dto.getAnswer_content()!=null){%>
				<span style="font-weight:bold">답변</span><span style="font-size:12px;">&nbsp;&nbsp;&nbsp;&nbsp; 등록일: <%=a_date %>
				<%if(dto.getAnswer_update_date()!=null) out.print("| 최종수정일   "+ a_update_date+ " | ");%></span>
				<textarea readonly class="textarea"><%=dto.getAnswer_content() %></textarea>
			<%} %>

<script type="text/javascript">
//<![CDATA[
$(document).ready(function(){
	$(".answerButt").toggle(function(){
		$(".answerArea").slideDown(500);	
	}, function(){
		$(".answerArea").slideUp(500);
	})
});
//]]>
</script>
<style>
	.answerArea{display:none} 
	.btn_3wrap span {
		padding: 12px 18px;
		display: inline-block;
		border: 1px solid #878787;
	}
	.answerArea .textArea_H120{
		padding:5px;
		width:700px;
		height:120px;
	}	
	.answerArea .saveButt{
		float:right;
		padding: 12px 18px;
		display: inline-block;
		border: 1px solid #878787;
	}	
</style>
				
			<!-- 답변 -->
			<form name="answer">
				<div class="answerArea">
					<input type="hidden" name="t_no" value="">
					<textarea name="t_answer" class="textArea_H120"></textarea>
					<a href="javascript:goAnswerSave()" class="saveButt">Answer Save</a>
				</div>
			</form>					
			</div>
			
			<div class="prev_next">
				<%if(preDto != null) {
					String preTitle= preDto.getTitle();
					if(preTitle.length() > 15) preTitle= preTitle.substring(0, 15)+"···.";
				%>
					<a href="javascript:goView('<%=preDto.getNo() %>')" class="btn_prev"><i class="fa fa-angle-left"></i>
					<span class="prev_wrap">
						<strong>이전글</strong><span><%=preTitle %></span>
					</span>
					</a>
				<%} %>
				<div class="btn_3wrap">
					<a href="qna_list.jsp">목록</a> 
					
					<%
					if(sessionId == null) sessionId ="";
					if(sessionId.equals(dto.getReg_id()) && dto.getAnswer_content()== null) {%> 
						<a href="javascript:goUpdate('<%=dto.getNo()%>')">수정</a> 
						<a href="javascript:goDelete('<%=dto.getNo()%>')" onClick="return confirm('삭제하시겠어요?')">삭제</a> 
					<%} else if(sessionLevel.equals("top")){%>
						<a href="javascript:goDelete('<%=dto.getNo()%>')" onClick="return confirm('삭제하시겠어요?')">게시글 삭제</a> 
					<%} %>
					<%if(sessionLevel.equals("top") && dto.getAnswer_content() == null) {%> 
						<a href="qna_reply.jsp?t_no=<%=no%>">답변등록</a>
					<%} %>
					<%if(sessionLevel.equals("top") && dto.getAnswer_content() != null) {%> 
						<a href="qna_reply_update.jsp?t_no=<%=no%>">답변수정</a>
						<a href="javascript:replyDelete('<%=dto.getNo()%>')" onClick="return confirm('삭제하시겠어요?')">답변삭제</a>
					<%} %>
					
				</div>
				
				<%if(nextDto != null) {
					String nextTitle= nextDto.getTitle();
					if(nextTitle.length() > 15) nextTitle= nextTitle.substring(0, 15)+"···.";
				%>
					<a href="javascript:goView('<%=nextDto.getNo() %>')" class="btn_next">
					<span class="next_wrap">
						<strong>다음글</strong><span><%=nextTitle %></span>
					</span>
					<i class="fa fa-angle-right"></i></a>
				<%} %>
			</div>
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
	

	<?php
		include "footer.html";
	?>
<%@ include file="../common_footer.jsp" %>
 </body>
</html>









