<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="track.*" %>
<%
	Dao dao = new Dao();
	ArrayList<Sub3Dto> arr = dao.getRank();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="index.css" rel="stylesheet">
<title>이소민_국악경연</title>
</head>

<script type="text/javascript">

</script>

<body>
	<header>
		<h1>(과정평가형 정보처리산업기사)국악경연프로그램 ver 2021-06</h1>
	</header>
	<nav>
		<ul>
			<li><a href="경연점수등록.jsp">경연점수등록</a></li>
			<li><a href="경연결과조회.jsp">경연결과조회</a></li>
			<li><a href="최종등수조회.jsp">최종등수조회</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	<section>
		<h2>최종등수조회</h2>
		<table >
			<colgroup>
				<col width="15%">
				<col width="15%">
				<col width="20%">
				<col width="13%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="7%">
			</colgroup>
			
			<tr>
				<th>참가번호</th>
				<th>성명</th>
				<th>생년월일</th>
				<th>참가부문</th>
				<th>지역</th>
				<th>총점</th>
				<th>평균</th>
				<th>등수</th>
			</tr>
			<%for(Sub3Dto dto: arr) {%>
			<tr>
				<td><%=dto.getEntry_no() %></td>
				<td><%=dto.getEntry_name() %>(<%=dto.getEntry_gender() %>)</td>
				<td><%=dto.getEntry_birth()%></td>
				<td><%=dto.getEntry_type() %></td>
				<td><%=dto.getEntry_area() %></td>
				<td><%=dto.getS_tot() %></td>
				<td><%=dto.getS_ave() %></td>
				<td><%=dto.getRank() %></td>
			</tr>
			<%} %>
			
		</table>
	</section>
	<footer>
		<h4>HRDKOREA Copyright &copy; 2021 All Rights reserved. Human Development Service of Korea.</h4>
	</footer>
</body>
</html>