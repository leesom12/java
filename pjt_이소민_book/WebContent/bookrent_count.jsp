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
		<h2>도서별 대여 건수</h2>
		<table>
			<colgroup>
				<col style="width:17.5%">
				<col style="width:47.5%">
				<col style="width:17.5%">
				<col style="width:17.5%">
			</colgroup>
			<thead>
				<tr>
					<th>도서코드</th>
					<th>도서명</th>
					<th>출판사</th>
					<th>대여건수</th>
				</tr>
				<tr>
					<td>B001</td>
					<td>2주 열심히하면 자격증 딸수있따</td>
					<td>제이에스엘</td>
					<td>5</td>
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