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
	function goSave(){
		if(tbl.entry_no.value==""){
			alert("참가번호가 입력되지 않았습니다!");
			tbl.entry_no.focus();
			return;
		}
		if(tbl.score1.value==""){
			alert("심사위원 점수가 입력되지 않았습니다!");
			tbl.score1.focus();
			return;
		}
		if(tbl.score1.value>100 || tbl.score1.value<0){
			alert("0~100 사이의 점수로 입력하세요!");
			tbl.score1.focus();
			return;
		}
		if(tbl.score2.value==""){
			alert("심사위원 점수가 입력되지 않았습니다!");
			tbl.score2.focus();
			return;
		}
		if(tbl.score2.value>100 || tbl.score2.value<0){
			alert("0~100 사이의 점수로 입력하세요!");
			tbl.score2.focus();
			return;
		}
		if(tbl.score3.value==""){
			alert("심사위원 점수가 입력되지 않았습니다!");
			tbl.score3.focus();
			return;
		}
		if(tbl.score3.value>100 || tbl.score3.value<0){
			alert("0~100 사이의 점수로 입력하세요!");
			tbl.score3.focus();
			return;
		}
		if(tbl.score4.value==""){
			alert("심사위원 점수가 입력되지 않았습니다!");
			tbl.score4.focus();
			return;
		}
		if(tbl.score4.value>100 || tbl.score4.value<0){
			alert("0~100 사이의 점수로 입력하세요!");
			tbl.score4.focus();
			return;
		}
		if(tbl.score5.value==""){
			alert("심사위원 점수가 입력되지 않았습니다!");
			tbl.score5.focus();
			return;
		}
		if(tbl.score5.value>100 || tbl.score5.value<0){
			alert("0~100 사이의 점수로 입력하세요!");
			tbl.score5.focus();
			return;
		}
		
		tbl.method="post";
		tbl.action="DBRecordSave.jsp";
		tbl.submit();
	}
	
	
	function goReset(){
		alert("정보를 지우고 처음부터 다시 입력 합니다");
		tbl.reset();
		tbl.entry_no.focus();
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
		<h2>경연점수등록</h2>
		<table class="save">
			<colgroup>
				<col width="35%">
				<col width="65%">
			</colgroup>
			<form name="tbl">
			<tr>
				<th>참가번호</th>
				<td><input name="entry_no" value="">예)0001</td>
			</tr>
			<tr>
				<th>심사위원</th>
				<td>심사점수(1~100)</td>
			</tr>
			<tr>
				<th>김심사</th>
				<td><input name="score1" value="">점</td>
			</tr>
			<tr>
				<th>이심사</th>
				<td><input name="score2" value="">점</td>
			</tr>
			<tr>
				<th>박심사</th>
				<td><input name="score3" value="">점</td>
			</tr>
			<tr>
				<th>황심사</th>
				<td><input name="score4" value="">점</td>
			</tr>
			<tr>
				<th>조심사</th>
				<td><input name="score5" value="">점</td>
			</tr>
			</form>
			<tr>
				<td colspan="2">
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