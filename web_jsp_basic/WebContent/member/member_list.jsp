<%@page import="java.util.ArrayList"%>
<%@page import="dto.*, dao.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDao dao= new MemberDao();
	String gubun= request.getParameter("t_gubun");
	String search= request.getParameter("t_search");
	if(gubun==null) {
		gubun="id";
		search="";
	}
	ArrayList<MemberDto> arr= dao.memberList(gubun,search);
%>
<!DOCTYPE html>
<html> 
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--
	******************************************** 
		title : 풀스텍 홍길동
	******************************************** 
 -->	
	<title>TRACK11 이소민</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">	
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	
	<script type="text/javascript">
		function goSearch(){
			mem.method="post";
			mem.action="member_list.jsp";
			mem.submit();
		}
	
		function goView(id){
			view.id.value=id;
			view.method="post";
			view.action="member_view.jsp";
			view.submit();
		}
		
	</script>
</head>
<form name="view">
	<input type="hidden" name="id">
</form>
<body>
	<div class="container">

		<div class="leftmargin">
			<a href="member_list.jsp"><img src="../images/jsl_logo.png"></a><h1>TRACK11 이소민 회원관리</h1>
		</div>		
		<div class="search_wrap">
			<div class="record_group">
				<p>총 회원수: <span><% out.print(arr.size());%></span>명</p>
			</div>
			
			<form name="mem">
			<div class="search_group">
				<select name="t_gubun" class="select">
					<option value="id" <%if(gubun.equals("id")){ %>selected<%} %> >ID</option>
					<option value="name" <%if(gubun.equals("name")){ %>selected<%} %> >성명</option>
				</select>
				<input name="t_search" value="<%= search %>" type="text" class="search_word">
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
				<%String id=""; %>
				<%  for(int j=0; j<arr.size(); j++) {%>
						<tr>
							<td><a href="member_view.jsp?id=<%=arr.get(j).getId()%>"><%out.print(arr.get(j).getId()); %></a></td>
							<td> <a href="javascript:goView('<%=arr.get(j).getId()%>')" ><%out.print(arr.get(j).getName()); %></a></td>
							<td><%out.print(arr.get(j).getAge()); %></td>
							<td><%out.print(arr.get(j).getReg_Date()); %></td>
						</tr>
				<% } %>				
			</tbody>
		</table>
		<div class="paging">
			<a href="member_write.jsp" class="write">회원등록</a>
		</div>
	</div>
 </body>
</html>

