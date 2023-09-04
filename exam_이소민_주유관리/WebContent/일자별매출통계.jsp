<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="track.*" %>
<%
	Dao dao = new Dao();
	ArrayList<Sub3Dto> arr = dao.getDaySale();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="index.css" rel="stylesheet">
<title>이소민_주유관리</title>
</head>
<body>
	
	<header>
		<h1>(과정평가형 정보처리산업기사)주유소 관리 프로그램 Ver 2020-10</h1>
	</header>
	<nav>
		<ul>
			<li><a href="매출등록.jsp">매출등록</a></li>
			<li><a href="전체매출조회.jsp">전체매출조회</a></li>
			<li><a href="일자별매출통계.jsp">일자별매출통계</a></li>
			<li><a href="index.jsp">홈</a></li>
		</ul>
	</nav>
	<section>
		<h2>일 매출통계</h2>
		<table style="width:70%;">
			<colgroup>
				<col width="30%">
				<col width="25%">
				<col width="20%">
				<col width="25%">
			</colgroup>
			<tr>
				<th>주유일자</th>
				<th>유종</th>
				<th>건수</th>
				<th>금액</th>
			</tr>
			<%for(Sub3Dto dto : arr) {%>
			<tr>
				<td><%=dto.getOildate() %></td>
				<td><%=dto.getOilname() %></td>
				<td><%=dto.getCount() %></td>
				<td style="text-align: right;"><%=dto.getCost() %></td>
			</tr>
			<%} %>
		</table>
	</section>
	<footer>
		<h4>HRDKOREA Copyright &copy; 2020 All rights reserve. Human Resources Development Service of Korea.</h4>
	</footer>

</body>
</html>