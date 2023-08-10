<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서대여관리</title>
<link href="BookRent.css" rel="stylesheet" >
</head>

<script type="text/javascript">
	function goSave(){
		if(book.t_memNum.value==""){
			alert("회원번호가 입력되지 않았습니다!");
			return;
		}
		if(book.t_bookCode.value==""){
			alert("도서코드가 입력되지 않았습니다!");
			return;
		}
		if(book.t_rentDate.value==""){
			alert("대여일자가 입력되지 않았습니다!");
			return;
		}
	}
</script>

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
	<section class="bookrent_save">
		<h2>도서 대여 등록</h2>
		<form name="book">
		<table>
			<colgroup>
				<col style="width:30%">
				<col style="width:70%">
			</colgroup>
			<thead>
				<tr>
					<td>대여번호(자동발생)</td>
					<td class="input"><input readonly value="20200011" name="t_rentNum"></td>
				</tr>
				<tr>
					<td>회원번호</td>
					<td class="input"><input value="" name="t_memNum"></td>
				</tr>
				<tr>
					<td>도서코드</td>
					<td class="input"><input value="" name="t_bookCode"></td>
				</tr>
				<tr>
					<td>도서대여일자</td>
					<td class="input"><input value="" name="t_rentDate"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" onclick="goSave()">등록</button>
						<button type="reset">다시쓰기</button>
					</td>
				</tr>
			</thead>
		</table>
		</form>
	</section>
	
	<!-- 푸터 -->
	<footer>
		<h4>HRDKOREA Copyright &copy; All rights Reserved. Human Resources Development Service of Korea.</h4>
	</footer>
</body>
</html>