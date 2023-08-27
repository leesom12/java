<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	SmartDao dao = new SmartDao();
	ArrayList<Sub5Dto> arr = dao.getProcessList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="index.css" rel="stylesheet">
<title>이소민_09_스마트공정관리</title>
</head>
<body>
	
	<header>
		<h1>(과정형평가 정보처리산업기사)스마트공장 공정관리 프로그램 ver2019-09</h1>	
	</header>
	<nav>
		<ul>
			<li><a href="제품조회.jsp">제품조회</a></li>
			<li><a href="작업지시조회.jsp">작업지시조회</a></li>
			<li><a href="작업지시등록.jsp">작업지시등록</a></li>
			<li><a href="작업공정등록.jsp">작업공정등록</a></li>
			<li><a href="작업공정조희.jsp">작업공정조회</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	<section>
		<h2>작업공정조회</h2>
				<form name="smart">
			<table>
				<colgroup>
					<col width="15%">
					<col width="10%">
					<col width="25%">
					<col width="7%">
					<col width="7%">
					<col width="7%">
					<col width="16%">
					<col width="13%">
				</colgroup>
				<tr>
					<th>작업지시번호</th>
					<th>제품코드</th>
					<th>제품명</th>
					<th>준비</th>
					<th>인쇄</th>
					<th>코팅</th>
					<th>최종공정일자</th>
					<th>최종공정시간</th>
				</tr>
				<%for(Sub5Dto dto : arr) {%>
					<tr>
						<td><%=dto.getW_workno() %></td>
						<td><%=dto.getP_code() %></td>
						<td><%=dto.getP_name() %></td>
						<td><%=dto.getP_p1() %></td>
						<td><%=dto.getP_p2() %></td>
						<td><%=dto.getP_p3() %></td>
						<td><%=dto.getW_lastdate() %></td>
						<td><%=dto.getW_lasttime() %></td>
					</tr>
				<%} %>
			</table>
		</form>
	</section>
	<footer>
		<h4>HRDKOREA Copyright &copy; All rights Reserved. Human Resources Development Service of Korea.</h4>
	</footer>
	
</body>
</html>