<%@page import="common.CommonUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@ include file="../common_session.jsp"%>
<%if(!sessionLevel.equals("top")){ %>
		<script type="text/javascript">
			alert("관리자 화면입니다!");
			location.href="/web_homepage_jsl/index.jsp";
		</script>
<%} %>
<%@page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	AdminDao dao = new AdminDao();
	
	String select= request.getParameter("t_select");
	String search= request.getParameter("t_search");
	if(select == null){
		select="id";
		search="";
	}
	
	/* paging 설정 start*/
	int totalCount = dao.getTotalCount(select,search);
	int list_setup_count = 5;  //한페이지당 출력 행수 
	int pageNumber_count = 3;  //한페이지당 출력 페이지 갯수
	
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
	
	ArrayList<AdminDto> arr= dao.getMemberList(select, search, start, end);
	
%>
	
<script type="text/javascript">
	function goMemberView(id){
		admin.t_id.value=id;
		admin.method="post";
		admin.action="adm_view.jsp";
		admin.submit();
	}
	
	function goPage(pageNum){
		page.t_nowPage.value= pageNum;
		page.method="post";
		page.action="adm_list.jsp";
		page.submit();
	}
</script>
<form name="admin">
	<input type="hidden" name="t_id">
</form>
<form name="page">
	<input type="hidden" name="t_nowPage">
</form>
	<div class="sub_title">
		<h2>관리자</h2>
	<%@ include file="../common_menu.jsp" %>
	</div>

	<div class="container">
	  <div class="search_wrap">
		<div class="record_group">
			<p>총 회원<span><%=totalCount %></span>명</p>
		</div>
		<div class="search_group">
			<form name="myform">
				<select name="t_select" class="select">
					<option value="id" <%if(select.equals("id"))out.print("selected"); %>>아이디</option>
					<option value="name" <%if(select.equals("name"))out.print("selected"); %>>성명</option>
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
				<col width="15%">
				<col width="15%">
				<col width="20%">
				<col width="20%">
				<col width="20%">
				<col width="10%">
			</colgroup>
			<thead>
				
				<tr>
					<th>아이디</th>
					<th>성명</th>
					<th>휴대폰 번호</th>
					<th>이메일</th>
					<th>회원가입일</th>
					<th>비고</th>
				</tr>
				
			</thead>
			<tbody>
				<%for(int k=0; k<arr.size(); k++) {%>
					<tr>
						<td><a href="javascript:goMemberView('<%=arr.get(k).getId() %>')"><%=arr.get(k).getId() %></a></td>
						<td style="text-align: center;"><a href="javascript:goMemberView('<%=arr.get(k).getId() %>')"><%=arr.get(k).getName() %></a></td>
						<td><%=arr.get(k).getMobile() %></td>
						<td><%=arr.get(k).getEmail() %></td>
						<td><%=arr.get(k).getReg_date() %></td>
						<td><%if(arr.get(k).getDelete().equals("N")) out.print("탈퇴"); %></td>
					</tr>
				<%} %>
		</table>
		<div class="paging">
			<%
				String paging= CommonUtil.pageListPost(current_page, total_page, pageNumber_count);
				out.print(paging);
			%>
		
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









    