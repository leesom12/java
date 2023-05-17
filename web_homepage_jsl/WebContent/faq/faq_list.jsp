<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.*, dto.*" %>
<%@ page import="common.*" %>
<%@ include file="../common_session.jsp"%>
<%@ include file="../common_header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	FaqDao dao= new FaqDao();
	
	String select= request.getParameter("t_select");
	String search= request.getParameter("t_search");
	if(select == null){
		select="f.title";
		search="";
	}
	
	/* paging 설정 start*/
	int totalCount = dao.getTotalCount(select,search);
	int list_setup_count = 5;  //한페이지당 출력 행수 
	int pageNumber_count = 3;  //한페이지당 출력 페이지 갯수
	
	String setup= request.getParameter("t_setup");
	if(setup != null) list_setup_count= Integer.parseInt(setup);
	else if(setup == null) setup= "";
	
	String nowPage = request.getParameter("t_nowPage");
	int current_page = 0; // 현재페이지 번호
	int total_page = 0;    // 전체 페이지 수
	
	if(nowPage == null || nowPage.equals("")) current_page = 1; 
	else current_page = Integer.parseInt(nowPage);
	
	total_page = totalCount / list_setup_count;  // 몫 : 2
	int rest = 	totalCount % list_setup_count;   // 나머지:1
	if(rest !=0) total_page = total_page + 1;     // 3
	
	int start = (current_page -1) * list_setup_count + 1;
	int end   = current_page * list_setup_count;
	/* paging 설정 end*/	

	ArrayList<FaqDto> arr= dao.faqList(select, search, start, end);
%>
<script type="text/javascript">
	function goUpdate(no){
		faq.t_no.value=no;
		faq.method="post";
		faq.action="faq_update.jsp";
		faq.submit();
	}
	
	function goDelete(no){
		faq.t_no.value=no;
		faq.method="post";
		faq.action="db_faq_delete.jsp";
		faq.submit();
	}
	
	function goPage(pageNum){
		page.t_nowPage.value= pageNum;
		page.method="post";
		page.action="faq_list.jsp";
		page.submit();
	}
</script>
<form name="faq">
	<input type="hidden" name="t_no">
</form>
<form name="page">
	<input type="hidden" name="t_nowPage">
</form>
<style type="text/css">
	.btn-gradient {
	  margin: 10px;
	  border-radius: 10px;
	}
	.btn-mini {
	  padding: 7px 15px;  
	  font-size: 17px;
	}
	.content{
		width: 1050px;
		padding: 15px; 
		word-break: break-all;
		word-wrap: break-word;
	}
	.button{
		width:180px;
		align:center;
		margin:auto;
	}

</style>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>자주하는 질문(FAQ)</h2>
		<%@ include file="../common_menu.jsp" %>
	</div>

	<div class="container">
	  <div class="search_wrap">
		<div class="record_group">
			<p>총게시글<span><%=totalCount %></span>건</p>
		</div>
		<div class="search_group">
			<form name="myform" action="">
				<select name="t_setup">
					<option value="5" <%if(setup.equals("5")) out.print("selected"); %>>5개씩 출력</option>
					<option value="10" <%if(setup.equals("10")) out.print("selected"); %>>10개씩 출력</option>
					<option value="20" <%if(setup.equals("20")) out.print("selected"); %>>20개씩 출력</option>
				</select>
				<select name="t_select" class="select">
					<option value="f.title" <%if(select.equals("f.title")) out.print("selected"); %>>제목</option>
					<option value="f.content" <%if(select.equals("f.content")) out.print("selected"); %>>내용</option>
				</select>
				<input type="text" name="t_search" class="search_word" value="<%=search%>">
				<button class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</form>
		</div>
	  </div> <!-- search end -->
	  <div class="bord_list">
		
		<div class="faq-group">
		<table class="bord_table">
			<colgroup>
				<col width="10%">
				<col width="40%">
				<col width="13%">
				<col width="27%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th style="text-align:left;">작성일</th>
				</tr>
			</thead>
		</table>

			<%
				for(int k=0; k<arr.size(); k++) {
				//for(FaqDto dto : arr){
			%>
				<div class="accordion">
					<table class="table">
						<colgroup>
							<col width="10%">
							<col width="*">
							<col width="15%">
							<col width="18%">
						</colgroup>
						
						<%
							String title= arr.get(k).getTitle();
							if(title.length() > 40) title= title.substring(0, 40)+"···.";
						%>
						<tr>
							<td><%=totalCount-((current_page-1)*list_setup_count+k) %></td>
							<td><%=title %></td>
							<td style="text-align: center;"><%=arr.get(k).getReg_name() %></td>
							<td><%=arr.get(k).getReg_date() %></td>
						</tr>	
					</table>
				</div>
			
					<div class="panel">
						<div class="content">
							<span style="font-weight:bold;"><%if(title.length() > 40) {out.print(arr.get(k).getTitle());%><br/><br/><%} %></span>
							<%=arr.get(k).getContent() %>
						</div>
						<div style="font-size:12px; width:200px; float:right;">
							<%if(arr.get(k).getUpdate_date() != null && sessionLevel.equals("top")) { out.print("최종수정일: "+arr.get(k).getUpdate_date());} %></div>
						<div class="button">
							<%if(sessionLevel.equals("top")) {%>
								<a href="javascript:goUpdate('<%=arr.get(k).getNo() %>')" type="button" class="btn-gradient btn-mini" style=" background: #F5D0A9;">수정</a>
								<a href="javascript:goDelete('<%=arr.get(k).getNo() %>')" onClick="return confirm('삭제하시겠습니까?')" 
								   type="button" class="btn-gradient btn-mini" style=" background: #A9D0F5;">삭제</a>
							<%} %>
						</div>
						
					</div>
				
			<%} %>
			

				
		</div>

		<script>
			$(function() {
/*			
				$( '.accordion' ).click( function() {
				//$(".accordion").on("click",function() {	
					//$(".panel").slideUp();
					//$(this).next().slideToggle();
					//$(this).next().slideDown();
					$(".panel").not($(this).next().slideToggle()).slideUp();
					//$(this).next().slideDown();
					

				} );
		*/			
			
				$(".accordion").on("click",function() {
					$(".panel").not($(this).next().slideToggle()).slideUp();
					$(".accordion").not($(this)).removeClass("active");
					$(this).toggleClass("active");
				});
		
			});
		</script>

		<div class="paging">
		
			<%
				String paging= CommonUtil.pageListPost(current_page, total_page, pageNumber_count);
				out.print(paging);
				
			%>
		
			<%if(sessionLevel.equals("top")) {%>
				<a href="faq_write.jsp" class="btn_write">글쓰기</a>
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









    