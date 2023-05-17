<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@ include file="../common_session.jsp" %>
<%@page import="dao.*, dto.*" %>
<%
	NewsDao dao= new NewsDao();
	request.setCharacterEncoding("UTF-8");
	String no= request.getParameter("t_no");
	dao.hitUpdate(no);
	NewsDto dto= dao.newsView(no);
	NewsDto pre_dto= dao.preNo(no);
	NewsDto next_dto= dao.nextNo(no);
%>
<script type="text/javascript">
	function goView(no){
		news.t_no.value=no;
		news.method="post";
		news.action="news_view.jsp";
		news.submit();
	}
	
	function goUpdate(no){
		news.t_no.value=no;
		news.method="post";
		news.action="news_update.jsp";
		news.submit();
	}
	
	function goDelete(no){
		news.t_no.value=no;
		news.method="post";
		news.action="db_news_delete.jsp";
		news.submit();
	}
</script>
<form name="news">
	<input name="t_no" type="hidden">
</form>
	<div class="sub_title">
		<h2>뉴스</h2>
		<%@ include file="../common_menu.jsp" %>
	</div>

	<div class="container">
		<div class="board_view">
			<h2>[뉴스]<%=dto.getTitle() %></h2>
			<p class="info"><span class="user"><%=dto.getReg_name() %></span> | <%=dto.getReg_date() %> | 
			<%if(dto.getUpdate_date()!=null && sessionLevel.equals("top")) out.print(" 최종수정일   "+ dto.getUpdate_date()+ " | ");%> <i class="fa fa-eye"></i> <%=dto.getHit() %> </p>
			<div class="board_body">
				<textarea readonly><%=dto.getContent() %></textarea>
			</div>
				
			<div class="prev_next">
				<%if(pre_dto != null) {
					String preTitle= pre_dto.getTitle();
					if(preTitle.length()>15) preTitle= preTitle.substring(0, 15);
				%>
					<a href="javascript:goView('<%=pre_dto.getNo() %>')" class="btn_prev"><i class="fa fa-angle-left"></i>
					<span class="prev_wrap">
						<strong>이전글</strong><span><%=preTitle %></span>
					</span>
					</a>
				<%} %>
				
				<div class="btn_3wrap">
					<a href="news_list.jsp">목록</a> 
					<%if(sessionLevel.equals("top")) {%>	
						<a href="javascript:goUpdate('<%=no%>')">수정</a> 
						<a href="javascript:goDelete('<%=no%>')" onClick="return confirm('삭제하시겠습니까?')">삭제</a>
					<%} %>
				</div>
				<%if(next_dto != null) {
					String nextTitle= next_dto.getTitle();
					if(nextTitle.length()>15) nextTitle= nextTitle.substring(0, 15);
				%>
					<a href="javascript:goView('<%=next_dto.getNo() %>')" class="btn_next">
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









    