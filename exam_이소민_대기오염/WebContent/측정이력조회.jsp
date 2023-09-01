<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="track.*" %>
<%
	Dao dao = new Dao();
	ArrayList<Sub3Dto> arr = dao.getTestList();
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
		<h2>측정이력조회</h2>
		<table>
			<colgroup>
				<col width="20%">
				<col width="10%">
				<col width="12.5%">
				<col width="12.5%">
				<col width="13%">
				<col width="14.5%">
				<col width="7.5%">
			</colgroup>
			<tr>
				<th>관측일자</th>
				<th>측정시기</th>
				<th>대기오염코드</th>
				<th>관측지점번호</th>
				<th>관측지점명</th>
				<th>권역지역명</th>
				<th>측정값</th>
			</tr>
			<%for(Sub3Dto dto : arr) {%>
				<tr>
					<td><%=dto.getTest_date() %></td>
					<td><%=dto.getTest_ampm() %></td>
					<td><%=dto.getPollution() %></td>
					<td><%=dto.getCity_code() %></td>
					<td><%=dto.getCity_name() %></td>
					<td><%=dto.getArea_name() %></td>
					<td><%=dto.getTest_value() %></td>
				</tr>
			<%} %>
		</table>
		
	</section>
	<footer>
		<h4>HRDK 한국산업인력공단 Copyright &copy; 2020 All rights reserved. Human Resources Development Service of Korea.</h4>
	</footer>
</body>
</html>