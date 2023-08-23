<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이소민_성적관리</title>
<link href="index.css" rel="stylesheet">
</head>
<script type="text/javascript">
	function goSave(){
		if(student.syear.value==""){
			alert("학년정보가 입력되지 않았습니다!");
			student.syear.focus();
			return;
		}
		if(student.sclass.value==""){
			alert("반정보가 입력되지 않았습니다!");
			student.sclass.focus();
			return;
		}
		if(student.sno.value==""){
			alert("번호정보가 입력되지 않았습니다!");
			student.sno.focus();
			return;
		}
		if(student.kor.value==""){
			alert("국어성적이 입력되지 않았습니다!");
			student.kor.focus();
			return;
		}
		if(student.eng.value==""){
			alert("영어성적이 입력되지 않았습니다!");
			student.eng.focus();
			return;
		}
		if(student.mat.value==""){
			alert("수학성적이 입력되지 않았습니다!");
			student.mat.focus();
			return;
		}

		
		student.method="post";
		student.action="DbScoreSave.jsp";
		student.submit();
	}
	
	function goReset(){
		alert("정보를 지우고 처음부터 다시 입력합니다!");
		student.reset();
		student.syear.focus();
	}
</script>
<body>

	<header>
		<h1>(과정평가형 정보처리산업기사)고교성적관리 프로그램 ver2019-06</h1>
	</header>
	
	<nav>
		<ul>
			<li><a href="학생등록.jsp">학생등록</a></li>
			<li><a href="성적입력.jsp" class="click">성적입력</a></li>
			<li><a href="성적조회.jsp">성적조회</a></li>
			<li><a href="반별통계.jsp">반별통계</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	
	<section>
		<h2>성적 입력</h2>
		<form name="student">
		<table>
			<colgroup>
				<col width="35%;">
				<col width="65%;">
			</colgroup>
			<tr>
				<th>학년</th>
				<td class="input"><input name="syear" value="">(예)1</td>
			</tr>
			<tr>
				<th>반</th>
				<td class="input"><input name="sclass" value="">(예)01</td>
			</tr>
			<tr>
				<th>번호</th>
				<td class="input"><input name="sno" value="">(예)01</td>
			</tr>
			<tr>
				<th>국어</th>
				<td class="input"><input name="kor" value="">점수범위(0~100)</td>
			</tr>
			<tr>
				<th>영어</th>
				<td class="input"><input name="eng" value="">점수범위(0~100)</td>
			</tr>
			<tr>
				<th>수학</th>
				<td class="input"><input name="mat" value="">점수범위(0~100)</td>
			</tr>

			<tr>
				<td colspan="2">
					<button type="button" onclick="goSave()">성적저장</button>
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