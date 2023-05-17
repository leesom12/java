<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@ include file="../common_session.jsp" %>
<%@page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	NoticeDao dao = new NoticeDao();
	
	String no= request.getParameter("t_no");
	dao.hitUpdate(no);
	NoticeDto dto= dao.noticeView(no);
	
	NoticeDto dto1= dao.preView(no);
	NoticeDto dto2= dao.nextView(no);
%>
<script type="text/javascript">
	function goView(no){
		notice.t_no.value=no;
		notice.method="post";
		notice.action="notice_view.jsp";
		notice.submit();
	}
	
	function goUpdate(no){
		notice.t_no.value=no;
		notice.method="post";
		notice.action="notice_update.jsp";
		notice.submit();
	}
	
	function goDelete(no){
		notice.t_no.value=no;
		notice.method="post";
		notice.action="db_notice_delete.jsp";
		notice.submit();
	}
</script>
<form name="notice">
	<input name="t_no" type="hidden">
</form>
	<div class="sub_title">
		<h2>공지사항</h2>
		<%@ include file="../common_menu.jsp" %>
	</div>

	<div class="container">
		<div class="board_view">
			<h2>[공지] <%=dto.getTitle() %></h2>
			<p class="info"><span class="user"><%=dto.getReg_name() %></span> | <%=dto.getReg_date() %> | <i class="fa fa-eye"></i> <%=dto.getHit() %></p>
			<div class="board_body">
				<pre><%=dto.getContent() %></pre>
				
			</div>
			<%if(dto.getAttach() != null) {%>
				<p>첨부파일: <a href=""><%=dto.getAttach() %></a> </p>
			<%} %>
			<div class="prev_next">
				<%if(dto1 != null) {
					String preTitle= dto1.getTitle();
					if(preTitle.length()>15) preTitle= preTitle.substring(0, 15)+"...";
				%>
					<a href="javascript:goView('<%=dto1.getNo() %>')" class="btn_prev"><i class="fa fa-angle-left"></i>
					<span class="prev_wrap">
						<strong>이전글</strong><span><%=preTitle %></span>
					</span>
					</a>
				<%} %>
				<div class="btn_3wrap">
					<a href="notice_list.jsp">목록</a> 
					<%if(sessionLevel.equals("top")) {%>
						<a href="javascript:goUpdate('<%=dto.getNo() %>')">수정</a> 
						<a href="javascript:goDelete('<%=dto.getNo() %>')" onClick="return confirm('삭제하시겠습니까?')">삭제</a>
					<%} %>
				</div>
				<%if(dto2 != null) {
					String nextTitle= dto2.getTitle();
					if(nextTitle.length()>15) nextTitle= nextTitle.substring(0, 15)+"...";
				%>
					<a href="javascript:goView('<%=dto2.getNo() %>')" class="btn_next">
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
	

<%@ include file="../common_footer.jsp" %>
 </body>
</html>









    