<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*, dao.*" %>
<%
	InjectionDao dao = new InjectionDao();
	ArrayList<InjectionDto> arr = dao.getInjectionCount();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이소민 예방접종</title>
<link href="index.css" rel="stylesheet">
</head>
<body>

	<header>
		<h1>(과정평가형 정보처리산업기사)예방접종 프로그램 ver 2022-11</h1>
	</header>
	
	<nav>
		<ul>
			<li><a href="고객조회.jsp">고객조회</a></li>
			<li><a href="예방접종등록.jsp">예방접종등록</a></li>
			<li><a href="접종이력조회.jsp">접종이력조회</a></li>
			<li><a href="백신접종건수.jsp" class="click">백신접종건수</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	
	<section>
		<div style="height:50px;"></div>
		<table>
			<colgroup>
				<col style="width: 30%">
				<col style="width: 35%">
				<col style="width: 35%">
			</colgroup>
			
			<tr>
				<th>백신코드</th>
				<th>백신주사명</th>
				<th>백신별접종건수</th>
			</tr>
			<%for(int i=0;i<arr.size();i++) {%>
				<tr>
					<td><%=arr.get(i).getI_code() %></td>
					<td><%=arr.get(i).getI_name() %></td>
					<td><%=arr.get(i).getCount() %></td>
				</tr>
			<%} %>
		</table>
	</section>
	
	<footer>
		<h4>HRDKOREA Copyright &copy; All rights Reserved. Human Resources Development Service of Korea.</h4>
	</footer>

</body>
</html>