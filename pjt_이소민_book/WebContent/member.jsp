<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서대여관리</title>
<link href="BookRent.css" rel="stylesheet" >
</head>
<body>
	<!-- 헤더 -->
	<header class="header">
		<h1>(과정평가형정보처리산업기사)도서대여 프로그램</h1>
	</header>
	
	<!-- 메뉴 -->
	<nav>
		<ul class="main_menu">
			<li><a href="member.jsp">회원조회</a></li>
			<li><a href="bookrent_save.jsp">도서대여등록</a></li>
			<li><a href="bookrent_list.jsp">대여이력조회</a></li>
			<li><a href="bookrent_count.jsp">도서대여건수</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	
	<!-- 메인 -->
	<section class="member">
		<h2>회원 조회</h2>
		<table>
			<colgroup>
				<col style="width:13%">
				<col style="width:13%">
				<col style="width:19%">
				<col style="width:11%">
				<col style="width:22%">
				<col style="width:22%">
			</colgroup>
			<thead>
				<tr>
					<th>회원번호</th>
					<th>회원명</th>
					<th>생년월일</th>
					<th>성별</th>
					<th>전화번호</th>
					<th>회원가입일</th>
				</tr>
				<tr>
					<td>1001</td>
					<td>김고객</td>
					<td>1985년03월01일</td>
					<td>남자</td>
					<td>010-2222-0001</td>
					<td>2021-08-01</td>
				</tr>
				<tr>
					<td>1001</td>
					<td>김고객</td>
					<td>1985년03월01일</td>
					<td>남자</td>
					<td>010-2222-0001</td>
					<td>2021-08-01</td>
				</tr>
				<tr>
					<td>1001</td>
					<td>김고객</td>
					<td>1985년03월01일</td>
					<td>남자</td>
					<td>010-2222-0001</td>
					<td>2021-08-01</td>
				</tr>
			</thead>
		</table>
	</section>
	
	<!-- 푸터 -->
	<footer>
		<h4>HRDKOREA Copyright &copy; All rights Reserved. Human Resources Development Service of Korea.</h4>
	</footer>
</body>
</html>