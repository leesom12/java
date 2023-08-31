<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="index.css" rel="stylesheet">
<title>이소민_국악경연</title>
</head>

<script type="text/javascript">
	function goResult(){
		if(tbl.entry_no.value==""){
			alert("참가번호가 입력되지 않았습니다!");
			tbl.entry_no.focus();
			return;
		}
		tbl.method="post";
		tbl.action="경연결과조회2.jsp";
		tbl.submit();
	}
</script>

<body>
	<header>
		<h1>(과정평가형 정보처리산업기사)국악경연프로그램 ver 2021-06</h1>
	</header>
	<nav>
		<ul>
			<li><a href="경연점수등록.jsp">경연점수등록</a></li>
			<li><a href="경연결과조회.jsp">경연결과조회</a></li>
			<li><a href="최종등수조회.jsp">최종등수조회</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	<section>
		<h2>경연결과조회</h2>
		<table class="save">
			<colgroup>
				<col width="60%">
				<col width="40%">
			</colgroup>
			<form name="tbl">
			<tr>
				<th>참가번호를 입력하시오.</th>
				<td><input name="entry_no" value=""></td>
			</tr>
			</form>
			<tr>
				<td colspan="2">
					<button onclick="goResult()">결과조회</button>
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