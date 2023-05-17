<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@ include file="../common_session.jsp" %>
<%@ page import="dto.*, dao.*, common.*" %>
<%
	PdsDao dao= new PdsDao();
	request.setCharacterEncoding("UTF-8");
	String no= request.getParameter("t_no");
	
	dao.hitUpdate(no);
	PdsDto dto= dao.viewPds(no);
	PdsDto preDto= dao.preNo(no);
	PdsDto nextDto = dao.nextNo(no);
	
	String attachName="";
	if(dto.getAttach() != null) attachName= dto.getAttach();
%>

<script type="text/javascript">
	function goView(no){
		pds.t_no.value=no;
		pds.method="post";
		pds.action="pds_view.jsp";
		pds.submit();
	}
	
	function goUpdate(){
		pds.method="post";
		pds.action="pds_update.jsp";
		pds.submit();
	}
	
	function goDelete(){
		pds.method="post";
		pds.action="db_pds_delete.jsp";
		pds.submit();		
	}
</script>

<style type="text/css">
	.container .content{
		width: 1050px;
		padding: 15px; 
		word-break: break-all;
		word-wrap: break-word;
	}
</style>

<form name="pds">
	<input name="t_no" type="hidden" value="<%=no%>">
	<input name="t_attach" type="hidden" value="<%=attachName%>">
</form>

	<div class="sub_title">
		<h2>자료실</h2>
		<%@ include file="../common_menu.jsp" %>
	</div>

	<div class="container">
		<div class="board_view">
			<h2>[자료실]<%=dto.getTitle() %></h2>
			<p class="info"><span class="user"><%=dto.getReg_name() %></span> | <%=dto.getReg_date() %> | 
			<%if(dto.getUpdate_date()!=null && sessionLevel.equals("top")) out.print(" 최종수정일   "+ dto.getUpdate_date()+ " | ");%> 
			<i class="fa fa-eye"></i> <%=dto.getHit() %></p>
			<div class="board_pds">
				<%if(dto.getAttach() != null) {%>
					첨부: <a href="../common/filedown.jsp?t_fileDir=pds&t_fileName=<%=dto.getAttach() %>"><%=dto.getAttach() %></a>
				<%} %>
			</div>
			<div class="board_body">
				<div class="content">
					<%=dto.getContent() %>
				</div>
			</div>
			<div class="prev_next">
				
				
				<%if(preDto != null) {
					String preTitle= preDto.getTitle();
					if(preTitle.length()>15) preTitle= preTitle.substring(0, 15);
				%>
					<a href="javascript:goView('<%=preDto.getNo() %>')" class="btn_prev"><i class="fa fa-angle-left"></i>
					<span class="prev_wrap">
						<strong>이전글</strong><span><%=preTitle %></span>
					</span>
					</a>
				<%} %>
				<div class="btn_3wrap">
					<a href="pds_list.jsp">목록</a> 
					<%if(sessionLevel.equals("top")) {%>
						<a href="javascript:goUpdate()">수정</a> 
						<a href="javascript:goDelete()" onClick="return confirm('삭제하시겠어요?')">삭제</a>
					<%} %>
				</div>
				
				<%if(nextDto != null) {
					String nextTitle= nextDto.getTitle();
					if(nextTitle.length()>15) nextTitle= nextTitle.substring(0, 15);
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
	

<%@ include file="../common_footer.jsp" %>

 </body>
</html>









