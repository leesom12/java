<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이소민 예방접종</title>
<link href="index.css" rel="stylesheet">
</head>
<script type="text/javascript">
	function goSave(){
		if(inj.p_seno.value==""){
			alert("예방접종이력번호가 입력되지 않았습니다!");
			inj.p_seno.focus();
			return;
		}
		if(inj.p_no.value==""){
			alert("고객번호가 입력되지 않았습니다!");
			inj.p_no.focus();
			return;
		}
		if(inj.i_code.value==""){
			alert("백신코드가 입력되지 않았습니다!");
			inj.i_code.focus();
			return;
		}
		if(inj.p_date.value==""){
			alert("접종일자가 입력되지 않았습니다!");
			inj.p_date.focus();
			return;
		}
		
		inj.method="post";
		inj.action="DBinjSave.jsp";
		inj.submit();
	}
	
	function goReset(){
		alert("정보를 지우고 처음부터 다시 입력 합니다");
		inj.reset();
		inj.p_seno.focus();
	}
</script>
<body>

	<header>
		<h1>(과정평가형 정보처리산업기사)예방접종 프로그램 ver 2022-11</h1>
	</header>
	
	<nav>
		<ul>
			<li><a href="고객조회.jsp">고객조회</a></li>
			<li><a href="예방접종등록.jsp" class="click">예방접종등록</a></li>
			<li><a href="접종이력조회.jsp">접종이력조회</a></li>
			<li><a href="백신접종건수.jsp">백신접종건수</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	
	<section>
		<div style="height:50px;"></div>
		<form name="inj">
		<table>
			<colgroup>
				<col style="width: 40%">
				<col style="width: 60%">
			</colgroup>
			
			<tr>
				<th>예방접종이력번호</th>
				<td class="input"><input type="text" name="p_seno" value=""></td>
			</tr>
			<tr>
				<th>고객번호</th>
				<td class="input"><input type="text" name="p_no" value=""></td>
			</tr>
			<tr>
				<th>백신코드</th>
				<td class="input"><input type="text" name="i_code" value=""></td>
			</tr>
			<tr>
				<th>접종일자</th>
				<td class="input"><input type="text" name="p_date" value=""></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" onclick="goSave()">예방접종등록</button>
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