<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%@ page import="dto.*" %>
<%
	BookDao dao = new BookDao();
	ArrayList<BookDto> arr = dao.memberList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="Index.css" rel="stylesheet">
<title>이소민</title>
</head>
<body>
	<header>
		<h1>(과정평가형정보처리산업기사)도서대여 프로그램</h1>
	</header>
	<nav>
		<ul>
			<li><a href="memberList.jsp">회원조회</a></li>
			<li><a href="bookRentSave.jsp">도서대여등록</a></li>
			<li><a href="bookRentlist.jsp">대여이력조회</a></li>
			<li><a href="bookRentCount.jsp">도서대여건수</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	<section>
		<h2>회원 조회</h2>
		<table>
			<colgroup>
				<col style="width: 10%;">
				<col style="width: 11%;">
				<col style="width: 23%;">
				<col style="width: 10%;">
				<col style="width: 23%;">
				<col style="width: 23%;">
			</colgroup>
			<tr>
				<th>회원번호</th>
				<th>회원명</th>
				<th>생년월일</th>
				<th>성별</th>
				<th>전화번호</th>
				<th>회원가입일</th>
			</tr>
			<%for(int i=0; i<arr.size(); i++) {%>
			<tr>
				<td><%=arr.get(i).getP_no() %></td>
				<td><%=arr.get(i).getP_name() %></td>
				<td><%=arr.get(i).getP_birth() %></td>
				<td><%=arr.get(i).getP_gender() %></td>
				<td><%=arr.get(i).getP_tel() %></td>
				<td><%=arr.get(i).getP_reg_date() %></td>
			</tr>
			<%} %>
		</table>
	</section>
	<footer>
		<p>HRDKOREA Copyright &copy; All rights Reserved. Human Resources Development Service of Korea.</p>
	</footer>
</body>
</html>