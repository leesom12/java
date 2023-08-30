<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="track.*" %>
<%
	Dao dao = new Dao();
	ArrayList<SUb3Dto> arr = dao.getWorkCount();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="index.css" rel="stylesheet">
<title>이소민_자율좌석</title>
</head>
<script type="text/javascript">

</script>
<body>
	<header>
		<h1>(과정평가형 정보처리산업기사)자율좌석예약 프로그램 ver 2021-08</h1>
	</header>
	<nav>
		<ul>
			<li><a href="근무좌석예약.jsp">근무좌석예약</a></li>
			<li><a href="좌석예약조회.jsp">좌석예약조회</a></li>
			<li><a href="근무일수집계.jsp">근무일수집계</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	<section>
		<h2>부서별근무일수집계</h2>
		<table>
			<colgroup>
				<col width="25%">
				<col width="25%">
				<col width="25%">
				<col width="25%">
			</colgroup>
	
			<tr>
				<th>사원번호</th>
				<th>이름</th>
				<th>부서명</th>
				<th>근무일수</th>
			</tr>
			<%for(SUb3Dto dto : arr) {%>
			<tr>
				<td><%=dto.getEmpno() %></td>
				<td><%=dto.getEmpname() %></td>
				<td><%=dto.getDeptname() %></td>
				<td><%=dto.getCount() %></td>
			</tr>
			<%} %>
		</table>
	</section>
	<footer>
		<h4>HRDKOREA Copyright &copy; 2021 All Rights reserved. Human Development Service of Korea.</h4>
	</footer>
</body>
</html>