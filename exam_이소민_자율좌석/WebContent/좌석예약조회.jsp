<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="index.css" rel="stylesheet">
<title>이소민_자율좌석</title>
</head>
<script type="text/javascript">
	function goList(){
		if(seat.empno.value==""){
			alert("사원번호가 입력되지 않았습니다!");
			seat.empno.focus();
			return;
		}
		seat.method="post";
		seat.action="좌석예약조회2.jsp";
		seat.submit();
	}
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
		<h2>좌석예약조회</h2>
		<table class="save">
			<colgroup>
				<col width="50%">
				<col width="50%">
			</colgroup>
			<form name="seat">
				<tr>
					<th>사원번호를 입력 하시오.</th>
					<td><input name="empno" value=""></td>
				</tr>
			</form>
				<tr>
					<td colspan="2" style="text-align: center;">
						<button onclick="goList()">좌석예약조회</button>
						<a href="index.jsp"><button>홈으로</button></a>
					</td>
				</tr>
		</table>
	</section>
	<footer>
		<h4>HRDKOREA Copyright &copy; 2021 All Rights reserved. Human Development Service of Korea.</h4>
	</footer>
</body>
</html>