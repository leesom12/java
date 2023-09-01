<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="track.*" %>
<%
	Dao dao = new Dao();
	ArrayList<Sub4Dto> arr = dao.getAreaAverage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="index.css" rel="stylesheet">
<title>이소민_대기오염</title>
</head>
<body>
	<header>
		<h1>(과정평가형 정보처리산업기사)대기오염관측 프로그램  ver2020-05</h1>
	</header>
	<nav>
		<ul>
			<li><a href="관측지점조회.jsp">관측지점조회</a></li>
			<li><a href="대기오염측정등록.jsp">대기오염측정등록</a></li>
			<li><a href="측정이력조회.jsp">측정이력조회</a></li>
			<li><a href="지역별관측조회.jsp">지역별관측조회</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	<section>
		<h2>지역별관측조회</h2>
		<table>
			<colgroup>
				<col width="30%">
				<col width="24%">
				<col width="23%">
				<col width="23%">
			</colgroup>
			<tr>
				<th>관측일자</th>
				<th>관측지점명</th>
				<th>일평균수치</th>
				<th>상태</th>
			</tr>
			<%for(Sub4Dto dto : arr) {%>
				<tr>
					<td><%=dto.getTest_date() %></td>
					<td><%=dto.getCity_name() %></td>
					<td><%=dto.getAvg() %></td>
					<td><%=dto.getStat() %></td>
				</tr>
			<%} %>
		</table>
		
	</section>
	<footer>
		<h4>HRDK 한국산업인력공단 Copyright &copy; 2020 All rights reserved. Human Resources Development Service of Korea.</h4>
	</footer>
</body>
</html>