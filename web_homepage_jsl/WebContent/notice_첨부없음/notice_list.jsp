<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@ include file="../common_session.jsp"%>
<%@page import="dao.*, dto.*, common.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	NoticeDao dao= new NoticeDao();
	
	String select= request.getParameter("t_select");
	String search= request.getParameter("t_search");
	if(select == null){
		select="n.title";
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
	
	
//	ArrayList<NoticeDto> arr = dao.noticeList(select, search);	
	ArrayList<NoticeDto> arr = dao.noticeListPage(select, search, start, end);
%>
	
<script type="text/javascript">
	function viewNotice(no){
		notice.t_no.value=no;
		notice.method="post";
		notice.action="notice_view.jsp";
		notice.submit();
	}
	
	function goSearch(){
		myform.method="post";
		myform.action="notice_list.jsp";
		myform.submit();
	}
	
	function goPage(pageNum){
		page.t_nowPage.value= pageNum;
		page.method="post";
		page.action="notice_list.jsp";
		page.submit();
	}
</script>
<form name="notice">
	<input type="hidden" name="t_no">
</form>
<form name="page">
	<input type="hidden" name="t_nowPage">
</form>
	<div class="sub_title">
		<h2>공지사항</h2>
		<%@ include file="../common_menu.jsp" %>
	</div>

	<div class="container">
	  <div class="search_wrap">
		<div class="record_group">
			<p>총게시글<span><%=totalCount%></span>건</p>
		</div>
		<div class="search_group">
			<form name="myform">
				<select name="t_setup">
					<option value="5" <%if(setup.equals("5")) out.print("selected"); %>>5개씩 출력</option>
					<option value="10" <%if(setup.equals("10")) out.print("selected"); %>>10개씩 출력</option>
					<option value="20" <%if(setup.equals("20")) out.print("selected"); %>>20개씩 출력</option>
				</select>
				<select name="t_select" class="select">
					<option value="n.title" <%if(select.equals("n.title")) out.print("selected"); %>>제목</option>
					<option value="n.content" <%if(select.equals("n.content")) out.print("selected"); %>>내용</option>
				</select>
				<input type="text" name="t_search" value="<%=search %>" class="search_word">
				<button class="btn_search" onclick="goSearch()"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</form>
		</div>
	  </div> <!-- search end -->
	  <div class="bord_list">
		<table class="bord_table" summary="이표는 번호,제목,글쓴이,날자,조회수로 구성되어 있습니다">
			<caption class="sr-only">공지사항 리스트</caption>
			<colgroup>
				<col width="10%">
				<col width="*">
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<%
					for(int k=0; k<arr.size(); k++) {
					//for(NoticeDto dto : arr){						//arr에 있는 만큼 반복돌면서 NoticeDto 타입으로 하나씩 빼서 dto라는 변수에 대입
				%>
					<tr>
						<td><a href="javascript:viewNotice('<%=arr.get(k).getNo()%>')"><%=totalCount-((current_page-1)*list_setup_count+k) %></a></td>
						<td class="title"><a href="javascript:viewNotice('<%=arr.get(k).getNo()%>')"><%=arr.get(k).getTitle() %></a></td>
						<td><%=arr.get(k).getReg_name() %></td>
						<td><%=arr.get(k).getReg_date() %></td>
						<td><%=arr.get(k).getHit() %></td>
					</tr>
				<%} %>
		</table>
		<div class="paging">
			<%
				String paging = CommonUtil.pageListPost(current_page, total_page, pageNumber_count);
				out.print(paging);
			%>	
<!--  
			<a href=""><i class="fa  fa-angle-double-left"></i></a>
			<a href=""><i class="fa fa-angle-left"></i></a>
			<a href="" class="active">1</a>
			<a href="">2</a>
			<a href="">3</a>
			<a href="">4</a>
			<a href="">5</a>
			<a href=""><i class="fa fa-angle-right"></i></a>
			<a href=""><i class="fa  fa-angle-double-right"></i></a>
-->
			<%
				if(sessionLevel.equals("top")){
			%>
				<a href="notice_write.jsp" class="btn_write">글쓰기</a>
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









    