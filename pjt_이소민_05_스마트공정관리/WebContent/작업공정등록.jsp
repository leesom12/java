<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이소민_스마트공정</title>
<link href="index.css" rel="stylesheet">
</head>

<script type="text/javascript">
	function goSave(){
		if(smart.w_workno.value==""){
			alert("작업지시번호가 입력되지 않았습니다!");
			smart.w_workno.focus();
			return;
		}
		if(smart.p1.value==""){
			alert("재료준비항목이 선택되지 않았습니다!");
			smart.p1.focus();
			return;
		}
		if(smart.p2.value==""){
			alert("인쇄공정 항목이 선택되지 않았습니다!");
			smart.p2.focus();
			return;
		}
		if(smart.p3.value==""){
			alert("코팅공정 항목이 선택되지 않았습니다!");
			smart.p3.focus();
			return;
		}
		if(smart.w_lastdate.value==""){
			alert("최종작업일자가 입력되지 않았습니다!");
			smart.w_lastdate.focus();
			return;
		}
		if(smart.w_lasttime.value==""){
			alert("최종작업시간이 입력되지 않았습니다!");
			smart.w_lasttime.focus();
			return;
		}
		
		smart.method="post";
		smart.action="DbProcessSave.jsp";
		smart.submit();
	}
	
	function goUpdate(){
		if(smart.w_workno.value==""){
			alert("작업지시번호가 입력되지 않았습니다!");
			smart.w_workno.focus();
			return;
		}
		if(smart.p1.value==""){
			alert("재료준비항목이 선택되지 않았습니다!");
			smart.p1.focus();
			return;
		}
		if(smart.p2.value==""){
			alert("인쇄공정 항목이 선택되지 않았습니다!");
			smart.p2.focus();
			return;
		}
		if(smart.p3.value==""){
			alert("코팅공정 항목이 선택되지 않았습니다!");
			smart.p3.focus();
			return;
		}
		if(smart.w_lastdate.value==""){
			alert("최종작업일자가 입력되지 않았습니다!");
			smart.w_lastdate.focus();
			return;
		}
		if(smart.w_lasttime.value==""){
			alert("최종작업시간이 입력되지 않았습니다!");
			smart.w_lasttime.focus();
			return;
		}
		
		smart.method="post";
		smart.action="DbProcessUpdate.jsp";
		smart.submit();
	}
	
	function goReset(){
		alert("정보를 지우고 처음부터 다시 입력 합니다!");
		smart.reset();
		smart.w_workno.focus();
	}
	
</script>

<body>

	<header>
		<h1>(과정형평가 정보처리산업기사)스마트공장 공정관리 프로그램 ver2019-09</h1>
	</header>
	<nav>
		<ul>
			<li><a href="제품조회.jsp">제품조회</a></li>
			<li><a href="작업지시조회.jsp">작업지시조회</a></li>
			<li><a href="작업지시등록.jsp">작업지시등록</a></li>
			<li><a href="작업공정등록.jsp">작업공정등록</a></li>
			<li><a href="작업공정조회.jsp">작업공정조회</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	<section>
		<h2>작업 공정 등록</h2>
		<form name="smart">
			<table class="save">
				<colgroup>
					<col width="30%">
					<col width="70%">
				</colgroup>
				<tr>
					<th>작업지시번호</th>
					<td class="input"><input type="text" name="w_workno" value=""></td>
				</tr>
				<tr>
					<th>재료준비</th>
					<td>
						<input type="radio" name="p1" value="Y"> 완료
						<input type="radio" name="p1" value="N"> 작업중
					</td>
				</tr>
				<tr>
					<th>인쇄공정</th>
					<td>
						<input type="radio" name="p2" value="Y"> 완료
						<input type="radio" name="p2" value="N"> 작업중
					</td>
				</tr>
				<tr>
					<th>코팅공정</th>
					<td>
						<input type="radio" name="p3" value="Y"> 완료
						<input type="radio" name="p3" value="N"> 작업중
					</td>
				</tr>
				<tr>
					<th>최종작업일자</th>
					<td class="input"><input type="text" name="w_lastdate" value=""></td>
				</tr>
				<tr>
					<th>최종작업시간</th>
					<td class="input"><input type="text" name="w_lasttime" value=""></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" onclick="goSave()">공정등록</button>
						<button type="button" onclick="goUpdate()">공정수정</button>
						<button type="button" onclick="goReset()">다시쓰기</button>
					</td>
				</tr>

			</table>
		</form>
	</section>
	<footer>
		<h4>HRDKOREA Copyright &copy; All rights Reserved. Human Resources Development Service of Korea.</h4>
	</footer>
	
</body>
</html>