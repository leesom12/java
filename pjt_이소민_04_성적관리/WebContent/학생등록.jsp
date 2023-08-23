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
		if(student.sname.value==""){
			alert("이름이 입력되지 않았습니다!");
			student.sname.focus();
			return;
		}
		if(student.birth.value==""){
			alert("생년월일이 입력되지 않았습니다!");
			student.birth.focus();
			return;
		}
		if(student.gender.value==""){
			alert("성별을 선택하세요!");
			student.gender.focus();
			return;
		}
		if(student.tel1.value==""){
			alert("전화번호가 입력되지 않았습니다!");
			student.tel1.focus();
			return;
		}
		if(student.tel2.value==""){
			alert("전화번호가 입력되지 않았습니다!");
			student.tel2.focus();
			return;
		}
		if(student.tel3.value==""){
			alert("전화번호가 입력되지 않았습니다!");
			student.tel3.focus();
			return;
		}
		
		student.method="post";
		student.action="DbStudentSave.jsp";
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
			<li><a href="학생등록.jsp" class="click">학생등록</a></li>
			<li><a href="성적입력.jsp">성적입력</a></li>
			<li><a href="성적조회.jsp">성적조회</a></li>
			<li><a href="반별통계.jsp">반별통계</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</nav>
	
	<section>
		<h2>학생 등록</h2>
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
				<th>이름</th>
				<td class="input"><input name="sname" value=""></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td class="input"><input name="birth" value=""></td>
			</tr>
			<tr>
				<th>성별</th>
				<td class="input">
					<input class="radio" type="radio" name="gender" value="M"> 남성
					<input class="radio" type="radio" name="gender" value="F"> 여성
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td class="tel">
					<input name="tel1" value=""> -
					<input name="tel2" value=""> -
					<input name="tel3" value="">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" onclick="goSave()">학생등록</button>
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