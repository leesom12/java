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
	function goSave(){
		if(seat.resvno.value==""){
			alert("예약번호가 입력되지 않았습니다!");
			seat.resvno.focus();
			return;
		}
		if(seat.empno.value==""){
			alert("사원번호가 입력되지 않았습니다!");
			seat.empno.focus();
			return;
		}
		if(seat.resvdate.value==""){
			alert("근무일자가 입력되지 않았습니다!");
			seat.resvdate.focus();
			return;
		}
		if(seat.seatno.value==""){
			alert("좌석번호가 입력되지 않았습니다!");
			seat.seatno.focus();
			return;
		}
		
		seat.method="post";
		seat.action="DBContractSave.jsp";
		seat.submit();
	}
	
	function goReset(){
		alert("정보를 지우고 처음부터 다시 입력 합니다.");
		seat.reset();
		seat.resvno.focus();
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
		<h2>근무좌석예약</h2>
		<table class="save">
			<colgroup>
				<col width="30%">
				<col width="70%">
			</colgroup>
			<form name="seat">
				<tr>
					<th>근무좌석예약</th>
					<td><input name="resvno" value="">예)20210001</td>
				</tr>
				<tr>
					<th>사원번호</th>
					<td><input name="empno" value="">예)1001</td>
				</tr>
				<tr>
					<th>근무일자</th>
					<td><input name="resvdate" value="">예)20211231</td>
				</tr>
				<tr>
					<th>좌석번호</th>
					<td><input name="seatno" value="">예)S001~S009</td>
				</tr>
			</form>
				<tr>
					<td colspan="2" style="text-align: center;">
						<button onclick="goSave()">등록</button>
						<button onclick="goReset()">다시쓰기</button>
					</td>
				</tr>
		</table>
	</section>
	<footer>
		<h4>HRDKOREA Copyright &copy; 2021 All Rights reserved. Human Development Service of Korea.</h4>
	</footer>
</body>
</html>