<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@ include file="../common_session.jsp" %>
<%@ page import="dto.*, dao.*, common.*" %>
<%
	PdsDao dao= new PdsDao();
	String select=request.getParameter("t_select");
	String search=request.getParameter("t_search");
	if(select == null){
		select="p.title";
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
	
	ArrayList<PdsDto> arr= dao.pdsList(select, search, start, end);
%>

<script type="text/javascript">
	function goSearch(){
		myform.method="post";
		myform.action="pds_list.jsp";
		myform.submit();
	}
	
	function goView(no){
		pds.t_no.value= no;
		pds.method="post";
		pds.action="pds_view.jsp";
		pds.submit();		
	}
	
	function goPage(pageNum){
		page.t_nowPage.value= pageNum;
		page.method="post";
		page.action="pds_list.jsp";
		page.submit();
	}
</script>

<form name="pds">
	<input name="t_no" type="hidden">
</form>
<form name="page">
	<input type="hidden" name="t_nowPage">
</form>

	<!-- sub contents -->
	<div class="sub_title">
		<h2>자료실</h2>
		<%@include file="../common_menu.jsp" %>
	</div>

	<div class="container">
	  <div class="search_wrap">
		<div class="record_group">
			<p>총게시글<span><%=arr.size() %></span>건</p>
		</div>
		<div class="search_group">
			<form name="myform">
				<select name="t_select" class="select">
					<option value="p.title" <%if(select.equals("p.title")) out.print("selected"); %>>제목</option>
					<option value="p.content" <%if(select.equals("p.content")) out.print("selected"); %>>내용</option>
				</select>
				<input type="text" name="t_search" class="search_word" value="<%=search%>">
				<button class="btn_search" onClick="goSave()" type="submit"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</form>
		</div>
	  </div> <!-- search end -->
	  <div class="bord_list">
		<table class="bord_table" summary="이표는 번호,제목,글쓴이,날자,조회수로 구성되어 있습니다">
			<caption class="sr-only">공지사항 리스트</caption>
			<colgroup>
				<col width="10%">
				<col width="*">
				<col width="5%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>첨부</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<%for(PdsDto dto : arr) {%>
					<tr>
						<td><a href="javascript:goView('<%=dto.getNo() %>')"><%=dto.getNo() %></a></td>
						<td class="title"><a href="javascript:goView('<%=dto.getNo() %>')"><%=dto.getTitle() %></a></td>
						<td>
						<%if(dto.getAttach() != null) {%>
							<a href="../common/filedown.jsp?t_fileDir=pds&t_fileName=<%=dto.getAttach() %>"><img src="../images/file.png"></a>
						<%} %>
						</td>
						<td><%=dto.getReg_name() %></td>
						<td><%=dto.getReg_date() %></td>
						<td><%=dto.getHit() %></td>
					</tr>
				<%} %>
			</tbody>
		</table>
		<div class="paging">
			<%
				String paging = CommonUtil.pageListPost(current_page, total_page, pageNumber_count);
				out.print(paging);
			%>	
			
			<%if(sessionLevel.equals("top")) {%>
				<a href="pds_write.jsp" class="btn_write">글쓰기</a>
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









