<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	OlympicDao dao = new OlympicDao();
	ArrayList<Sub4Dto> arr = dao.getRank();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이소민_올림픽</title>
<link href="index.css" rel="stylesheet">
</head>
<body>

	<header>
		<h1>(과정평가형정보처리산업기사)올림픽 체조경기 관리 프로그램 ver2021-08</h1>
	</header>
	<nav>
		<ul>
			<li><a href="참가자목록조회.jsp">참가자목록조회</a></li>
			<li><a href="심사점수등록.jsp">심사점수등록</a></li>
			<li><a href="심사점수조회.jsp">심사점수조회</a></li>
			<li><a href="참가자등수조회.jsp">참가자등수조회</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	<section>
		<h2>참가자 등수 조회</h2>
		<table>
			<colgroup>
				<col width="10%">
				<col width="15%">
				<col width="15%">
				<col width="20%">
				<col width="10%">
				<col width="20%">
				<col width="10%">
			</colgroup>
			<tr>
				<th>선수번호</th>
				<th>선수명</th>
				<th>국적</th>
				<th>기술난이도</th>
				<th>총점</th>
				<th>평균</th>
				<th>등수</th>
			</tr>
			<%for(int i=0;i<arr.size();i++) {%>
				<tr>
					<td><%=arr.get(i).getPlayer_no() %></td>
					<td><%=arr.get(i).getName() %></td>
					<td><%=arr.get(i).getNation_name() %></td>
					<td><%=arr.get(i).getSkill_name() %></td>
					<td><%=arr.get(i).getTotal()%></td>
					<td><%=arr.get(i).getAve() %></td>
					<td><%=arr.get(i).getRnum() %></td>
				</tr>
			<%} %>
		</table>
	</section>
	<footer>
		<h4>HRDKOREA Copyright &copy; All rights Reserved. Human Resources Development Service of Korea.</h4>
	</footer>

</body>
</html>