<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="index.css" rel="stylesheet">
<title>이소민_대기오염</title>
</head>
<script type="text/javascript">
	function goSave(){
		if(pol.test_date.value==""){
			alert("관측일자가 입력되지 않았습니다!");
			pol.test_date.focus();
			return;
		}
		if(pol.test_ampm.value==""){
			alert("측정시기가 선택되지 않았습니다!");
			pol.test_ampm.focus();
			return;
		}
		if(pol.pollution.value==""){
			alert("대기오염코드가 입력되지 않았습니다!");
			pol.pollution.focus();
			return;
		}
		if(pol.city_code.value==""){
			alert("관측지점번호가 선택되지 않았습니다!");
			pol.city_code.focus();
			return;
		}
		if(pol.test_value.value==""){
			alert("측정값이 입력되지 않았습니다!");
			pol.test_value.focus();
			return;
		}
		
		pol.method="post";
		pol.action="DbTestSave.jsp";
		pol.submit();
	}
	
	function goReset(){
		alert("정보를 지우고 처음부터 다시 입력 합니다.");
		pol.reset();
		pol.test_date.focus();
	}
</script>
<body>
	<header>
		<h1>(과정평가형 정보처리산업기사)대기오염관측 프로그램  ver2020-05</h1>
	</header>
	<nav>
		<ul>
			<li><a href="관측지점조회.jsp">관측지점조회</a></li>
			<li><a href="대기오염측정등록.jsp">대기오염측정등록</a></li>
			<li><a href="측정이력조회.jsp">측정이력조회</a></li>
			<li><a href="지역별관측조회.jsp">지역별관측조회</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	<section>
		<h2>대기오염측정등록</h2>
		<table class="save">
			<colgroup>
				<col width="30%">
				<col width="70%">
			</colgroup>
			<form name="pol">
			<tr>
				<th>관측일자</th>
				<td><input name="test_date" value="">예)20200101</td>
			</tr>
			<tr>
				<th>측정시기</th>
				<td>
					<input type="radio" name="test_ampm" value="AM">오전(AM)
					<input type="radio" name="test_ampm" value="PM">오후(PM)
				</td>
			</tr>
			<tr>
				<th>대기오염코드</th>
				<td><input name="pollution" value="">(P1: 미세먼지, P2: 오존, P3: 자외선, P4: 황사)</td>
			</tr>
			<tr>
				<th>관측지점번호</th>
				<td>
					<select name="city_code">
						<option value="">관측지점</option>
						<option value="01">[01]서울</option>
						<option value="02">[02]경기</option>
						<option value="03">[03]인천</option>
						<option value="04">[04]세종</option>
						<option value="05">[05]대전</option>
						<option value="06">[06]대구</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>측정값</th>
				<td><input name="test_value" value=""></td>
			</tr>
			</form>
			<tr>
				<td colspan="2" style="text-align: center;">
					<button onclick="goSave()">측정값 등록</button>
					<button onclick="goReset()">다시쓰기</button>
				</td>
			</tr>
		</table>
		
	</section>
	<footer>
		<h4>HRDK 한국산업인력공단 Copyright &copy; 2020 All rights reserved. Human Resources Development Service of Korea.</h4>
	</footer>
</body>
</html>