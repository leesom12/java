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
		<h2>대여 이력 조회</h2>
		<table>
			<colgroup>
				<col style="width:12.5%">
				<col style="width:12.5%">
				<col style="width:50%">
				<col style="width:12.5%">
				<col style="width:12.5%">
			</colgroup>
			<thead>
				<tr>
					<th>대여번호</th>
					<th>회원명</th>
					<th>도서명</th>
					<th>대여일자</th>
					<th>반납일자</th>
				</tr>
				<tr>
					<td>20200001</td>
					<td>[1001]김고객</td>
					<td>[B001]2주 열심히하면 자격증 딸수있따</td>
					<td>2020-08-01</td>
					<td>2020-08-02</td>
				</tr>
				<tr>
					<td>20200001</td>
					<td>[1001]김고객</td>
					<td>[B001]2주 열심히하면 자격증 딸수있따</td>
					<td>2020-08-01</td>
					<td>미납</td>
				</tr>
				<tr>
					<td>20200001</td>
					<td>[1001]김고객</td>
					<td>[B001]2주 열심히하면 자격증 딸수있따</td>
					<td>2020-08-01</td>
					<td>2020-08-02</td>
				</tr>
				<tr>
					<td>20200001</td>
					<td>[1001]김고객</td>
					<td>[B001]2주 열심히하면 자격증 딸수있따</td>
					<td>2020-08-01</td>
					<td>2020-08-02</td>
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