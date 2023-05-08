<%@page import="dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<MemberDto> arr= (ArrayList<MemberDto>)request.getAttribute("t_arr");
	String select= (String)request.getAttribute("t_select");
	String search= (String)request.getAttribute("t_search");
%>
<!DOCTYPE html>

<script type="text/javascript">
	function goSearch(){
		mem.method="post";
		mem.action="/web_servlet_basic/Member";
		mem.submit();
	}
	
	function goView(id){
		id_box.t_id.value=id;
		id_box.method="post";
		id_box.action="MemberView";
		id_box.submit();
	}
</script>

<form name="id_box">
	<input type="hidden" name="t_id">
</form>

<html> 
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--
	******************************************** 
		title : 풀스텍 홍길동
	******************************************** 
 -->	
	<title>TRACK11 홍길동</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">	
	<link href="/web_servlet_basic/css/common.css" rel="stylesheet">
	<link href="/web_servlet_basic/css/layout.css" rel="stylesheet" >	
</head>
<body>
	<div class="container">

		<div class="leftmargin">
			<img src="/web_servlet_basic/images/jsl_logo.png"><h1>TRACK11 홍길동 회원관리</h1>
		</div>		
		<div class="search_wrap">
			<div class="record_group">
				<p>총게시글 : <span><%=arr.size() %></span>건</p>
			</div>
			<form name="mem">
				<div class="search_group">
					<select name="t_select" class="select">
						<option value="id">ID</option>
						<option value="name" <%if(select.equals("name")) out.print("selected"); %>>성명</option>
					</select>
					<input type="text" name="t_search" class="search_word" value="<%=search%>">
					<button onclick="goSearch()" class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
				</div>
			</form>
		</div>
	</div>
	<div class="board_list">
		<table class="board_table">
			<colgroup>
				<col width="25%">
				<col width="25%">
				<col width="25%">
				<col width="25%">
			</colgroup>
			<thead>
				<tr>
					<th>ID</th>
					<th>성명</th>
					<th>나이</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody>
			<%for(MemberDto dto: arr) {%>
				<tr>
					<td><a href="MemberView?t_id=<%=dto.getId() %>"><%=dto.getId() %></a></td>
					<td><a href="javascript:goView('<%=dto.getId() %>')"><%=dto.getName() %></a></td>
					<td><%=dto.getAge() %></td>
					<td><%=dto.getReg_Date() %></td>
				</tr>	
			<%} %>
			</tbody>
		</table>
		<div class="paging">
<!--  		<a href="/web_servlet_basic/MemberWrite" class="write">회원등록</a> -->
			<a href="/web_servlet_basic/Member?t_gubun=writeForm" class="write">회원등록</a>
		</div>
	</div>
 </body>
</html>







    