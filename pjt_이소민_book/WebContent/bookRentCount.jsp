<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%@ page import="dto.*" %>
<%
	BookDao dao = new BookDao();
	ArrayList<BookDto> arr = dao.bookList();
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
		<h2>도서별 대여 건수</h2>
		<table>
			<colgroup>
				<col style="width: 15%;">
				<col style="width: 50%;">
				<col style="width: 20%;">
				<col style="width: 15%;">
			</colgroup>
			<tr>
				<th>도서코드</th>
				<th>도서명</th>
				<th>출판사</th>
				<th>대여건수</th>
			</tr>
			<%for(int i=0; i<arr.size(); i++) {%>
				<tr>
					<td><%=arr.get(i).getB_code() %></td>
					<td><%=arr.get(i).getB_name() %></td>
					<td><%=arr.get(i).getB_publisher() %></td>
					<td><%=dao.getRentNum(arr.get(i).getB_code()) %></td>
				</tr>
			<%} %>
		</table>
	</section>
	<footer>
		<p>HRDKOREA Copyright &copy; All rights Reserved. Human Resources Development Service of Korea.</p>
	</footer>
</body>
</html>