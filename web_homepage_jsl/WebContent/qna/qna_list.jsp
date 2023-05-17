<%@page import="common.CommonUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@ include file="../common_session.jsp"%>
<%@page import="dao.*, dto.*" %>	
<%
	request.setCharacterEncoding("UTF-8");
	QnaDao dao= new QnaDao();
	String select= request.getParameter("t_select");
	String search= request.getParameter("t_search");
	if(select == null){
		select="q.title";
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

	ArrayList<QnaDto> arr= dao.qnaList(select, search, start, end);
%>
<script type="text/javascript">
	function goView(no){
		qna.t_no.value=no;
		qna.method="post";
		qna.action="qna_view.jsp";
		qna.submit();
	}
	
	function goPage(pageNum){
		page.t_nowPage.value= pageNum;
		page.method="post";
		page.action="qna_list.jsp";
		page.submit();
	}
</script>
<form name="qna">
	<input name="t_no" type="hidden">
</form>
<form name="page">
	<input type="hidden" name="t_nowPage">
</form>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>질문과답변</h2>
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
					<option value="q.title" <%if(select.equals("q.title")) out.print("selected"); %>>제목</option>
					<option value="q.content" <%if(select.equals("q.content")) out.print("selected"); %>>내용</option>
				</select>
				<input type="text" name="t_search" class="search_word" value="<%=search%>">
				<button class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</form>
		</div>
	  </div> <!-- search end -->
	  <div class="bord_list">
		<table class="bord_table" summary="이표는 번호,제목,답변상태, 작성자, 작성일, 조회수로 구성되어 있습니다">
			<caption class="sr-only">질문과 답변 리스트</caption>
			<colgroup>
				<col width="10%">
				<col width="*">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>답변상태</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				
				<%
					for(int k=0; k<arr.size(); k++) {
					
				%>
					<tr>
						<td><a href="javascript:goView('<%=arr.get(k).getNo() %>')"><%=totalCount-((current_page-1)*list_setup_count+k) %></a></td>
						<%
							String title= arr.get(k).getTitle();
							if(arr.get(k).getTitle().length()>40) title= arr.get(k).getTitle().substring(0, 40)+"···.";
						%>
						<td class="title"><a href="javascript:goView('<%=arr.get(k).getNo() %>')"><%=title %></a></td>
						<% if(arr.get(k).getAnswer_content() == null) {%><td><span class="waiting">답변대기</span></td><%} %>
						<% if(arr.get(k).getAnswer_content() != null) { %><td><span  class="complet">답변완료</span></td><%} %>
						<td><%=arr.get(k).getReg_name() %></td>
						<td><%=arr.get(k).getReg_date() %></td>
						<td><%=arr.get(k).getHit() %></td>
					</tr>
				<%} %>
				
			</tbody>
		</table>
		<div class="paging">
			<%
				String paging= CommonUtil.pageListPost(current_page, total_page, pageNumber_count);
				out.print(paging);
				
			%>
			<%if(sessionLevel.equals("member") || sessionLevel.equals("top")) {%>
				<a href="qna_write.jsp" class="btn_write">글쓰기</a>
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








